package selenium.iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.util.BrowserUtil;
import selenium.util.DriverHelper;

public class IFrameShowCase {
WebDriver driver;

@BeforeMethod
    public void startUp(){
    driver = DriverHelper.getDriver();
}

@Test
    public void testIframe(){
    driver.get("https://the-internet.herokuapp.com/iframe");
    driver.switchTo().frame("mce_0_ifr");

    WebElement textArea = driver.findElement(By.xpath("//p"));
    textArea.clear();
    textArea.sendKeys("test test test");
}
@Test
    public void practiceIframes(){
    driver.get("https://skpatro.github.io/demo/iframes/");
    driver.switchTo().frame("Framename1");
    WebElement category1 = driver.findElement(By.linkText("Category1"));
    category1.click();

    BrowserUtil.BrowserUtils.switchWindows(driver);
    WebElement textOnNextPage = driver.findElement(By.xpath("//h1"));
    System.out.println(BrowserUtil.BrowserUtils.getText(textOnNextPage));
    BrowserUtil.BrowserUtils.switchWindows(driver);

    driver.switchTo().frame("Frame2");

    WebElement category3 = driver.findElement(By.linkText("Category3"));
    category3.click();

    String title ="SoftwareTesting Archives - qavalidation";
    BrowserUtil.BrowserUtils.switchWindowsWithTitle(driver, title);

    WebElement textOnCat3 = driver.findElement(By.xpath("//h1"));
    System.out.println(BrowserUtil.BrowserUtils.getText(textOnCat3));

}

}
