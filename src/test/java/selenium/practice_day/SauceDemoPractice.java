package selenium.practice_day;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.util.BrowserUtil;
import selenium.util.DriverHelper;

import java.util.Arrays;
import java.util.List;

public class SauceDemoPractice {
    WebDriver driver;
    @BeforeMethod
    public void initializeDriver(){
        driver = DriverHelper.getDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement userName = driver.findElement(By.cssSelector("input[id='user-name']"));
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.cssSelector("input[id='password']"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.cssSelector("input[id='login-button']"));
        loginButton.click();
    }
    @Test
    public void sauceDemoPractice() throws InterruptedException {
        WebElement sortDropdown = driver.findElement(By.xpath(".product_sort_container"));
        BrowserUtil.BrowserUtils.selectBy(sortDropdown, "Price (low to high)", "visibleText");
        List<WebElement> allPrices = driver.findElements(By.cssSelector(".inventory_item_price"));
        double[] actualPrices = new double[allPrices.size()];
        double[] sortedPrice = new double[allPrices.size()];

        for (int i = 0; i< allPrices.size(); i++){
            actualPrices[i] = Double.parseDouble(allPrices.get(i).getText().replace("$", ""));
            sortedPrice[i] = Double.parseDouble(allPrices.get(i).getText().replace("$", ""));
        }
        System.out.println(Arrays.toString(actualPrices));
        System.out.println(Arrays.toString(sortedPrice));

       for(int i =0; i < sortedPrice.length; i++){
            double temp = 0;
            for(int j =i+1; j<sortedPrice.length; j++){
                if(sortedPrice[i] > sortedPrice[j]){
                    temp = sortedPrice[i];
                    sortedPrice[i] = sortedPrice[j];
                    sortedPrice[j] = temp;
                }
            }

        }
        Assert.assertEquals(actualPrices, sortedPrice, "failed to validate");
    }
    @Test
    public void validateErrorMsg(){
        WebElement errorMessage = driver.findElement(By.xpath("//h3"));
        String actualText = BrowserUtil.BrowserUtils.getText(errorMessage);
        String expectedText = "Epic sadface: Sorry, this user has been locked out.";
        Assert.assertEquals(actualText, expectedText, "Failed to validate");


    }

    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
