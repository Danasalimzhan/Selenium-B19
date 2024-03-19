package selenium.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import selenium.util.BrowserUtil;
import selenium.util.DriverHelper;

import java.time.Duration;

public class FluentWaits {

        @Test
        public void testFluentWait() {
            WebDriver driver = DriverHelper.getDriver();
            driver.get("https://the-internet.herokuapp.com/dynamic_controls");
            WebElement removeButton = driver.findElement(By.xpath("//button"));
            removeButton.click();

           // WebElement goneText = driver.findElement(By.xpath("//h4[.='Hello World']"));
            Wait<WebDriver> fluentWait = new FluentWait<>(driver).pollingEvery(Duration.ofSeconds(1)).withMessage("text on the page").withTimeout(Duration.ofSeconds(10));
            WebElement goneText = fluentWait.until(mydriver -> driver.findElement(By.xpath("//p[@id='message']")));
            System.out.println(BrowserUtil.BrowserUtils.getText(goneText));

        }

        @Test
    public void testFluentWait2(){
            WebDriver driver = DriverHelper.getDriver();
            driver.get("https://the-internet.herokuapp.com/dynamic_controls");
            WebElement enableBtn = driver.findElement(By.xpath("//button"));
            enableBtn.click();

            Wait<WebDriver> fluentWait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofSeconds(1))
                    .ignoring(ElementClickInterceptedException.class);
            WebElement input = driver.findElement(By.xpath("//input[@type='text']"));
            fluentWait.until(ExpectedConditions.elementToBeClickable(input)).sendKeys("Dana test1");

        }
    }


