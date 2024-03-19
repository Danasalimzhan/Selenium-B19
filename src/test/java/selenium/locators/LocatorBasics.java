package selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorBasics {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/salim/Downloads/B19%20HTML.html");
        driver.manage().window().maximize();

        WebElement text = driver.findElement(By.tagName("h1"));
        String actualText = text.getText();
        String expectedText = "I love coding";
        System.out.println(actualText);
        if(actualText.equals(expectedText)){
            System.out.println("Pass");
        }else{
            System.out.println("Failed");
        }
        WebElement clickHereLink = driver.findElement(By.linkText("Click here for help"));
        clickHereLink.click();









    }
}
