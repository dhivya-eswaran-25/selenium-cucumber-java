package stepdefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import cucumbertutorial.pages.*;
import io.cucumber.java.en.*;

public class TC05_Subscription{
    private WebDriver driver;
    HomePage hp;
    SubscriptionPage sp;
    public TC05_Subscription(){
        this.driver=LaunchWebsite.driver;
        hp=new HomePage(driver);
        sp=new SubscriptionPage(driver);
    }
    @And("User enters email under subscription")
    public void getSubscribeEmail(){
        sp.getSubscriptionEmail("xyz@abc.com");
    }
    @When("User clicks on subscription button")
    public void clickSubscrptn(){
        sp.clickSubscribe();
    }
    @Then("Successful subscription message displayed")
    public void verifyMsg(){
        String text=driver.getPageSource();
        Assert.assertTrue(text.contains("You have been successfully subscribed!"));  
    }
}
