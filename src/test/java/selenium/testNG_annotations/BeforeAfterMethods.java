package selenium.testNG_annotations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAfterMethods {
    @BeforeMethod
    public void initialize(){
        System.out.println("I am from before Method");
    }
    @Test
    public void myTest(){
        System.out.println("i am from Test Annotation");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("i am from After Method");
    }
}
