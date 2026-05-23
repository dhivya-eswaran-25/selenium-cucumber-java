package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    @FindBy(xpath="//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a") WebElement home;
    @FindBy(xpath="//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a") WebElement loginSignup;
    @FindBy(xpath="//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a") WebElement products;
    @FindBy(xpath="//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a") WebElement cart;
    @FindBy(xpath="//div[contains(@class,'shop-menu pull-right')]//a[contains(@href,'/logout')]") WebElement logout;
    @FindBy(xpath="/html/body/header/div/div/div/div[2]/div/ul/li[5]/a") WebElement testcases;
    @FindBy(xpath="/html/body/header/div/div/div/div[2]/div/ul/li[6]/a") WebElement apitesting;
    @FindBy(xpath="/html/body/header/div/div/div/div[2]/div/ul/li[7]/a") WebElement videotutorials;
    @FindBy(xpath="//div[contains(@class,'shop-menu pull-right')]//a[contains(@href,'/test_cases')]") WebElement loggedintestcases;
    @FindBy(xpath="//div[contains(@class,'shop-menu pull-right')]//a[contains(@href,'/api_list')]") WebElement loggedinapitesting;
    @FindBy(xpath="//div[contains(@class,'shop-menu pull-right')]//a[contains(@href,'/www.youtube.com')]") WebElement loggedinvideotutorials;
    @FindBy(xpath="/html/body/header/div/div/div/div[2]/div/ul/li[8]/a") WebElement contactus;
    @FindBy(xpath="/html/body/header/div/div/div/div[2]/div/ul/li[9]/a") WebElement loggedincontactus;
    @FindBy(xpath="//div[contains(@class,'shop-menu pull-right')]//a[contains(@href,'/delete_account')]") WebElement deleteaccount;
    @FindBy(xpath="/html/body/section/div/div/div/div/a") WebElement continuee;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void goToHome(){
        home.click();
    }
    public void clickLogin(){
        loginSignup.click();
    }
    public void clickSignup(){
        loginSignup.click();
    }
    public void clickProducts(){
        products.click();
    }
    public void clickLogout(){
        logout.click();
    }
    public void clickCart(){
        cart.click();
    }
    public void clickDeleteAccount(){
        deleteaccount.click();
    }
    public void clickContinue(){
        continuee.click();
    }
    public void clickContactUs(){
        contactus.click();
    }
    public void clickLoggedinContactUs(){
        loggedincontactus.click();
    }
    public void clickTestCases(){
        testcases.click();
    }
    public void clickLoggedinTestCases(){
        loggedintestcases.click();
    }
    public void clickAPITesting(){
        apitesting.click();
    }
    public void clickLoggedinAPITesting(){
        loggedinapitesting.click();
    }
    public void clickVideoTutorials(){
        videotutorials.click();
    }
    public void clickLoggedinVideoTutorials(){
        loggedinvideotutorials.click();
    }
}
