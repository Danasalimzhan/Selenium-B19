package selenium.com.blaze.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.util.BrowserUtil;

public class LaptopPage {
    public LaptopPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[.='MacBook Pro']")
    WebElement macBookPro;

    public void clickOnMacBookPro(WebDriver driver){
        BrowserUtil.BrowserUtils.scrollIntoViewJS(driver, macBookPro);
        macBookPro.click();
    }
}
