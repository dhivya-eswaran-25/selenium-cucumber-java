package stepdefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import io.cucumber.java.en.*;

public class TC02_InvalidLogin{
    private WebDriver driver;
    HomePage hp;
    LoginPage lp;
	public TC02_InvalidLogin(){
		this.driver = LaunchWebsite.driver;
        hp=new HomePage(driver);
        lp=new LoginPage(driver);
	}

  /*  @Given("User navigates to the login page")
    public void loginpage(){        
        hp.clickLogin();
    }*/
    @And ("User enters invalid username and password")
    public void enterUserDetails(){
        lp.getEmail("tester123x@mailer.com");
        lp.getPassword("test@123x");
    }
    @When ("User clicks login button")
    public void clickLoginButton(){
        lp.clickLogin(); 
    }
    @But ("Login failed")
    public void invalidUserLogin(){
        String text=lp.getErrorMsg();
        System.out.println(text);
        Assert.assertEquals(text,"Your email or password is incorrect!","Incorrect error message");
        System.out.println("User not logged in with invalid credentials");
    }
}


