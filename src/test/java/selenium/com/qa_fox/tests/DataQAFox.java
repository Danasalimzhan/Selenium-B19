package selenium.com.qa_fox.tests;

import org.testng.annotations.DataProvider;

public class DataQAFox {
    @DataProvider(name = "dataQa")
    public Object[][]getData(){
        return new Object[][]{
                {"Ana","Dias","Ana@mail.com","1111111111","password"},
                {"Loki","Thor","loki@mail.com","333333333","password1"},
                {"Tom","Jerry","tom@mail.com","2222222222","password2"},
        };
    }
}
