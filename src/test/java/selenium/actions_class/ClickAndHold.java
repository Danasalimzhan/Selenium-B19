package selenium.actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.util.BrowserUtil;
import selenium.util.DriverHelper;

public class ClickAndHold {
    WebDriver driver;

    @BeforeMethod
    public void initializeDriver() {
        driver = DriverHelper.getDriver();

    }

    @Test
    public void ClickAndHold() {
        driver.navigate().to("https://demoqa.com/droppable");
        WebElement draggable = driver.findElement(By.cssSelector("#draggable"));
        WebElement dropPlace = driver.findElement(By.cssSelector("div[id='draggable']~div[id='droppable']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(draggable).moveToElement(dropPlace).release().perform();

        WebElement droppedMessage = driver.findElement(By.xpath("//p[.= 'Dropped!']"));
        Assert.assertEquals(BrowserUtil.BrowserUtils.getText(droppedMessage), "Dropped!");

    }

    @Test
    public void acceptClickAndHold() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/droppable");
        WebElement accept = driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
        accept.click();

        WebElement draggable1 = driver.findElement(By.cssSelector("#acceptable"));
        WebElement draggable2 = driver.findElement(By.cssSelector("#notAcceptable"));
        WebElement dropPlace = driver.findElement(By.xpath("//div[@id='acceptable']//..//following-sibling::div[@id='droppable']"));

        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.clickAndHold(draggable1).moveToElement(dropPlace).release().perform();
        actions.clickAndHold(draggable2).moveToElement(dropPlace).release().perform();

        WebElement dropMessage = driver.findElement(By.xpath("//p[.='Dropped!']"));
        System.out.println("BrowserUtil.BrowserUtils.getText(dropMessage) = " + BrowserUtil.BrowserUtils.getText(dropMessage));
        System.out.println(dropMessage.getCssValue("font-family"));
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
