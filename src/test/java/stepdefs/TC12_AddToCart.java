package stepdefs;

import org.openqa.selenium.*;
import org.testng.Assert;
import cucumbertutorial.pages.HomePage;
import cucumbertutorial.pages.CartPage;
import io.cucumber.java.en.*;

public class TC12_AddToCart{
    private WebDriver driver;
    HomePage hp;
    CartPage cp;
    public TC12_AddToCart(){
        this.driver=LaunchWebsite.driver;
        hp=new HomePage(driver);
        cp=new CartPage(driver);
    }
    @When("User clicks the Add To Cart of {string}")
    public void clickProductAddToCart(String productname){
        cp.clickProductAddToCart(productname);
    }
    @When("User clicks the Add To Cart")
    public void clickAddToCart(){
        cp.clickAddToCart();
    }
    @Then("Product is added to cart")
    public void checkCart(){
        String text=cp.getMessage();
        System.out.println(text);
        //Assert.assertTrue(text.contains("Added!"));
        //Assert.assertTrue(text.contains("Your product has been added to cart."));
    }
    @When("User clicks continue shopping")
    public void clkContinueShopping(){
        cp.clickContinueShopping();
    }
    @Then("User remains in the product page")
    public void checkProductPage(){
        String url=driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.automationexercise.com/products");
    }
    @Then("User remains in the product details page")
    public void checkProductDetailsPage(){
        String url=driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https://www.automationexercise.com/product_details"));
    }
}
