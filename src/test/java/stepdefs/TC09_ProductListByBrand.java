package stepdefs;

import java.util.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.ProductsPage;
import io.cucumber.java.en.*;

public class TC09_ProductListByBrand {
    private WebDriver driver;
    HomePage hp;
    ProductsPage pp;
    public TC09_ProductListByBrand(){
        this.driver=LaunchWebsite.driver;
        hp=new HomePage(driver);
        pp=new ProductsPage(driver);
    }
    @And("User list products by brand")
    public void productsListByBrand(){
        Map<String,Integer> brandNames=pp.listBrands();
        System.out.println(brandNames);
    }

    @When("User clicks on the {string} brand")
    public void clickProductLink(String brandname){
        pp.clickBrand(brandname);
        String url=driver.getCurrentUrl();
        System.out.println(url);
        Assert.assertTrue(url.contains("brand_products"));
        Assert.assertTrue(url.toUpperCase().contains(brandname));
    }
    @Then("Products for that brand is displayed")
    public Map<String,Float> productsList(){
        Map<String,Float> itemsList=new LinkedHashMap<>();
        itemsList=pp.productList(); 
        System.out.println(itemsList);
        return itemsList;             
    }
}
