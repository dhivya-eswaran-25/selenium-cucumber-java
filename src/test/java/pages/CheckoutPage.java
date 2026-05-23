package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;

public class CheckoutPage {
    WebDriver driver;
    Actions a;
    @FindBy(xpath="//*[@id=\"ordermsg\"]/textarea") WebElement textarea;
    @FindBy(xpath="/html/body/section/div/div[7]/a") WebElement placeorder;
    @FindBy(xpath="//*[@id=\"susbscribe_email\"]") WebElement subscribeemail;
    @FindBy(xpath="//*[@id=\"subscribe\"]/i") WebElement submit;
    @FindBy(xpath="/html/body/section/div/div[3]") WebElement chkoutinfo;
    @FindBy(xpath="//div[contains(@id,'cart_info')]//p[contains(@class,'cart_total_price')]") WebElement carttotalprice;

    public CheckoutPage(WebDriver driver){
        a=new Actions(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void enterComment(String text){
        textarea.sendKeys(text);
    }
    public void clickPlaceOrder(){
        placeorder.click();
    }
    public void submitSubscription(String email){
        subscribeemail.sendKeys(email);
        submit.click();
    }
    public String verifyCheckoutInfo(){
        String text=chkoutinfo.getText();
        return text;
    }
    public String totalAmount(){
        String amount=carttotalprice.getText().substring(4);
        return amount;
    }
}
