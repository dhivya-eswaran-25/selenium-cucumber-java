package stepdefs;

import org.openqa.selenium.*;
import org.testng.Assert;
import cucumbertutorial.pages.HomePage;
import cucumbertutorial.pages.ProductDetailsPage;
import io.cucumber.java.en.*;

public class TC10_ViewProductDetails{
    private WebDriver driver;
    HomePage hp;
    ProductDetailsPage pd;
    public TC10_ViewProductDetails(){
        this.driver=LaunchWebsite.driver;
        hp=new HomePage(driver);
        pd=new ProductDetailsPage(driver);
    }
    @When("User clicks the view product of {string}")
    public void clkViewProduct(String productname){
        pd.clickViewProduct(productname);
        String url=driver.getCurrentUrl();
        System.out.println(url);
        Assert.assertTrue(url.contains("product_details"));
    }
    @And("Updates product quantity {string}")
    public void updateQuantity(String qty){
        pd.getQuantity(qty);
    }
    @Then("Product {string} details is displayed")
    public void checkProductDetails(String productname){
        String productdetails=pd.getProductDetails();
        System.out.println(productdetails);
        Assert.assertTrue(productdetails.contains(productname));
    }     
}
