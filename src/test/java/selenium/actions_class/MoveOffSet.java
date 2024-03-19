package selenium.actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.util.DriverHelper;

import java.util.List;

public class MoveOffSet {
    WebDriver driver;

    @BeforeMethod
    public void initializeDriver() {
        driver = DriverHelper.getDriver();

    }

    @Test
    public void moveByOffSet() {
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement slider = driver.findElement(By.xpath("//input[@type ='range']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(slider).moveByOffset(30, 15).perform();
    }

    @Test
    public void moveSliderWithActionTask() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/drag-drop-range-sliders-demo");
        List<WebElement> sliders = driver.findElements(By.cssSelector("input[class ='sp__range']"));
        List<WebElement> allText = driver.findElements(By.xpath("//output"));

        Actions actions = new Actions(driver);
        Thread.sleep(400);
        for (int i = 0; i < sliders.size(); i++) {
            if (allText.get(i).getText().equalsIgnoreCase("80")) {
                actions.clickAndHold(sliders.get(i)).moveByOffset(-99, 0).perform();
            } else {
                actions.clickAndHold(sliders.get(i)).moveByOffset(99, 0).perform();
            }

        }

    }

    @Test
    public void moveByOffSetPractice() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/drag-and-drop-demo");
        WebElement draggable = driver.findElement(By.cssSelector("#dr"));
       WebElement dropZone = driver.findElement(By.cssSelector("#doppable"));
        Actions actions = new Actions(driver);
        for(int i = 0; i<5; i++){
            Thread.sleep(300);
            actions.clickAndHold(draggable).moveByOffset(1000, -200).release().perform();
            actions.clickAndHold(draggable).moveToElement(dropZone).release().perform();

        }

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
