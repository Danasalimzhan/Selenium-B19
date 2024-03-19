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

public class ActionsMethod {
    WebDriver driver;

    @BeforeMethod
    public void initialize() {
        driver = DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/context_menu");
    }

    @Test
    public void contextClick() throws InterruptedException {

        WebElement contextMenu = driver.findElement(By.linkText("Context Menu"));
        contextMenu.click();

        WebElement hotSpot = driver.findElement(By.cssSelector("#hot-spot"));

        Actions actions = new Actions(driver);
        actions.contextClick(hotSpot).perform(); // perform method in the end is a must fot ACTIONS
        Thread.sleep(2000);
        BrowserUtil.BrowserUtils.acceptAlert(driver);

    }

    @Test
    public void contextClick2() throws InterruptedException {
        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement rightClickMe = driver.findElement(By.xpath("//span[.='right click me']"));

        Actions actions = new Actions(driver);
        actions.contextClick(rightClickMe).perform();
        Thread.sleep(2000);

        WebElement delete = driver.findElement(By.xpath("//span[.='Delete']"));
        delete.click();
        Thread.sleep(2000);

        String alertText = BrowserUtil.BrowserUtils.alertGetText(driver);
        System.out.println(alertText);

        BrowserUtil.BrowserUtils.acceptAlert(driver);
    }

    @Test
    public void doubleClick() throws InterruptedException {
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement doubleClickMe = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickMe).perform();
        Thread.sleep(2000);
        System.out.println("BrowserUtils.alertGetText(driver) = "+ BrowserUtil.BrowserUtils.alertGetText(driver));
        BrowserUtil.BrowserUtils.acceptAlert(driver);




    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
