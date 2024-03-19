package selenium.com.yale.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import selenium.util.BrowserUtil;
import selenium.util.ConfigReader;
import selenium.util.DriverHelper;

public class YaleBase {
    WebDriver driver;
    @BeforeMethod
    public void initializeDriver(){
        driver = DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("yaleURL"));
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if(!result.isSuccess()){
            BrowserUtil.BrowserUtils.takeScreenShot(driver);
        }

        driver.quit();
    }
}
