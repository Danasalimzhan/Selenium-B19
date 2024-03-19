package selenium.window_handlers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.util.BrowserUtil;
import selenium.util.DriverHelper;

import java.util.Set;

public class WindowHandles {
    WebDriver driver;

    @BeforeMethod
    public void initialize() throws InterruptedException {
        driver = DriverHelper.getDriver();

    }

    @Test
            public void windowHandles() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement element = driver.findElement(By.linkText("Click Here"));
        BrowserUtil.BrowserUtils.clickWithJS(driver, element);
        String mainPageId = driver.getWindowHandle();
        Set<String> allWindowIds = driver.getWindowHandles();

        for(String singleWindow : allWindowIds){
            if(!mainPageId.equals(singleWindow)){
                driver.switchTo().window(singleWindow);
            }
        }
        Thread.sleep(1000);
        WebElement newWindowText = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtil.BrowserUtils.getText(newWindowText));

    }

    @Test
    public void windowSwitchPractice() throws InterruptedException {
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement newTab = driver.findElement(By.id("newTabBtn"));
        BrowserUtil.BrowserUtils.scrollWithPointJS(driver, newTab);
        BrowserUtil.BrowserUtils.clickWithJS(driver, newTab);

        String mainPageID = driver.getWindowHandle();
        Set<String> allIds = driver.getWindowHandles();
        for(String id : allIds){
            if(!id.equals(mainPageID)){
                driver.switchTo().window(id);
                break;
            }
        }
        Thread.sleep(2000);

        WebElement nextPageClickMe = driver.findElement(By.cssSelector("#alertBox"));
        BrowserUtil.BrowserUtils.scrollIntoViewJS(driver, nextPageClickMe);
        BrowserUtil.BrowserUtils.clickWithJS(driver, nextPageClickMe);
        Thread.sleep(2000);
        BrowserUtil.BrowserUtils.acceptAlert(driver);
    }

    @Test
    public void validateMultipleWindows() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");
        WebElement twitter = driver.findElement(By.xpath("//a[contains(.,'Follow On Twitter')]"));
        twitter.click();
        WebElement faceBook = driver.findElement(By.xpath("//a[contains(.,'Like us On Facebook')]"));
        faceBook.click();
        WebElement linkedIn = driver.findElement(By.xpath("//a[contains(.,'Follow us On Linkedin')]"));
        linkedIn.click();

        String mainPageId = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        String title = driver.getTitle();
        String expectedTitle = "LambdaTest | San Francisco CA | Facebook";

        for(String id : windowHandles){
            Thread.sleep(300);
            driver.switchTo().window(id);
            if(driver.getTitle().equals(expectedTitle)){
                break;
            }
        }
        System.out.println(driver.getTitle());
    }

    @Test
    public void taskWindows() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://www.ebay.com/')");
        js.executeScript("window.open('https://www.bestbuy.com/')");
        js.executeScript("window.open('https://www.abt.com/')");

        String bestBuyTitle = "Best Buy | Official Online Store | Shop Now & Save";
        Set<String> windowHandles = driver.getWindowHandles();
       for(String title : windowHandles){
         Thread.sleep(200);
         driver.switchTo().window(title);
         if(driver.getTitle().contains(bestBuyTitle)){
             System.out.println(driver.getTitle().trim());
             break;
         }
       }


    }

    @Test
    public void taskWindows2() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://www.uchicago.edu/en')");
        js.executeScript("window.open('https://www.uic.edu/')");
        js.executeScript("window.open('https://www.iit.edu/')");
        String uicTitle = "University of Illinois Chicago";
        Set<String> windowHandles = driver.getWindowHandles();
        for(String title : windowHandles){
            Thread.sleep(300);
            driver.switchTo().window(title);
            if(driver.getTitle().contains(uicTitle)){
                break;
            }

        }
        WebElement addressOfUIC = driver.findElement(By.xpath("//div[@class='footer-address']"));
        BrowserUtil.BrowserUtils.scrollToElement(driver, addressOfUIC);
        Thread.sleep(300);
        System.out.println(BrowserUtil.BrowserUtils.getText(addressOfUIC));

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }
}
