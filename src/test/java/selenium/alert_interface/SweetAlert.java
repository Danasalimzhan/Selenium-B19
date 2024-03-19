package selenium.alert_interface;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.util.BrowserUtil;

import java.time.Duration;

public class SweetAlert {
    WebDriver driver;

    @BeforeMethod
    public void SweetAlert() {
        driver = new ChromeDriver();
        driver.get("https://sweetalert.js.org/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Alert is initializing");
    }

    @Test
    public void Alerts() throws InterruptedException {
        WebElement firstAlert = driver.findElement(By.xpath("//h5[contains(.,'Normal alert')]//following-sibling::button"));
        firstAlert.click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        String expectedText = "Oops, something went wrong!";
        Assert.assertEquals(actualText, expectedText, "Failed to validate JS Alert message");
        alert.accept();


        WebElement secondAlert = driver.findElement(By.xpath("//h5[contains(.,'SweetAlert')]//following-sibling::button"));
        secondAlert.click();

        WebElement secondAlertMessage = driver.findElement(By.xpath("//div[@class='swal-modal']//div[contains(.,'Something went wrong!')]"));
        Assert.assertEquals(BrowserUtil.BrowserUtils.getText(secondAlertMessage), "Something went wrong!");
        WebElement okBtn = driver.findElement(By.xpath("//button[.='OK']"));
        okBtn.click();
        Thread.sleep(3000);
    }

    @AfterMethod
    public  void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
