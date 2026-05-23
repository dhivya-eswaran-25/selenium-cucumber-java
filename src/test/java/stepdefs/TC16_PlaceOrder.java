package stepdefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import cucumbertutorial.pages.PaymentPage;
import cucumbertutorial.pages.HomePage;
import io.cucumber.java.en.*;

public class TC16_PlaceOrder{
    private WebDriver driver;
    HomePage hp;
    PaymentPage pp;
    public TC16_PlaceOrder(){
        this.driver=LaunchWebsite.driver;
        hp=new HomePage(driver);
        pp=new PaymentPage(driver);
    }

    @And("User enter payment details {string}{string}{string}{string}{string}")
    public void enterCardDetails(String name,String nbr,String cvc,String mth,String yr){
        pp.enterCardDetails(name,nbr,cvc,mth,yr);
    }
    
    @When("User clicks pay and confirm order")
    public void clickPayandConfirmButton(){
        pp.clickPayAndConfirmOrder();
    }

    @Then("Order is placed successfully")
    public void verifyOrderPlaced(){
        String url=driver.getCurrentUrl();
        System.out.println(url);
        Assert.assertTrue(url.contains("https://www.automationexercise.com/payment"));
        String text=driver.getPageSource();
        Assert.assertTrue(text.contains("Order Placed!"));
        Assert.assertTrue(text.contains("Congratulations! Your order has been confirmed!"));  
        
    }
    @And("User clicks continue button")
    public void clikContinue(){
        pp.clickContinue();
        String url=driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https://www.automationexercise.com/"));
    }     
}
