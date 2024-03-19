package selenium.com.blaze.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import selenium.util.DriverHelper;

public class BlazeBase {
WebDriver driver;
public void initializeDriver(){
    driver = DriverHelper.getDriver();
    driver.get("https://www.demoblaze.com/prod.html?idp_=15#");
}

@AfterMethod
    public void tearDown() throws InterruptedException {
    Thread.sleep(2000);
    driver.quit();
}
}
