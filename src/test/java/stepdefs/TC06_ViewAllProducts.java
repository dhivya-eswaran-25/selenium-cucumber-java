package stepdefs;

import java.util.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import cucumbertutorial.pages.*;
import io.cucumber.java.en.*;

public class TC06_ViewAllProducts {
    private WebDriver driver;
    HomePage hp;
    ProductsPage pp;
    public TC06_ViewAllProducts(){
        this.driver=LaunchWebsite.driver;
        hp=new HomePage(driver);
        pp=new ProductsPage(driver);
    }
    @Given ("User navigates to the products page")
    public void productsPage(){
        hp.clickProducts();
        String url=driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.automationexercise.com/products");
        System.out.println("Navigated to products page");
    }
    @And ("User view all products")
    public Map<String,Float> productsList(){
        Map<String,Float> itemsList=new LinkedHashMap<>();
        String text=driver.getPageSource();
        Assert.assertTrue(text.contains("All Products"));
        itemsList=pp.productList(); 
        Assert.assertTrue(itemsList.size()==34);
        System.out.println(itemsList);
        return itemsList;      
    }
}
