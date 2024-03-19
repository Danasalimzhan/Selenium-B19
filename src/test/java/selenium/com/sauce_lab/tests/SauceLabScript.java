package selenium.com.sauce_lab.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.com.sauce_lab.pages.LoginPage;

public class SauceLabScript extends SauceBase{

    @DataProvider(name = "dataForSauceLab")
    public Object[][] getData(){
        return new Object[][]{
                {"test", "12345", "Epic sadface: Username and password do not match any user in this service"},
                {"837493", "wieuy"},
                {"@@#$", "@$$#%"},
                {"legitLogin", " "}
        };
    }

    @Test (dataProvider = "dataForSauceLab")
    public void TestLoginPage(String username, String password, String errorMessage){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillInputFields("test", "qwerty");
        String actualErrorMsg = loginPage.errorMsg();
     //   String expectedErrorMsg = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualErrorMsg, errorMessage);
    }
}
