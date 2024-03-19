package selenium.js_methods;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.util.BrowserUtil;
import selenium.util.DriverHelper;

import javax.swing.plaf.TableHeaderUI;

public class JSMethods {

    WebDriver driver;
    @BeforeMethod
    public  void initialize(){
        driver = DriverHelper.getDriver();
    }

    @Test
    public void getTitleWithJS(){
        driver.get("https://www.amazon.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String title = js.executeScript("return document.title").toString();
        System.out.println(title + " <-- title from amazon using JS Method");
    }

    @Test
    public void clickWithJS(){
        driver.get("https://codefish.io/");
        WebElement aboutUs = driver.findElement(By.xpath("//button[.='About us']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", aboutUs);

    }

    @Test
    public void scollIntoView(){
        driver.get("https://codefish.io/");
        WebElement fbLink = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/codefish.camp']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", fbLink);
    }

    @Test
    public void scrollWithPointJS(){
        driver.get("https://the-internet.herokuapp.com/");
        WebElement footerLink = driver.findElement(By.linkText("Elemental Selenium"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Point point = footerLink.getLocation();
        int x = point.getX();
        int y = point.getY();

        js.executeScript("window.scrollTo("+ x + ", "+ y + ")");

    }

    @Test
    public void testJS() throws InterruptedException {

        driver.get("https://www.yale.edu/");
        WebElement contactUs = driver.findElement(By.partialLinkText("Contact "));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", contactUs);
        Thread.sleep(2000);
        js.executeScript("arguments[0].click()", contactUs);
        Thread.sleep(1000);
        String actualTitleContactUs = js.executeScript("return document.title").toString();
        System.out.println(actualTitleContactUs);
        String expectedTitleContactUs = "Contact Us | Yale University";
        Assert.assertEquals(actualTitleContactUs, expectedTitleContactUs, "Failed to validate title");

        WebElement webEditorLink = driver.findElement(By.xpath("//a[/='Contact Web Editor']"));
        Point point = webEditorLink.getLocation();
        int xCoordinate = point.getX();
        int yCoordinate = point.getY();

        js.executeScript("window.scrollTo(" + xCoordinate + "," + yCoordinate +")");
        js.executeScript("arguments[0].click()", webEditorLink);
        Thread.sleep(2000);
        String titleWebEditor = js.executeScript("return document.title").toString();
        System.out.println(titleWebEditor);



    }

    @Test
    public void jsReusableMethods() throws InterruptedException {

        driver.get("https://www.yale.edu/");
        WebElement contactUs = driver.findElement(By.partialLinkText("Contact "));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", contactUs);
        BrowserUtil.BrowserUtils.scrollIntoViewJS(driver, contactUs);
        Thread.sleep(2000);

        BrowserUtil.BrowserUtils.clickWithJS(driver, contactUs);
        Thread.sleep(1000);
        String actualTitleContactUs = BrowserUtil.BrowserUtils.getTitleWithJS(driver);
        System.out.println(actualTitleContactUs);
        String expectedTitleContactUs = "Contact Us | Yale University";
        Assert.assertEquals(actualTitleContactUs, expectedTitleContactUs, "Failed to validate title");

        WebElement webEditorLink = driver.findElement(By.xpath("//a[/='Contact Web Editor']"));
        BrowserUtil.BrowserUtils.scrollWithPointJS(driver, webEditorLink);
        BrowserUtil.BrowserUtils.clickWithJS(driver, webEditorLink);
        js.executeScript("arguments[0].click()", webEditorLink);
        Thread.sleep(2000);
        String titleWebEditor = BrowserUtil.BrowserUtils.getTitleWithJS(driver);
        System.out.println(titleWebEditor);



    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
