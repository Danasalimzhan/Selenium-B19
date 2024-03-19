package selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.util.BrowserUtil;

import java.util.List;

public class XpathPractice_1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.lambdatest.com/selenium-playground/ajax-form-submit-demo");
        driver.manage().window().maximize();
        WebElement inputName = (WebElement) driver.findElements(By.xpath("//input[@id = 'title']"));
        inputName.sendKeys("Dana jdfirhirio foweifhhf jwfbjeirufbe");
       // WebElement inputMessage = driver.findElement(By.xpath("//textarea[@name='description']"));
      //  inputMessage.sendKeys("Hello");
        WebElement inputMessage = BrowserUtil.BrowserUtils.findElement(driver,By.xpath("//textarea[@name='description']"));
        inputMessage.sendKeys("wassap");

        WebElement inputSubmit = driver.findElement(By.xpath("//input[@id ='btn-submit']"));
        inputSubmit.click();

        WebElement submissionMessage = driver.findElement(By.id("submit-control"));
        System.out.println(submissionMessage.getText());








    }
}
