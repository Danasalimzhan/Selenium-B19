package selenium.upload_file;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.util.BrowserUtil;

import java.time.Duration;

public class UploadFile2 {
    WebDriver driver;
    @BeforeMethod
    public void initializeDriver(){
        driver = new ChromeDriver();
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement firstName = driver.findElement(By.cssSelector("input[name='firstname']"));
        firstName.sendKeys("Dana");

        WebElement lastName = driver.findElement(By.cssSelector("input[name='lastname']"));
        lastName.sendKeys("Sal");

        WebElement gender = driver.findElement(By.cssSelector("input[id='sex-1']"));
        gender.click();

        WebElement experience = driver.findElement(By.cssSelector("input[id='exp-4']"));
        experience.click();

        WebElement date = driver.findElement(By.cssSelector("input[id='datepicker']"));
        date.sendKeys("2/21/2024");

        WebElement profession = driver.findElement(By.cssSelector("input[id='profession-1']"));
        profession.click();

        WebElement continents = driver.findElement(By.cssSelector("#continents"));
        BrowserUtil.BrowserUtils.selectBy(continents, "North America", "visibleText");

        WebElement seleniumCommands = driver.findElement(By.cssSelector("#selenium_commands"));
        BrowserUtil.BrowserUtils.selectBy(seleniumCommands, "WebElement Command", "visibleText");
        WebElement uploadButton = driver.findElement(By.cssSelector("#photo"));
        uploadButton.sendKeys("C:\\Users\\salim\\Downloads\\sistalks poster.jpg");


    }
    @Test
    public void validateTitleHeaders(){
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.techlistic.com/p/selenium-practice-form.html";
        Assert.assertEquals(actualURL, expectedURL);
       WebElement header1 = driver.findElement(By.xpath("//h3[.='Demo Automation Practice Form']"));
       WebElement header2 = driver.findElement(By.xpath("//h2[.='AUTOMATION PRACTICE FORM']"));
       Assert.assertEquals(BrowserUtil.BrowserUtils.getText(header1), "Demo Automation Practice Form");
       Assert.assertEquals(BrowserUtil.BrowserUtils.getText(header2), "AUTOMATION PRACTICE FORM");




    }

    @AfterMethod
    public void  tearDown() throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }
}
