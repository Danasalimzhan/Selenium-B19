package selenium.iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import selenium.util.BrowserUtil;
import selenium.util.DriverHelper;

public class NestedIframes {

    WebDriver driver;

    @BeforeMethod
    public void initialize(){
        driver = DriverHelper.getDriver();

    }

    @Test
    public void testNestediframes(){
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://the-internet.herokuapp.com/frames");
        driver.findElement(By.linkText("Nested Frames")).click();
        BrowserUtil.BrowserUtils.switchDriverToIframe(driver, "frame-top");
        BrowserUtil.BrowserUtils.switchDriverToIframe(driver, "frame-left");
       // driver.switchTo().frame("frame-top");
        //driver.switchTo().frame("frame-left");
        WebElement textLeft = driver.findElement(By.xpath("//body[contains(.,'LEFT')]"));
        System.out.println(BrowserUtil.BrowserUtils.getText(textLeft));
        Assert.assertEquals(BrowserUtil.BrowserUtils.getText(textLeft), "LEFT");

       // driver.switchTo().parentFrame();
        //driver.switchTo().parentFrame();
        // driver.switchTo().frame("frame-bottom");
        WebElement textBottom = driver.findElement(By.xpath("//body[contains(.,'BOTTOM')]"));
        System.out.println(BrowserUtil.BrowserUtils.getText(textBottom));
        Assert.assertEquals(BrowserUtil.BrowserUtils.getText(textBottom), "BOTTOM");

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-right");
        WebElement textRight = driver.findElement(By.xpath("//body[contains(.,'RIGHT')]"));
        System.out.println(BrowserUtil.BrowserUtils.getText(textRight));
        Assert.assertEquals(BrowserUtil.BrowserUtils.getText(textRight), "RIGHT");

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        WebElement textMiddle = driver.findElement(By.xpath("//body[contains(.,'MIDDLE')]"));
        System.out.println(BrowserUtil.BrowserUtils.getText(textMiddle));
        Assert.assertEquals(BrowserUtil.BrowserUtils.getText(textMiddle), "MIDDLE");

    }

    @Test
    public void iFramePractice(){
        driver.get("https://www.lambdatest.com/selenium-playground/iframe-demo/");

        driver.switchTo().frame("iFrame1");
        WebElement textArea = driver.findElement(By.cssSelector("div[class='rsw-ce']"));
        textArea.clear();
        textArea.sendKeys("TEST TEST TEST");

        driver.switchTo().defaultContent();
        driver.switchTo().frame("iFrame2");
        WebElement automationButton = driver.findElement(By.cssSelector(".pagination-nav__label"));
        BrowserUtil.BrowserUtils.scrollToElement(driver, automationButton);
        BrowserUtil.BrowserUtils.clickWithJS(driver, automationButton);

        WebElement textOnNextPage = driver.findElement(By.xpath("//h1[.='Automation in LambdaTest']"));
        System.out.println(BrowserUtil.BrowserUtils.getText(textOnNextPage));

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
