package selenium.com.qa_fox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.util.BrowserUtil;

public class QAFoxMainPage {
    public QAFoxMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[.='Desktops']")
    WebElement desktopTab;

    @FindBy(xpath = "//a[.='Show AllDesktops']")
    WebElement showAllDesktops;
    @FindBy(xpath = "//a[.='Register']")
    WebElement registerLink;
    @FindBy(xpath = "//span[.='My Account']")
    WebElement myAccount;


    public void clickOnShowAllDesktops(WebDriver driver) throws InterruptedException {
        BrowserUtil.BrowserUtils.moveTo(driver, desktopTab);
        Thread.sleep(2000);
        BrowserUtil.BrowserUtils.clickWithJS(driver, showAllDesktops);
    }

    public void clickOnRegister(WebDriver driver){
        BrowserUtil.BrowserUtils.clickWithJS(driver, myAccount);
        BrowserUtil.BrowserUtils.clickWithJS(driver, registerLink);
    }

}
