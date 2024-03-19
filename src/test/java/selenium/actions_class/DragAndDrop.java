package selenium.actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.util.BrowserUtil;
import selenium.util.DriverHelper;

public class DragAndDrop {
    WebDriver driver;

    @BeforeMethod
    public void initializeDriver() {
        driver = DriverHelper.getDriver();
    }

    @Test
    public void DragAndDrop() {
        driver.navigate().to("https://www.lambdatest.com/selenium-playground/drag-and-drop-demo");
        WebElement draggable1 = driver.findElement(By.xpath("//span[.='Draggable 1']"));
        WebElement draggable2 = driver.findElement(By.xpath("//span[.='Draggable 2']"));
        WebElement dropZone = driver.findElement(By.cssSelector("#mydropzone"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable1, dropZone).perform();
        actions.dragAndDrop(draggable2, dropZone).perform();

        WebElement droppedList = driver.findElement(By.cssSelector("#droppedlist"));
        System.out.println(BrowserUtil.BrowserUtils.getText(droppedList));
        System.out.println(droppedList.getCssValue("visibility"));
    }

    @Test
    public void dragAndDrop2() {
        driver.navigate().to("https://www.lambdatest.com/selenium-playground/drag-and-drop-demo");
        WebElement draggable = driver.findElement(By.cssSelector("#draggable"));
        WebElement dropZone = driver.findElement(By.cssSelector("#doppable"));

        BrowserUtil.BrowserUtils.dragAndDrop(driver,draggable,dropZone);


        WebElement droppedMsg = driver.findElement(By.cssSelector("//p[.='Dropped!']"));
        System.out.println(BrowserUtil.BrowserUtils.getText(droppedMsg));

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
