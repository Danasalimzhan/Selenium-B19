package selenium.introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.http.WebSocket;

public class SeleniumBasics {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.getTitle();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Pass");
        } else{
            System.out.println("Failed");
        }
        driver.navigate().to("https://www.amazon.com/gp/cart/view.html?ref_=nav_cart");
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());


    }
}
