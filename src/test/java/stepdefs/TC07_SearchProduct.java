package stepdefs;

import java.util.LinkedHashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import cucumbertutorial.pages.HomePage;
import cucumbertutorial.pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC07_SearchProduct {
    private WebDriver driver;
    HomePage hp;
    ProductsPage pp;
    public TC07_SearchProduct(){
        this.driver=LaunchWebsite.driver;
        hp=new HomePage(driver);
        pp=new ProductsPage(driver);
    }
    @And("User enters {string} in the search box")
    public void enterSearchText(String text){
        pp.getSearchText(text);
    }
    @When("User clicks the search button")
    public void clkSearchButton(){
        pp.clickSearchButton();
    }
    @Then("Search results are displayed")
    public Map<String,Float> productsList(){
        Map<String,Float> itemsList=new LinkedHashMap<>();
        itemsList=pp.productList(); 
        if(itemsList.size()>0){
            System.out.println("Search result: "+itemsList);
        }
        else{
            System.out.println("No products found");
        }
        return itemsList;      
    }
}
