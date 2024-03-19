package selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RecapLocators {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        WebElement sliderLink = driver.findElement(By.linkText("Horizontal Slider"));
        sliderLink.click();
        Thread.sleep(2000);
        WebElement subHeader = driver.findElement(By.tagName("4"));
        String actualSubHeader = subHeader.getText().trim();
        String expectedSubHeader = "Set the focus on the slider (by clicking on it) and use the arrow keys to move it right and left. " +
                "Or click and drag the slider with your mouse. " +
                "It will indicate the value of the slider to the right.";
        if(actualSubHeader.equals(expectedSubHeader)){
            System.out.println("Pass");
        } else{
            System.out.println("Failed");
        }
        WebElement footerLink = driver.findElement(By.partialLinkText("Elemental"));
        footerLink.click();


    }
}
