package selenium.com.blaze.tests;

import org.testng.annotations.DataProvider;

public class BlazeTestData {
    @DataProvider(name = "mockData")
    public Object[][]getData(){
        return new Object[][]{
                {"John wick", "USA", "New York","111111111", "12", "2025"}
        };
    }
}
