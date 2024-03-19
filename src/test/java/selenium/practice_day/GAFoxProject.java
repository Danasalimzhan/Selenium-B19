package selenium.practice_day;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.util.BrowserUtil;
import selenium.util.DriverHelper;

public class GAFoxProject {
    WebDriver driver;
    @BeforeMethod
    public void initializeDriver(){
        driver = DriverHelper.getDriver();
        driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
}

@Test
public void validatePurchase() throws InterruptedException {
    WebElement desktop = driver.findElement(By.xpath("//a[.='Desktops']"));
    BrowserUtil.BrowserUtils.moveTo(driver, desktop);
    Thread.sleep(2000);
    WebElement showAllDesktop = driver.findElement(By.xpath("//a[.='Show AllDesktops']"));
    showAllDesktop.click();

    WebElement addToCart = driver.findElement(By.xpath("//h4//a[.='Sony VAIO']//..//..//following-sibling::div//span[.='Add to Cart']"));
    BrowserUtil.BrowserUtils.scrollToElement(driver, addToCart);
    addToCart.click();
    Thread.sleep(3000);

    WebElement shoppingCartLink = driver.findElement(By.xpath("//a[.='shopping cart']"));
    shoppingCartLink.click();

    WebElement checkoutBtn = driver.findElement(By.xpath("//a[contains(text(),'Checkout')]"));
    checkoutBtn.click();

    WebElement radioBtnGuest = driver.findElement(By.cssSelector("input[value='guest']"));
    if(!radioBtnGuest.isSelected()){
        radioBtnGuest.click();
    }

    WebElement continueBtn = driver.findElement(By.cssSelector("input[id='button-account'']"));
    continueBtn.click();

    WebElement firstName = driver.findElement(By.cssSelector("#input-payment-firstname"));
    firstName.sendKeys("Dana");

    WebElement lastName = driver.findElement(By.cssSelector("#input-payment-lastname"));
    lastName.sendKeys("Sal");
    WebElement email = driver.findElement(By.cssSelector("#input-payment-email"));
    email.sendKeys("test@test.com");
    WebElement telephone = driver.findElement(By.cssSelector("#input-payment-telephone"));
    telephone.sendKeys("223949485");
    WebElement address1 = driver.findElement(By.cssSelector("#input-payment-address-1"));
    address1.sendKeys("test st");
    WebElement city = driver.findElement(By.cssSelector("#input-payment-city"));
    city.sendKeys("Chicago");
    WebElement zipcode = driver.findElement(By.cssSelector("#input-payment-postcode"));
    zipcode.sendKeys("12345");

    WebElement countryDropDown = driver.findElement(By.cssSelector("#input-payment-country"));
    BrowserUtil.BrowserUtils.selectBy(countryDropDown, "223", "value");

    WebElement state = driver.findElement(By.cssSelector("#input-payment-zone"));
    BrowserUtil.BrowserUtils.selectBy(state, "3635", "value");

    WebElement continueBtn2 = driver.findElement(By.cssSelector("#button-guest"));
    continueBtn2.click();


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
