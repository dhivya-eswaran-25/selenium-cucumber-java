package stepdefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import io.cucumber.java.en.*;

public class TC21_HomePage {
    private WebDriver driver;
    HomePage hp;
    public TC21_HomePage(){
        this.driver=LaunchWebsite.driver;
        hp=new HomePage(driver);
    }
    @Given("User navigates to the home page")
    public void homePage(){
        hp.goToHome();
    }
    @When("Logged in user navigates to the Test Cases page")
    public void loggedinTestCases(){
        hp.clickLoggedinTestCases();
    }
    @When("User navigates to the Test Cases page")
    public void testCasesPage(){
        hp.clickTestCases();
    }
    @Then("Test Cases page is displayed")
    public void verifyTestCasesPage(){
        String url=driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.automationexercise.com/test_cases","Not navigated to test cases page");
        String text=driver.getPageSource();
        Assert.assertTrue(text.contains("Test Cases")); 
    }
    @When("Logged in user navigates to the API Testing page")
    public void loggedinAPITesting(){
        hp.clickLoggedinAPITesting();
    }
    @When("User navigates to the API Testing page")
    public void apiTestingPage(){
        hp.clickAPITesting();
    }
    @Then("API Testing page is displayed")
    public void verifyAPITestingPage(){
        String url=driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.automationexercise.com/api_list");
        String text=driver.getPageSource();
        Assert.assertTrue(text.contains("APIs List for practice"));     
    }
    @When("Logged in user navigates to the Video Tutorials page")
    public void loggedinVideoTutorials(){
        hp.clickLoggedinVideoTutorials();
    }
    @When("User navigates to the Video Tutorials page")
    public void videoTutorialsPage(){
        hp.clickVideoTutorials();
    }
    @Then("Video Tutorials page is displayed")
    public void verifyVideoTutorialsPage(){
        String url=driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.youtube.com/c/AutomationExercise");
        String text=driver.getPageSource();
        Assert.assertTrue(text.contains("AutomationExercise"));     
    }
}


