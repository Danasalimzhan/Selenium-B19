package selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.util.BrowserUtil;

import java.time.Duration;
import java.util.List;

public class TaskTestDiary {
    @Test
    public void test_Diary(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.testdiary.com/training/selenium/selenium-test-page/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement seleniumCheckBox = driver.findElement(By.xpath("#seleniumbox"));

        WebElement javaCheckBox = BrowserUtil.BrowserUtils.findElement(driver, By.cssSelector("#java1"));


        WebElement restAPICheckBox = BrowserUtil.BrowserUtils.findElement(driver, By.cssSelector("#restapibox"));
        restAPICheckBox.click();
        if(!seleniumCheckBox.isSelected()&&!javaCheckBox.isSelected()&&restAPICheckBox.isSelected()){
            seleniumCheckBox.click();
            javaCheckBox.click();
            restAPICheckBox.click();
        }


        List<WebElement> hyperLinks = (List<WebElement>) driver.findElement(By.xpath("//div[@id='header']//a[contains (text(),'Test Diary')]"));
        hyperLinks.get(0).click();

        WebElement testDiaryHeader = driver.findElement(By.xpath("//h1"));
        Assert.assertEquals(BrowserUtil.BrowserUtils.getText(testDiaryHeader), "Test Diary");
        driver.navigate().back();
        WebElement element = hyperLinks.get(1);
        element.click();
        WebElement seleniumHeader = driver.findElement(By.xpath("//h1"));
        Assert.assertEquals(BrowserUtil.BrowserUtils.getText(seleniumHeader),"Selenium");
        driver.navigate().back();

        WebElement shirtsDropDown = driver.findElement(By.cssSelector("#Shirts"));
        BrowserUtil.BrowserUtils.selectBy(shirtsDropDown, "Yellow", "visibleText");


        WebElement skirtsDropDown = driver.findElement(By.cssSelector("#Skirts"));
        BrowserUtil.BrowserUtils.selectBy(skirtsDropDown, "Red skirt", "visibleText");


        WebElement inputName = driver.findElement(By.name("your-name"));
        inputName.sendKeys("Dana");

        WebElement inputEmail = driver.findElement(By.name("your-email"));
        inputEmail.sendKeys("dana.1@gmail.com");

        WebElement inputSubject = driver.findElement(By.name("your-subject"));
        inputSubject.sendKeys("Hello");

        WebElement inputMessage = driver.findElement(By.name("your-message"));
        inputMessage.sendKeys("Good Morning");

        WebElement submitBtn = driver.findElement(By.xpath("//input[@type ='submit']"));
        submitBtn.click();

        WebElement successMessage =driver.findElement(By.xpath("//input[@type='submit']//..//following-sibling::div"));
        Assert.assertEquals(BrowserUtil.BrowserUtils.getText(successMessage), "Your message was sent successfully. Thanks.");











    }
}
