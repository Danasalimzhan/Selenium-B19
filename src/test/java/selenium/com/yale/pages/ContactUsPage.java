package selenium.com.yale.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import selenium.util.BrowserUtil;

public class ContactUsPage {
    public ContactUsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//p[contains(.,'Yale University')]")
    WebElement address;
    @FindBy(xpath = "//a[.='Contact Web Editor']")
    WebElement webEditorLink;
    public void validateAddress(){
        System.out.println(BrowserUtil.BrowserUtils.getText(address));
        Assert.assertTrue(address.isDisplayed());
    }
    public void validateTitleAndURL(WebDriver driver){
        String expectedURL = "https://www.yale.edu/contact-us";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);

        String expectedTitle = "Contact Us | Yale University";
        String actualTitle = BrowserUtil.BrowserUtils.getTitle(driver);
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    public void scrollAndClickWebEditor(WebDriver driver){
        BrowserUtil.BrowserUtils.scrollIntoViewJS(driver, webEditorLink);
        webEditorLink.click();
    }
}
