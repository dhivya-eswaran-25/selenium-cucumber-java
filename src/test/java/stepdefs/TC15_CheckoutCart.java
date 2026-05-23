package stepdefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import cucumbertutorial.pages.CheckoutPage;
import cucumbertutorial.pages.HomePage;
import io.cucumber.java.en.*;

public class TC15_CheckoutCart{
    private WebDriver driver;
    HomePage hp;
    CheckoutPage chp;
    public TC15_CheckoutCart(){
        this.driver=LaunchWebsite.driver;
        hp=new HomePage(driver);
        chp=new CheckoutPage(driver);
    }
    @And("Verify Address details")
    public void verifyAddressDetails(){
        String text=chp.verifyCheckoutInfo();
        Assert.assertTrue(text.toLowerCase().contains("your delivery address"));
        Assert.assertTrue(text.toLowerCase().contains("your billing address"));   
    }

    @And("User clicks Place Order button")
    public void clickPlaceOrderButton(){
        String url=driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https://www.automationexercise.com/checkout"));
        chp.clickPlaceOrder();
    }
    @And("User navigated to payment page")
    public void verifyOrderPlaced(){
        String url=driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https://www.automationexercise.com/payment"));
    }
    @And("User adds review comment {string}")
    public void enterReviewComment(String comment){
        chp.enterComment(comment);
    }
}
