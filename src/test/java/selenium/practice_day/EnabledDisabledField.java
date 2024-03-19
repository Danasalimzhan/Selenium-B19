package selenium.practice_day;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.util.BrowserUtil;
import selenium.util.DriverHelper;

import java.util.List;

public class EnabledDisabledField {
    WebDriver driver;
    @BeforeMethod
    public void startUp(){
        driver = DriverHelper.getDriver();
        driver.get("https://formy-project.herokuapp.com/enabled");

    }

    @Test
    public void sendKeysTo(){
        WebElement disableInput = driver.findElement(By.cssSelector("#disabledInput"));
        disableInput.sendKeys("test");
    }

    @Test
    public void validateSendKeys(){
        List<WebElement> bothInputFields = driver.findElements(By.xpath("//input"));
        for(WebElement element : bothInputFields){
            if(element.isEnabled()){
                element.sendKeys("test");
            }
        }

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(3000);
        driver.quit();
    }







}
