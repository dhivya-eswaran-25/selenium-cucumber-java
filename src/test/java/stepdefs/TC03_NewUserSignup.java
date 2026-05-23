package stepdefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import cucumbertutorial.pages.HomePage;
import cucumbertutorial.pages.SignupPage;
import io.cucumber.java.en.*;

public class TC03_NewUserSignup {
    private WebDriver driver;
    HomePage hp;
    SignupPage sp;
    public TC03_NewUserSignup(){
        this.driver=LaunchWebsite.driver;
        hp=new HomePage(driver);
        sp=new SignupPage(driver);
    }
    @Given("User navigates to the signup page")
    public void signupPage(){
        hp.clickSignup();
    }
    @And("User enters name and email")
    public void enterUserDetails(){
        sp.getName("testz");
        sp.getEmail("testerz123@mailer.com");
    }
    @And("User clicks signup button")
    public void clkSignup(){
        sp.clickSignup();
    }
    @And("User enters account information")
    public void accountInfo(){
        sp.getTitle("Mrs");
        sp.getReqdName("tester");
        sp.getPassword("R@ndom2025");
        sp.getDOB("17","April","2000");
        sp.selectNewsletter();
        sp.selectPartnersletter();
    }
    @And ("User enters address information")
    public void addressInfo(){
        sp.getFirstName("first");
        sp.getLastName("lname");
        sp.getCompanyName("ABC Ltd");
        sp.getAddress1("11,north ave");
        sp.getAddress2("4th street");
        sp.getCountryName("United States");
        sp.getState("NJ");
        sp.getCity("minn");
        sp.getZipcode("54601");
        sp.getMobileNumber("+16789073215");
        sp.deselectNewsletter();
        sp.deselectPartnersletter();
    }
    @When ("User clicks create acoount")
    public void clkCreateAccount(){
        sp.clickCreateAccount();
    }
    @Then("User created account successfully")
    public void validSignup(){
        String url=driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.automationexercise.com/account_created","New accout not created");
        String text=driver.getPageSource();
        Assert.assertTrue(text.contains
        ("Congratulations! Your new account has been successfully created!"));
        sp.clickContinue();
        String url2=driver.getCurrentUrl();
        Assert.assertEquals(url2,"https://www.automationexercise.com/","Not navigated back to home page");
    }
}
