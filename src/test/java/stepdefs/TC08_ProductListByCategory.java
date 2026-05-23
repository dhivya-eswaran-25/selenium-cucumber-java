package stepdefs;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;
import org.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.ProductsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC08_ProductListByCategory {
    private WebDriver driver;
    HomePage hp;
    ProductsPage pp;
    public TC08_ProductListByCategory(){
        this.driver=LaunchWebsite.driver;
        hp=new HomePage(driver);
        pp=new ProductsPage(driver);
    }
    @When("User clicks the women dress category")
    public void clickWomenDressCategory(){
        pp.clickWomenDress();
        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));*/
        //String text=driver.findElement(By.xpath("/html/body/section/div/div[2]/div[2]/div/h2")).getText();
        //System.out.println(text);
        //Assert.assertTrue(text.contains("Dress"));
    }
    @Then("Women dresses are displayed")
    public void displayWomenDressList(){
        Map<String,Float> itemsList=new LinkedHashMap<>();
        itemsList=pp.productList(); 
        System.out.println("Women Dress list:"+itemsList);
    }
    @When("User clicks the women tops category")
    public void clickWomenTopsCategory(){
        pp.clickWomenTops();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //wait.until(ExpectedConditions.titleContains("Tops"));
    }

    @Then("Women tops are displayed")
    public void displayWomenTopsList(){
        Map<String,Float> itemsList=new LinkedHashMap<>();
        itemsList=pp.productList(); 
        System.out.println("Women Tops list:"+itemsList);
        //hp.clickProducts();
    }
    @When("User clicks the women saree category")
    public void clickWomenSareeCategory(){
        pp.clickWomenSaree();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        //wait.until(ExpectedConditions.titleContains("Saree"));
    }
    @Then("Women sarees are displayed")
    public void displayWomenSareesList(){
        Map<String,Float> itemsList=new LinkedHashMap<>();        
        itemsList=pp.productList(); 
        System.out.println("Women Saree list:"+itemsList);
    }
    @When("User clicks the men tshirt category")
    public void clickMenTshirtCategory(){
        hp.clickProducts();
        pp.clickMenTshirt();
    }
    @Then("Men tshirts are displayed")
    public Map<String,Float> displayMenTshirtList(){
        Map<String,Float> itemsList=new LinkedHashMap<>();
        itemsList=pp.productList(); 
        System.out.println(itemsList);
        return itemsList;
    }
    @When("User clicks the men jeans category")
    public void clickMenJeansCategory(){
        pp.clickMenJeans();
    }
    @Then("Men jeans are displayed")
    public Map<String,Float> displayMenJeansList(){
        Map<String,Float> itemsList=new LinkedHashMap<>();
        itemsList=pp.productList(); 
        System.out.println(itemsList);
        return itemsList;
    }
    @When("User clicks the kids dress category")
    public void clickKidsdressCategory(){
        pp.clickKidsDress();
    }
    @Then("Kids dress are displayed")
    public Map<String,Float> displayKidsDressList(){
        Map<String,Float> itemsList=new LinkedHashMap<>();
        itemsList=pp.productList(); 
        System.out.println(itemsList);
        return itemsList;
    }
    @When("User clicks the kids tops category")
    public void clickKidsTopsCategory(){
        pp.clickKidsDress();
    }
    @Then("Kids tops are displayed")
    public Map<String,Float> displayKidsTopsList(){
        Map<String,Float> itemsList=new LinkedHashMap<>();
        itemsList=pp.productList(); 
        System.out.println(itemsList);
        return itemsList;
    }
}
