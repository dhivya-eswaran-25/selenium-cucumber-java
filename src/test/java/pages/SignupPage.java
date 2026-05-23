package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignupPage {
    WebDriver driver;
    Actions a;
    @FindBy(xpath="//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]") WebElement name;
    @FindBy(xpath="//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]") WebElement email;
    @FindBy(xpath="//*[@id=\"form\"]/div/div/div[3]/div/form/button") WebElement signup;
    @FindBy(xpath="//*[@id=\"form\"]/div/div/div[1]/div/form/p") WebElement msg;
    @FindBy(xpath="//*[@id=\"form\"]/div/div/div[3]/div/form/p") WebElement signuperror;
    @FindBy(name="title") WebElement title;
    @FindBy(xpath="//*[@id=\"id_gender1\"]") WebElement titlemr;
    @FindBy(xpath="//*[@id=\"id_gender2\"]") WebElement titlemrs;
    @FindBy(xpath="/html/body/section/div/div/div/div/form/div[2]/input") WebElement requiredname;
    @FindBy(id="password") WebElement password;
    @FindBy(xpath="//*[@id=\"days\"]") WebElement day;
    @FindBy(xpath="//*[@id=\"months\"]") WebElement month;
    @FindBy(xpath="//*[@id=\"years\"]") WebElement year;
    @FindBy(id="first_name") WebElement firstname;
    @FindBy(id="last_name") WebElement lastname;
    @FindBy(id="company") WebElement company;
    @FindBy(id="address1") WebElement address1;
    @FindBy(id="address2") WebElement address2;
    @FindBy(id="country") WebElement country;
    @FindBy(id="state") WebElement state;
    @FindBy(id="city") WebElement city;
    @FindBy(id="zipcode") WebElement zipcode;
    @FindBy(id="mobile_number") WebElement mobilenumber;
    @FindBy(xpath="//*[@id=\"form\"]/div/div/div/div/form/button") WebElement createaccount;
    @FindBy(xpath="//*[@id=\"susbscribe_email\"]") WebElement subscription;
    @FindBy(id="subscribe") WebElement subscribe;
    @FindBy(xpath="//*[@id=\"newsletter\"]") WebElement newsletter;
    @FindBy(xpath="//*[@id=\"optin\"]") WebElement partners;
    @FindBy(xpath="//*[@id=\"form\"]/div/div/div/div/a") WebElement continuee;
    public SignupPage(WebDriver driver){
        this.driver=driver;
        a=new Actions(driver);
        PageFactory.initElements(driver,this);
    }

    public void getEmail(String emailid){
        email.clear();
        email.sendKeys(emailid);
    }
    public void getName(String usrname){
        name.clear();
        name.sendKeys(usrname);
    }
    public void clickSignup(){
        signup.click();
    }
    public void getReqdName(String reqdname){
        requiredname.clear();
        requiredname.sendKeys(reqdname);
    }
    public void getTitle(String text){
        if(text.equalsIgnoreCase("mr")){
            a.moveToElement(titlemr).click();
        }
        if(text.equalsIgnoreCase("mrs")){
            a.moveToElement(titlemrs).click();
        } 
    }
    public void getPassword(String pwd){
        password.sendKeys(pwd);
    }
    public void getDOB(String dd,String mon,String yyyy){
        Select d=new Select(day);
        d.selectByVisibleText(dd);
        Select m=new Select(month);
        m.selectByVisibleText(mon);
        Select y=new Select(year);
        y.selectByVisibleText(yyyy);
         
    }
    public void getCompanyName(String cmpny){
        company.sendKeys(cmpny);
    } 
    public void getFirstName(String fname){
        firstname.sendKeys(fname);    
    }
    public void getLastName(String lname){
        lastname.sendKeys(lname);
    }
    public void getCountryName(String cntry){
        Select c=new Select(country);
        c.selectByVisibleText(cntry);
    }
    public void getAddress1(String address){
        address1.sendKeys(address);       
    }
    public void getAddress2(String address){
        address2.sendKeys(address);       
    }
    public void getState(String stnm){
        state.sendKeys(stnm); 
    }
    public void getCity(String ctynm){
        city.sendKeys(ctynm);
    }
    public void getZipcode(String zipcd){
        zipcode.sendKeys(zipcd);
    }
    public void getMobileNumber(String mblnmr){
        mobilenumber.sendKeys(mblnmr); 
    }
    public void clickCreateAccount(){
        createaccount.click();
    }
    public void selectNewsletter(){
        boolean isChecked=newsletter.isSelected();
        if(!isChecked){
        newsletter.click();
        }
    }
    public void selectPartnersletter(){
        boolean isChecked=partners.isSelected();
        if(!isChecked){
        partners.click();
        }
    }
    public void deselectNewsletter(){
        boolean isChecked=newsletter.isSelected();
        if(isChecked){
        newsletter.click();
        }
    }
    public void deselectPartnersletter(){
        boolean isChecked=partners.isSelected();
        if(isChecked){
        partners.click();
        }
    }
    public void clickContinue(){
        continuee.click();        
    }
    public String getSignupErrorMsg(){
        String text=signuperror.getText();
        return text;
    }
}


