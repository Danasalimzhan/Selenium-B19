package selenium.com.yale.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WebEditorPage {
    public WebEditorPage(WebDriver driver){
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = "#edit-submitted-name")
    WebElement name;
    @FindBy(css = "edit-submitted-email")
    WebElement email;
    @FindBy(css = "edit-submitted-website-url")
    WebElement webURL;
    @FindBy(css = "edit-submitted-comments")
    WebElement textArea;
    @FindBy(css = "recaptcha-checkbox-border")
    WebElement captcha;

    public void validateTitleAndURL(WebDriver driver){
        //Validating Title
        String expectedTitle = "Contact Web Editor | Yale University";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //Validating webEditor Page
        String expectedURL = "https://www.yale.edu/contact-us/contact-web-editor";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);

    }

    public void fillInputFields(){
        name.sendKeys("Dana");
        email.sendKeys("test@test.com");
        webURL.sendKeys("www.google.com");
        textArea.sendKeys("Helloooooo!");
        captcha.click();
    }


}
