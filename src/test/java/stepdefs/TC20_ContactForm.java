package stepdefs;

import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import cucumbertutorial.pages.HomePage;
import cucumbertutorial.pages.ContactUsPage;
import io.cucumber.java.en.*;

public class TC20_ContactForm {
    private WebDriver driver;
    HomePage hp;
    ContactUsPage cp;
    public TC20_ContactForm(){
        this.driver=LaunchWebsite.driver;
        hp=new HomePage(driver);
        cp=new ContactUsPage(driver);
    }
    @When("Logged in user navigates to the contact us page")
    public void loggedinContactUsPage(){
        hp.clickLoggedinContactUs();
    }
    @Then("User navigates to the contact us page")
    public void contactUsPage(){
        hp.clickContactUs();
    }
    @Then("Contact us page is displayed")
    public void verifyContactUsPage(){
        String url=driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.automationexercise.com/contact_us","Not navigated to contactus page");
        //String text=driver.getPageSource();
        //Assert.assertTrue(text.contains("Contact Us"));
        //Assert.assertTrue(text.contains("Get In Touch"));  
        //Assert.assertTrue(text.contains("Feedback For Us"));
        //Assert.assertTrue(text.contains("We really appreciate your response to our website.Kindly share your feedback with us at feedback@automationexercise.com.If you have any suggestion areas or improvements, do let us know. We will definitely work on it.Thank you"));         
    }
    @And("User fills the contact form {string} {string} {string} {string}")
    public void enterMsgDetails(String name,String email,String subject,String msg){
        cp.getName(name);
        cp.getEmail(email);
        cp.getSubject(subject);
        cp.getMessage(msg);
    }
    @And("Attach file with message")
    public void uploadFile(){
        String filePath=cp.getFilePath();
        System.out.println(filePath);
        cp.clickChooseFile(filePath);
    }
    @When("User submits the message")
    public void clkSubmit(){
        cp.clickSubmit();
    }
    @Then("Message should be submitted successfully")
    public void verifyMsgSubmitted(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText(); 
        Assert.assertEquals(alertText,"Press OK to proceed!");
        alert.accept();
        String text=driver.getPageSource();
        Assert.assertTrue(text.contains("Success! Your details have been submitted successfully."));
    }
    @And("Click on home button")
    public void validSignup(){
        cp.clickHome();
        String url=driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.automationexercise.com/","Not navigated back to home page");
    }
}

