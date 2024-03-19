package selenium.find_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FindElementsPractice {

    @Test
    public void TC_01() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        List<WebElement> allLink = (List<WebElement>) driver.findElement(By.xpath("//a"));
        List<String> lessThan10 = new ArrayList<>();
        /*for (int i = 0; i < allLink.size(); i++) {
            WebElement element = allLink.get(i);
            String str = element.getText();
            int length = str.length();
            if (length < 10) {
                allText.add(str);

         */
        for(int i = 1; i<allLink.size(); i++){
            if(allLink.get(i).getText().length() <10){
                lessThan10.add(allLink.get(i).getText());
            }
        System.out.println(lessThan10);
        }
    }
    @Test (priority = 0)
    public void TC_2(){
        System.out.println("test 2");
    }
    @Test(priority = 1)
    public void TC_3(){
        System.out.println("Test 3");
    }

    }

