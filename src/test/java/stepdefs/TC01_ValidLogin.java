package stepdefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC01_ValidLogin{
    private WebDriver driver;
    LoginPage lp;
    HomePage hp;
	public TC01_ValidLogin(){
		this.driver = LaunchWebsite.driver;
        lp=new LoginPage(driver);
        hp=new HomePage(driver);
	}

    @Given("User navigates to the login page")
    public void loginPage(){        
        hp.clickLogin();
    }
    @And ("User enters valid username and password")
    public void enterUserDetails(){        
        lp.getEmail("tester123@mailer.com");
        lp.getPassword("R@ndom2025");
    }

    @When ("User clicks the login button")
    public void clickLoginButton(){        
        lp.clickLogin(); 
    }

    @Then ("User logged in successfully")
    public void validUserLogin(){
        String url=driver.getCurrentUrl();
        System.out.println("Navigated to next page:"+url);
        Assert.assertEquals(url,"https://www.automationexercise.com/","User log in unsuccessful");
        System.out.println("User logged in successfully");
    }
}


