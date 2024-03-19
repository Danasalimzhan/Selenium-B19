package selenium.util;

import jdk.javadoc.internal.doclets.toolkit.util.DocFile;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import static selenium.util.DriverHelper.driver;

public class BrowserUtil {


    public static class BrowserUtils {

        public static String getText(WebElement element) {

            return element.getText().trim();
        }
        public static String getText(WebElement element, WebDriver driver){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.getText().trim();
        }

        public static String getTitle(WebDriver driver) {

            return driver.getTitle().trim();

        }

        public static void acceptAlert(WebDriver driver) {
            // recursion
            Alert alert = driver.switchTo().alert();
            alert.accept();

        }

        public static void dismissAlert(WebDriver driver) {

            Alert alert = driver.switchTo().alert();
            alert.dismiss();

        }

        public static void sendKeysToAlert(WebDriver driver, String keysToSend) {
            Alert alert = driver.switchTo().alert();
            alert.sendKeys(keysToSend);
        }

        public static String alertGetText(WebDriver driver) {
            Alert alert = driver.switchTo().alert();
            return alert.getText().trim();

        }


        public static void selectBy(WebElement element, String value, String methodName) {
            Select select = new Select(element);
            switch (methodName) {
                case "visibleText":
                    select.selectByVisibleText(value);
                    break;

                case "value":
                    select.selectByValue(value);
                    break;

                case "index":
                    select.selectByIndex(Integer.parseInt(value));
                    break;

                default:
                    System.out.println("Please choose correct select method");
            }

        }
        public static WebElement getFirstOptionSelect(WebElement element){
            Select select = new Select(element);
            return select.getFirstSelectedOption();
        }

        public static List<WebElement> getOptionsSelect(WebElement element) {
            Select select = new Select(element);
            return select.getOptions();
        }


        public static WebElement findElement(WebDriver driver, By by) {
            return driver.findElement(by);
        }


        public static void clickHoldAndDrop(WebDriver driver, WebElement location, WebElement dropZone) {

            Actions actions = new Actions(driver);
            actions.clickAndHold(location).moveToElement(dropZone).release().build().perform();
        }

        public static void clickAndHold(WebDriver driver, WebElement location, WebElement dropZone) {
            Actions actions = new Actions(driver);
            actions.clickAndHold(location).moveToElement(dropZone).release().build().perform();
        }

        public static void dragAndDrop(WebDriver driver, WebElement draggable, WebElement dropZone) {
            Actions actions = new Actions(driver);
            actions.dragAndDrop(draggable, dropZone).perform();
        }

        public static void scrollByAmount(WebDriver driver, int x, int y) {
            Actions actions = new Actions(driver);
            actions.scrollByAmount(x, y).build().perform();
        }

        public static void scrollToElement(WebDriver driver, WebElement element) {
            Actions actions = new Actions(driver);
            actions.scrollToElement(element).build().perform();
        }

        public static void moveByOffSet(WebDriver driver, WebElement element, int x, int y) {
            Actions actions = new Actions(driver);
            actions.clickAndHold(element).moveByOffset(x, y).build().perform();
        }

        public static void moveTo(WebDriver driver, WebElement element) {
            Actions actions = new Actions(driver);
            actions.moveToElement(element).build().perform();
        }

        public static void takeScreenShot(WebDriver driver) {
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String location = System.getProperty("user,dr") + "/scr/main/screenshots/";
            File directory = new File(location);
            if (!directory.exists()) {
                directory.mkdir();
            }
            try {
                FileUtils.copyFile(file, new File(location + System.currentTimeMillis() + ".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }

        public static String getTitleWithJS(WebDriver driver) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            return js.executeScript("return document.title").toString();
        }

        public static void clickWithJS(WebDriver driver, WebElement element) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click()", element);

        }

        public static void scrollIntoViewJS(WebDriver driver, WebElement element) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true)", element);

        }

        public static void scrollWithPointJS(WebDriver driver, WebElement element) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            Point point = element.getLocation();
            int x = point.getX();
            int y = point.getY();
            js.executeScript("window.scrollTo(" + x + ", " + y + ")");
        }

        public static void switchWindows(WebDriver driver) {
            String mainPageId = driver.getWindowHandle();
            Set<String> windowHandles = driver.getWindowHandles();
            for (String id : windowHandles) {
                if (!id.equals(mainPageId)) {
                    driver.switchTo().window(id);
                    System.out.println("Driver switched to new window");
                    break;
                }
            }
        }

        public static void switchWindowsWithTitle(WebDriver driver, String title) {
            Set<String> windowHandles = driver.getWindowHandles();
            for (String id : windowHandles) {
                driver.switchTo().window(id);
                if (driver.getTitle().contains(title)) {
                    break;
                }
            }
        }

        public static void switchWindowsWithURL(WebDriver driver, String url) {
            Set<String> windowHandles = driver.getWindowHandles();
            for (String id : windowHandles) {
                driver.switchTo().window(id);
                if (driver.getTitle().contains(url)) {
                    break;
                }
            }
        }

        public static void switchDriverToIframe(WebDriver driver, String nameOrId){
            driver.switchTo().frame(nameOrId);
            System.out.println("driver switched to iframe " + nameOrId);
        }

        public static void switchDriverToIframe(WebDriver driver, WebElement element){
            driver.switchTo().frame(element);
            System.out.println("driver switched to iframe using WebElement");
        }
        public static void switchDriverToDefaultContent(WebDriver driver){
            driver.switchTo().parentFrame();
        }

    }
}
