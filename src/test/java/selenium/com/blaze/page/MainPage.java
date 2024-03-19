package selenium.com.blaze.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.util.BrowserUtil;

public class MainPage {
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
@FindBy(xpath = "//a[.='Laptops']")
    WebElement laptops;

    public void clickOnLaptops(WebDriver driver){
        laptops.click();

    }
}
