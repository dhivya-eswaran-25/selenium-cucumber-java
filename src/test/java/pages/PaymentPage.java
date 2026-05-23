package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;

public class PaymentPage {
    WebDriver driver;
    Actions a;
    @FindBy(xpath="/html/body/section/div/div[3]/div/div[2]/form/div[5]/div/button") WebElement payandconfirmorder;
    @FindBy(xpath="/html/body/section/div/div[3]/div/div[2]/form/div[1]/div/input") WebElement cardname;
    @FindBy(xpath="/html/body/section/div/div[3]/div/div[2]/form/div[2]/div/input") WebElement cardnumber;
    @FindBy(xpath="/html/body/section/div/div[3]/div/div[2]/form/div[3]/div[1]/input") WebElement cardcvc;
    @FindBy(xpath="/html/body/section/div/div[3]/div/div[2]/form/div[3]/div[2]/input") WebElement expirationmonth;
    @FindBy(xpath="/html/body/section/div/div[3]/div/div[2]/form/div[3]/div[3]/input") WebElement expirationyear;
    @FindBy(xpath="//*[@id=\"susbscribe_email\"]") WebElement subscribeemail;
    @FindBy(xpath="//*[@id=\"subscribe\"]/i") WebElement submit;
    @FindBy(xpath="/html/body/section/div/div/div/div/a") WebElement continuebutton;
    @FindBy(xpath="/html/body/section/div/div/div/a") WebElement downloadinvoice;
    public PaymentPage(WebDriver driver){
        a=new Actions(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void enterCardDetails(String name,String nbr,String cvc,String mth,String yr){
        cardname.sendKeys(name);
        cardnumber.sendKeys(nbr);
        cardcvc.sendKeys(cvc);
        expirationmonth.sendKeys(mth);
        expirationyear.sendKeys(yr);
    }
    public void clickPayAndConfirmOrder(){
        payandconfirmorder.click();
    }
    public void submitSubscription(String email){
        subscribeemail.sendKeys(email);
        submit.click();
    }
    public void clickContinue(){
        continuebutton.click();
    }
    public void clickDownloadInvoice(){
        downloadinvoice.click();
    }
    public String getInvoiceDownloadPath(){
        String path="C:\\Users\\403604\\Downloads\\invoice.txt";
        return path;
    }
}

