package selenium.introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics_2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/salim/Downloads/B19%20HTML.html");
        driver.manage().window().maximize();

        System.out.println("driver.getPageSource() = " + driver.getPageSource());
     String pageSource = driver.getPageSource();
        System.out.println("page source" + pageSource);

        driver.navigate().to("https://www.youtube.com/");
        driver.navigate().back();

        Thread.sleep(2000);

        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit();

    }
}
