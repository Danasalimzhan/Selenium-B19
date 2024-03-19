package selenium.com.php.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import selenium.util.ConfigReader;
import selenium.util.DriverHelper;

public class PhpBase {
    WebDriver driver;

    @BeforeMethod
    public void initialize(){
        driver = DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("php"));
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
