package selenium.introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasicsTask {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://codefish.io/");
        driver.getTitle();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Codefish";
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Pass");
        } else {
            System.out.println("Failed");
        }
        System.out.println("driver.getPageSource() = " + driver.getPageSource());
        driver.manage().window().minimize();
        driver.quit();
    }
}
