package selenium.xpath_relationships;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.time.Duration;
import java.util.List;

public class XpathRelationTask {
    @Test
    public void task(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://codefish.io/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        List<WebElement> allElements = driver.findElements(By.xpath("//div[@class = 'gradient-block']//p"));
        for(int i=0; i< allElements.size();i++){
            Assert.assertTrue(allElements.get(i).isDisplayed(), "Text is not displayed");
            System.out.println(allElements.get(i).getText());
        }



















    }

}
