package selenium.com.sauce_lab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.util.BrowserUtil;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#user-name")
    WebElement username;

    @FindBy(css = "#password")
    WebElement password;

    @FindBy(css = "#login-button")
    WebElement loginButton;

    @FindBy(tagName = "h3")
    WebElement errorMessage;

    public void fillInputFields(String username, String password){

        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();

    }

    public String errorMsg(){
        return BrowserUtil.BrowserUtils.getText(errorMessage);
    }



}
