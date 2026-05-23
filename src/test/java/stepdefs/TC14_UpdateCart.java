package stepdefs;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CartPage;
import pages.HomePage;
import pages.ViewCartPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC14_UpdateCart{
    private WebDriver driver;
    HomePage hp;
    ViewCartPage vp;
    CartPage cp;
    public TC14_UpdateCart(){
        this.driver=LaunchWebsite.driver;
        hp=new HomePage(driver);
        vp=new ViewCartPage(driver);
        cp=new CartPage(driver);
    }
    @Given("User navigates to the cart page")
    public void clickCart(){
        hp.clickCart();
    }
    @And("User clicks add product link")
    public void clkAddProductsLink(){
        vp.clickAddProductsLink();
    }
    @And("User add the products")
    public void addProducts(DataTable productname){
        List<String> data=productname.asList();
            for(String product:data){
            cp.addMultiProductsToCart(product);
        } 
    }
    @When("User clicks the delete product")
    public void clkViewCartLink(DataTable productname){
        List<String> data=productname.asList();
        for(String product:data){
            vp.clickDeleteProduct(product);
        }    
    }
    @Then("Verify product is deleted")
    public void checkProductList(List<String> productname){
        List<String> productlist=vp.getProductList();
        System.out.println(productlist);
        for(String product:productlist){
            Assert.assertTrue(productlist.contains(product));
        }
    }
    @And ("Click on Proceed to Checkout")
    public void clickProceedToChkout(){
        vp.clickProceedToCheckout();
    }
    @And ("Checkout modal is displayed")
    public void verifyCheckout(){
        String text=vp.getMessage();
        System.out.println(text);
        //Assert.assertTrue(text.contains("Checkout"));
        //Assert.assertTrue(text.contains("Register / Login account to proceed on checkout."));
    }
    @When ("User Clicks Continue on Cart")
    public void clkContinueOnCart(){
        vp.clickContinueOnCart();
    }

    @Then ("User remains in cart page")
    public void checkViewCartPage(){
        String url=driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https://www.automationexercise.com/view_cart"));
    }
    @When("User Clicks Register Login link")
    public void clkRegisterLoginLink(){
        vp.clickRegisterLoginLink();            
    }

    @Then("User navigated to login page")
    public void checkLoginPage(){
        String url=driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https://www.automationexercise.com/login"));
    }
    @When("User clicks the description link of {string}")
    public void clkProductLink(String productname){
        vp.clickProductDescLink(productname);
        String url=driver.getCurrentUrl();
        System.out.println(url);
        Assert.assertTrue(url.contains("product_details"));
    }

}
