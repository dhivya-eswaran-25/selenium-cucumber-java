package stepdefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import cucumbertutorial.pages.*;
import io.cucumber.java.en.*;

public class TC04_ExistingUserSignup {
    private WebDriver driver;
    HomePage hp;
    SignupPage sp;
    public TC04_ExistingUserSignup(){
        this.driver=LaunchWebsite.driver;
        hp=new HomePage(driver);
        sp=new SignupPage(driver);
    }
    /*@Given("User navigates to the signup page")
    public void signupPage(){
        hp.clickSignup();
    }
    @And("User enters name and email")
    public void enterExistingUserDetails(){
        sp.getName("test");
        sp.getEmail("test@zzzyyzz.com");
    }
    @When("User clicks signup button")
    public void clkSignup(){
        sp.clickSignup();
    }*/
    @But("Error message displayed")
    public void verifyErrorMsg(){
        String msg=sp.getSignupErrorMsg();
        Assert.assertTrue(msg.contains("Email Address already exist!"));   
    }
}