package stepdefs;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import cucumbertutorial.pages.HomePage;
import io.cucumber.java.en.*;

public class TC18_Logout{
    private WebDriver driver;
    HomePage hp;
    public TC18_Logout(){
        this.driver=LaunchWebsite.driver;
        hp=new HomePage(driver);
    }
    @When("User clicks the logout button")
    public void clickLogoutOption(){
        hp.clickLogout();  
    } 
    @Then("User logged out successfully")
    public void verifyUserLoggedOut(){
        String url=driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.automationexercise.com/login");
    }
}    


