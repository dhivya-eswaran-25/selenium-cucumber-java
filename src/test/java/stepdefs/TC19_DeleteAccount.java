package stepdefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import io.cucumber.java.en.*;

public class TC19_DeleteAccount{
    private WebDriver driver;
    HomePage hp;
    public TC19_DeleteAccount(){
        this.driver=LaunchWebsite.driver;
        hp=new HomePage(driver);
    }
    @When("User clicks the delete account button")
    public void clickDeleteAccountOption(){
        hp.clickDeleteAccount();  
    } 
    @Then("Account deleted successfully")
    public void verifyAccountDeleted(){
        String url=driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.automationexercise.com/delete_account");
        String text=driver.getPageSource();
        Assert.assertTrue(text.contains("Account Deleted!"));
        Assert.assertTrue(text.contains("Your account has been permanently deleted!"));
        Assert.assertTrue(text.contains("You can create new account to take advantage of member privileges to enhance your online shopping experience with us."));
    }
    @And("User clicks the continue button")
    public void clickContinueButton(){
        hp.clickContinue();
        String url=driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.automationexercise.com/");       
    }
}    
