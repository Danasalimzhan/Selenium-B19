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

public class ScrollByAmountAction {
    WebDriver driver;
    @BeforeMethod
    public void initialize(){
        driver= DriverHelper.getDriver();

    }

    @Test
    public void ScrollAPage(){
        driver.get("https://www.lambdatest.com/selenium-playground/hover-demo");
        WebElement flashImage = driver.findElement(By.cssSelector("div[class='hover11 s__column']>div"));

        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, 3000).perform();
        actions.moveToElement(flashImage).perform();
    }

    @Test
    public void dragAndDrop(){
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropArea = driver.findElement(By.xpath("//div[class='test2']"));


        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, dropArea).perform();
        dropArea = driver.findElement(By.cssSelector("div[class='test']"));
        System.out.println(BrowserUtil.BrowserUtils.getText(dropArea));
        System.out.println(dropArea.getCssValue("background-color"));

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
