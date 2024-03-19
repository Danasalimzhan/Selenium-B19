package selenium.com.luma.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.util.BrowserUtil;

import java.util.List;

public class LumaCheckOut {
    public LumaCheckOut(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "fieldset>div>div>input[type='email']")
    WebElement email;
    @FindBy(css = "input[name='firstname']")
    WebElement firstName;
    @FindBy(css = "input[name='lastname']")
    WebElement lastName;
    @FindBy(css = "input[name='street[0]']")
    WebElement address;
    @FindBy(css = "input[name='city']")
    WebElement city;
    @FindBy(css = "select[name='region_id']")
    WebElement stateDropdown;
    @FindBy(css = "input[name='postcode']")
    WebElement zipCode;
    @FindBy(css = "select[name='country_id']")
    WebElement countryDropdown;
    @FindBy(css = "input[name='telephone']")
    WebElement telephone;
    @FindBy(xpath = "//span[@class='price']")
    List<WebElement> rates;
    @FindBy(xpath = "//button[contains(.,'Next')]")
    WebElement nextBtn;
    @FindBy(xpath = "//button[contains(.,'Place')]")
    WebElement placeOrder;

    public void fillOutCustomerInfo(String email,String firstName,
                                    String lastName,String address,
                                    String city,String zipCode,
                                    String telephone) throws InterruptedException {

        this.email.sendKeys(email);
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.address.sendKeys(address);
        this.city.sendKeys(city);
        BrowserUtil.BrowserUtils.selectBy(this.stateDropdown, "California", "visibleText");
        this.zipCode.sendKeys(zipCode);
        System.out.println(BrowserUtil.BrowserUtils.getFirstOptionSelect(countryDropdown).getText());
        this.telephone.sendKeys(telephone);

        rates.get(0).click();

        nextBtn.click();
        Thread.sleep(2000);

        placeOrder.click();
    }

}
