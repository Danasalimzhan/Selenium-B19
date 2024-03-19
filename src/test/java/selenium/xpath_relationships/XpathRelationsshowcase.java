package selenium.xpath_relationships;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XpathRelationsshowcase {
    @Test
    public  void slideBar(){
     /*   WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/drag-drop-range-sliders-demo");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement slider1 = driver.findElement(By.xpath("//div[@id = 'slider1']//div//input"));
        WebElement outputText = driver.findElement(By.xpath("//output[@id='range']"));

        while(!outputText.getText().equals("96")){
            slider1.sendKeys(Keys.ARROW_RIGHT);
        }


      */

    }

    @Test
    public void slideAll(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/drag-drop-range-sliders-demo");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        List<WebElement> allSliders = driver.findElements(By.xpath("//input[@class ='sp__range']"));
        List<WebElement> allText = driver.findElements(By.xpath("//output"));
        for(int i = 0; i<allText.size(); i++){
            while(!allText.get(i).getText().equals(25)){
                allSliders.get(i).sendKeys(Keys.ARROW_RIGHT);
            }
        }

    }
    @Test
    public void task_2(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//a[contains(.,'Table Pagination')]")).click();

        WebElement dropdown = driver.findElement(By.id("maxRows"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Show ALL Rows");

        List<WebElement> allNames = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> emails = driver.findElements(By.xpath("//tr//td[4]"));
        Map<String, String> data = new HashMap<>();
        for(int i = 0; i<allNames.size(); i++){
            data.put(allNames.get(i).getText(), emails.get(i).getText());
        }
        System.out.println(data);


        List<WebElement> lastNames = driver.findElements(By.xpath("//tr//td[3]"));
        List<WebElement> numbers = driver.findElements(By.xpath("//tr//td[5]"));
        Map<String, String> data1 = new HashMap<>();
        for(int i = 0; i<lastNames.size(); i++){
            data1.put(lastNames.get(i).getText(), numbers.get(i).getText().replace("-", ""));
        }
        System.out.println(data1);


    }
    @Test
    public void homeWork(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//a[contains(.,'Table Pagination')]")).click();

        WebElement dropdown = driver.findElement(By.id("maxRows"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Show ALL Rows");

        List<WebElement> firstNames = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> lastName = driver.findElements(By.xpath("//tr//td[3]"));
        List<WebElement> email = driver.findElements(By.xpath("//tr//td[4]"));
        Map<String, String> info = new HashMap<>();
        for(int i=0; i<firstNames.size(); i++){
            info.put(firstNames.get(i).getText() + "."+lastName.get(i).getText(), email.get(i).getText());
        }
        System.out.println(info);

















    }
}
