package selenium.data_provider;

import org.testng.annotations.DataProvider;

public class DataProviderSeparated {
    @DataProvider(name = "myData")
    public Object[] getData(){
        return new Object[][]{
                {"Aidana", "Salimzhan"},
                {"Dauren", "Salimzhan"}
        };
    }
}
