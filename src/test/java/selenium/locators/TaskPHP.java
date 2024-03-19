package selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class TaskPHP {
    @Test
    public void FillInFields(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://phptravels.com/demo");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@name = 'first_name']")).sendKeys("Bella");
        driver.findElement(By.xpath("//input[@name = 'last_name']")).sendKeys("Hadid");
        driver.findElement(By.xpath("//input[@name = 'business_name']")).sendKeys("Prada");
        driver.findElement(By.xpath("//input[@class = 'email form-control']")).sendKeys("Bella@gmail.com");
        WebElement number1 = driver.findElement(By.xpath("//span[@id = 'numb1']"));
        String num1 = number1.getText();
        WebElement number2 = driver.findElement(By.xpath("//span[@id = 'numb2']"));
        String num2 = number2.getText();
        Integer answer = Integer.parseInt(num1) + Integer.parseInt(num2);
        String realAnswer = String.valueOf(answer);
        WebElement answerInputField =  driver.findElement(By.xpath("//input[@id = 'number']"));
        answerInputField.sendKeys(realAnswer);
        WebElement submitButton = driver.findElement(By.xpath("//button[contains(.,'Submit')]"));
        submitButton.click();









    }
}
