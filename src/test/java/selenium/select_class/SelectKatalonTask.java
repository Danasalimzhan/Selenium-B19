package selenium.select_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SelectKatalonTask {
    @Test
    public void KatalonTask(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//a[@id = 'btn-make-appointment']")).click();

        driver.findElement(By.xpath("//input[@id = 'txt-username']")).sendKeys("John Doe");
        driver.findElement(By.xpath("//input[@id = 'txt-password']")).sendKeys("ThisIsNotAPassword");
       driver.findElement(By.xpath("//button[@id = 'btn-login']")).click();
       //driver.findElement(By.xpath(""));
        WebElement dropDown = driver.findElement(By.xpath("//select[@id = 'combo_facility']"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Seoul CURA Healthcare Center");

        driver.findElement(By.xpath("//input[@id = 'chk_hospotal_readmission']")).click();

        driver.findElement(By.xpath("//input[@id = 'radio_program_none']")).click();

        driver.findElement(By.xpath("//input[@id = 'txt_visit_date']")).sendKeys("09/02/2024");

        driver.findElement(By.xpath("//textarea[@id = 'txt_comment']")).sendKeys("Pls, make a reservation for a 5 star hotel");

        driver.findElement(By.xpath("//button[@id = 'btn-book-appointment']")).click();

        WebElement confirmedText = driver.findElement(By.tagName("h2"));
        String actualText = confirmedText.getText();
        String expectedText = "Appointment Confirmation";

        Assert.assertEquals(actualText, expectedText, "failed");

        WebElement clientComment = driver.findElement(By.id("comment"));
        String actualComment = clientComment.getText();
        String expectedComment = "Please also book me a nice hotel!";












    }
}
