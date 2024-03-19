package selenium.com.blaze.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import selenium.com.blaze.page.CartPage;
import selenium.com.blaze.page.LaptopPage;
import selenium.com.blaze.page.MacBookProPage;
import selenium.com.blaze.page.MainPage;

public class BlazeScript extends BlazeBase{

    @Test(dataProvider = "mockData", dataProviderClass = BlazeTestData.class)
    public void validatePurchaseExperience(String name, String country, String city,
                                           String cardsNumber, String month, String year) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnLaptops(driver);
        LaptopPage laptopPage = new LaptopPage(driver);
        laptopPage.clickOnMacBookPro(driver);
        MacBookProPage infoPage = new MacBookProPage(driver);
        infoPage.validateHeaderPrice();
        infoPage.addProductToCart(driver);

        CartPage cartPage = new CartPage(driver);
        cartPage.validateProductTableClickPlaceOrder();
        cartPage.fillingCustomerInfo(name, country, city, cardsNumber, month, year);

    }
}
