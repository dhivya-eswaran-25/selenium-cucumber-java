package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SubscriptionPage {
    WebDriver driver;
    Actions a;
    @FindBy(xpath="//*[@id=\"susbscribe_email\"]") WebElement subscription;
    @FindBy(id="subscribe") WebElement subscribe;
    public SubscriptionPage(WebDriver driver){
        this.driver=driver;
        a=new Actions(driver);
        PageFactory.initElements(driver,this);
    }
    public void getSubscriptionEmail(String email){
        subscription.sendKeys(email);
    }
    public void clickSubscribe(){
        subscribe.click();
    }
}


