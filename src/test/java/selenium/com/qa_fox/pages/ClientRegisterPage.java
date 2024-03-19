package selenium.com.qa_fox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientRegisterPage {
    public ClientRegisterPage(WebDriver driver){
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = "input[name='firstname']")
    WebElement firstName;
    @FindBy(css = "input[name='lastname']")
    WebElement lastName;
    @FindBy(css = "input[name='email']")
    WebElement email;
    @FindBy(name = "telephone']")
    WebElement telephone;
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement password;
    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement confirmPassword;
    @FindBy(xpath = "//label[@class='radio-inline']")
    WebElement radioButtons;
    @FindBy(xpath = "//input[name='agree']")
    WebElement checkBox;
    @FindBy(css = "input[type='submit']")
    WebElement continueBtn;

    public void createCustomerProfile(String firstName, String lastName,String email,
                                      String telephone, String password) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.telephone.sendKeys(telephone);
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(password);
    }

      /*  for(int i = 0; i < radioButtons.size(); i++){
            if(radioButtons.get(i).getText().equalsIgnoreCase("yes")){
                radioButtons.get(i).click();
                break;
            }
        }
        checkBox.click();
        continueBtn.click();

    }

       */


}
