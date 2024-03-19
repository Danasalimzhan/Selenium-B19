package selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import selenium.util.BrowserUtil;

import java.time.Duration;
import java.util.List;

public class NinjaTest {
    @Test
    public void CreateUser(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement firstName = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstName.sendKeys("Dana");

        WebElement lastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastName.sendKeys("Salimzhanova");

        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys("test@test.com");

        WebElement telephone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
        telephone.sendKeys("231098463");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("Qwer1234");

        WebElement passwordConfirmation = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        passwordConfirmation.sendKeys("Qwer1234");


        List<WebElement> radioBtn = (List<WebElement>) driver.findElement(By.cssSelector("//input[type='radio']"));
        for(int i = 0; i<radioBtn.size(); i++){
            if (BrowserUtil.BrowserUtils.getText(radioBtn.get(i)).equalsIgnoreCase("yes")){
                radioBtn.get(i).click();
                break;
            }
        }
        WebElement checkBox = driver.findElement(By.cssSelector("input[name='agree']"));
        if(!checkBox.isSelected()){
            checkBox.click();
        }
        WebElement continueBtn = driver.findElement(By.cssSelector("input[type='submit']"));
        continueBtn.click();








    }
}
