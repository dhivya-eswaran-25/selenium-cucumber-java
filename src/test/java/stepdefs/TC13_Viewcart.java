package stepdefs;

import org.openqa.selenium.*;
import org.testng.Assert;
import pages.HomePage;
import pages.CartPage;
import io.cucumber.java.en.*;

public class TC13_Viewcart{
    private WebDriver driver;
    HomePage hp;
    CartPage cp;
    public TC13_Viewcart(){
        this.driver=LaunchWebsite.driver;
        hp=new HomePage(driver);
        cp=new CartPage(driver);
    }
    @When("User clicks view cart link")
    public void clkViewCartLink(){
        cp.clickViewCartLink();
    }
    
    @Then("User navigates to view cart page")
    public void checkPage(){
        String url=driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.automationexercise.com/view_cart");
    }
}
