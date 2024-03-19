package selenium.com.yale.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.com.yale.pages.ContactUsPage;
import selenium.com.yale.pages.WebEditorPage;
import selenium.com.yale.pages.YaleMAinPage;
import selenium.util.DriverHelper;

public class YaleScript extends YaleBase{



    @Test
    public void TC_01(){
        YaleMAinPage mainPage = new YaleMAinPage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        WebEditorPage editorPage  = new WebEditorPage(driver);

        mainPage.validateHeaders();
        mainPage.validateScrollAndClick(driver);

        contactUsPage.validateAddress();
        contactUsPage.validateTitleAndURL(driver);
        contactUsPage.scrollAndClickWebEditor(driver);


        editorPage.validateTitleAndURL(driver);
        editorPage.fillInputFields();
    }

}
