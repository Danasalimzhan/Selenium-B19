package selenium.com.luma.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LumaMain {
    WebDriver driver;
    public LumaMain(WebDriver driver){
     this.driver = driver;
    }
    private By gear = By.xpath("//span[.='Gear']");
    private By bags = By.xpath("//a[.='Bags']");

    public WebElement clickOnBags(){
        return driver.findElement(bags);
    }
    public WebElement hoverOverGear(){
        return driver.findElement(gear);
    }
}
