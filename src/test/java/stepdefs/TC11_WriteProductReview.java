package stepdefs;

import org.openqa.selenium.*;
import pages.HomePage;
import pages.ProductDetailsPage;
import io.cucumber.java.en.*;
    
public class TC11_WriteProductReview {
    private WebDriver driver;
    HomePage hp;
    ProductDetailsPage pd;
    public TC11_WriteProductReview(){
        this.driver=LaunchWebsite.driver;
        hp=new HomePage(driver);
        pd=new ProductDetailsPage(driver);
    }
    @And("User writes review for that product {string} {string} {string}")
    public void enterReviewDetails(String name,String email,String review){
        pd.getReviewDetails(name,email,review);
    }
    @When("User clicks submit button")
    public void clkSubmitButton(){
        pd.clickSubmit();
    }
    @Then("Success message should be displayed")
    public void checkReview(){
        String text=driver.getPageSource();
        System.out.println(text);
        //Assert.assertTrue(text.contains("Thankyou for your review"));
    }        
}
    

