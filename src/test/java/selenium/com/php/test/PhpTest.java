package selenium.com.php.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.com.php.pages.PhpLoginPage;
import selenium.com.php.pages.PhpMainPage;

public class PhpTest extends PhpBase {

    @DataProvider(name = "TestDataPhp")
    public Object[][]getData(){
        return new Object[][]{
                {"Dana", "Sal", "BusinessName", "test@test.com"},
                {"John", "Doe", "Airlines", "airlines@test.com"},
                {"Lady", "Bug", "Bug", "bug@test.com"}
        };
    }

    @Test(dataProvider = "TestDataPhp")
    public void validateInputFields(String firstName, String lastName,
                                    String businessName, String email){
        PhpMainPage mainPage = new PhpMainPage(driver);
        PhpLoginPage loginPage = new PhpLoginPage(driver);

        mainPage.clickOnDemo();
        loginPage.fillInBlanks( firstName, lastName, businessName, email);
    }
}
