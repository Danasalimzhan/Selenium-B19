package selenium.com.luma.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.util.BrowserUtil;

public class LumaProductList {
    public LumaProductList(WebDriver driver){
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//a[contains(.,driven Backpack')]")
    WebElement drivenBag;
    @FindBy(xpath = "//a[contains(.,'Driven Backpack')]//..//following-sibling::div//form//following-sibling::button")
    WebElement addToCartBtn;
    @FindBy(xpath = "//a[.='shopping cart']")
    WebElement cartLink;
    @FindBy(css = "#top-cart-btn-checkout")
    WebElement checkOutLink;

    public void addToCartBtn(WebDriver driver) throws InterruptedException {
        BrowserUtil.BrowserUtils.moveTo(driver, drivenBag);
        Thread.sleep(1000);
        addToCartBtn.click();
        Thread.sleep(1000);
        cartLink.click();
        checkOutLink.click();
    }
}
