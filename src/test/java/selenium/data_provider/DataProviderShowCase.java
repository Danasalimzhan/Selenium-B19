package selenium.data_provider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderShowCase {

 /*   @DataProvider(name = "myData")
    public Object[] getData(){
        return new Object[][]{
                {"Aidana", "Salimzhan"},
                {"Dauren", "Salimzhan"}
        };
    }

  */

    @Test(dataProvider = "myData", dataProviderClass = DataProviderSeparated.class)
    public void testDataProvider(String name1, String name2){
        System.out.println(name1+" " + name2);
    }
}
