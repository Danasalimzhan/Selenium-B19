package selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathTask {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/input-form-demo");
        driver.manage().window().maximize();
        WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
        name.sendKeys("Dana");
        WebElement email = driver.findElement(By.xpath("//input[@id='inputEmail4']"));
        email.sendKeys("Dana@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@id='inputPassword4']"));
        password.sendKeys("Qwer123");
        WebElement company = driver.findElement(By.xpath("//input[@id='company']"));
        company.sendKeys("DXC");
        WebElement webSite = driver.findElement(By.xpath("//input[@id='websitename']"));
        webSite.sendKeys("Dxc.com");
        WebElement city = driver.findElement(By.xpath("//input[@id='inputCity']"));
        city.sendKeys("Chicago");
        WebElement address1 = driver.findElement(By.xpath("//input[@id='inputAddress1']"));
        address1.sendKeys("100 Wells");
        WebElement address2 = driver.findElement(By.xpath("//input[@id='inputAddress2']"));
        address2.sendKeys("apt. 101");
        WebElement state = driver.findElement(By.xpath("//input[@id='inputState']"));
        state.sendKeys("Illinois");
        WebElement zipCode = driver.findElement(By.xpath("//input[@id='inputZip']"));
        zipCode.sendKeys("110110");
        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
        submitButton.click();










    }
}
