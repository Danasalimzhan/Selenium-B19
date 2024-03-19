package selenium.util;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestClass {
    @Test
    public void taskSelect(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/jquery-dropdown-search-demo");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement selectCountrySearchBar = driver.findElement(By.xpath("//span[@id='select2-country-container']//following-sibling::span[@class='select2-selection__arrow']"));
        selectCountrySearchBar.click();
       WebElement sendKeysSelectCountry = driver.findElement(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field']"));
       sendKeysSelectCountry.sendKeys("United States of America", Keys.ENTER);
       WebElement multiSelectState = driver.findElement(By.cssSelector("span[class='select2-selection select2-selection--multiple']"));
       multiSelectState.sendKeys("Illinois", Keys.ENTER);
       WebElement PuertoRicoSelect = driver.findElement(By.xpath("//span[contains(text(), 'Puerto Rico')]"));
       sendKeysSelectCountry.sendKeys("Virgin Islands", Keys.ENTER);
       WebElement language = driver.findElement(By.cssSelector("#files"));


    }
}
