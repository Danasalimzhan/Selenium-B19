package selenium.com.qa_fox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import selenium.util.BrowserUtil;

import java.util.ArrayList;
import java.util.List;

public class ProductListPage {
    public ProductListPage(WebDriver driver){
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = "#input-sort")
    WebElement sortByDropdown;

    @FindBy(css = "#input-limit")
    WebElement limitDropdown;

    @FindBy(xpath = "//h4")
    List<WebElement> allProducts;

    public void validateSorting() throws InterruptedException {
        BrowserUtil.BrowserUtils.selectBy(sortByDropdown, "Name (A - Z)", "visibleText");
        BrowserUtil.BrowserUtils.selectBy(limitDropdown, "100", "visibleText");
        Thread.sleep(2000);

        List<String> AtoZ = new ArrayList<>();
        List<String> ZtoA = new ArrayList<>();
        for(int i=0; i<allProducts.size(); i++){
            AtoZ.add(allProducts.get(i).getText());
        }
        Thread.sleep(2000);
        BrowserUtil.BrowserUtils.selectBy(sortByDropdown, "Name (Z - A)", "visibleText");
        for(int i=0; i<allProducts.size(); i++) {
            ZtoA.add(allProducts.get(i).getText());
        }
        Assert.assertNotEquals(AtoZ, ZtoA);
    }
}
