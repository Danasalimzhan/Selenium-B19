package selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsBasics_2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/salim/Downloads/file3.html");
        driver.manage().window().maximize();
        WebElement firstName = driver.findElement(By.id("fname"));
        firstName.sendKeys("Bruce");
        WebElement lastName = driver.findElement(By.id("lname"));
        lastName.sendKeys("Banner");
        WebElement birthDate = driver.findElement(By.id("bdate"));
        birthDate.sendKeys("04/19/1996");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("Hulk@gmail.com");
        WebElement quantity = driver.findElement(By.id("quantity"));
        quantity.sendKeys("36");
        WebElement title = driver.findElement(By.id("title"));
        title.click();
        WebElement subscribe = driver.findElement(By.id("Subscribe"));
        subscribe.click();
        WebElement state = driver.findElement(By.id("state"));
        state.sendKeys("IL");
        WebElement text = driver.findElement(By.tagName("textarea"));
        text.sendKeys("Hello!");




    }
}
