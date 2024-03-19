package selenium.upload_file;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.util.BrowserUtil;

import java.time.Duration;

public class UploadFile {
    @Test
    public void TC_6(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement fileUpload = driver.findElement(By.cssSelector("input[id='file-upload']"));
        fileUpload.sendKeys("C:\\Users\\salim\\IdeaProjects\\Selenium-B19\\src\\test\\resources\\testData\\sistalkpng.png");
        WebElement fileSubmitBtn = driver.findElement(By.cssSelector("//input[id='file-submit']"));
        fileSubmitBtn.click();

        WebElement successMessage = driver.findElement(By.tagName("h3"));
        String actualMessage = BrowserUtil.BrowserUtils.getText(successMessage);
        String expectedSuccessMessage = "File Upload!";
        Assert.assertEquals(actualMessage, expectedSuccessMessage, "failed to validate success message for file upload");
        WebElement fileNameText = driver.findElement(By.cssSelector("div[id='uploaded-files']"));
       String actualFileName = BrowserUtil.BrowserUtils.getText(fileNameText);
       String expectedFileName = "sistalkpng.png";
       Assert.assertEquals(actualFileName, expectedFileName, "Failed to validate file name text after upload");

    }
}
