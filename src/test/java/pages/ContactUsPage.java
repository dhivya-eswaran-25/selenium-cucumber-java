package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage{
    WebDriver driver;
    Actions a;
    @FindBy(xpath="/html/body/div/div[2]/div[1]/div/div[3]/form/div[1]/input") WebElement name;
    @FindBy(xpath="/html/body/div/div[2]/div[1]/div/div[3]/form/div[2]/input") WebElement email;
    @FindBy(xpath="/html/body/div/div[2]/div[1]/div/div[3]/form/div[3]/input") WebElement subject;
    @FindBy(xpath="/html/body/div/div[2]/div[1]/div/div[3]/form/div[4]/textarea") WebElement msg;
    @FindBy(xpath="/html/body/div/div[2]/div[1]/div/div[3]/form/div[5]/input") WebElement choosefile;
    @FindBy(xpath="/html/body/div/div[2]/div[1]/div/div[3]/form/div[6]/input") WebElement submit;
    @FindBy(xpath="/html/body/footer/div[1]/div/div/div[2]/div/form/input[2]]") WebElement subscribeemail;
    @FindBy(xpath="/html/body/footer/div[1]/div/div/div[2]/div/form/button/i") WebElement subscribebutton;
    @FindBy(xpath="/html/body/div/div[2]/div[1]/div/div[3]/a/span") WebElement homebutton;
    public ContactUsPage(WebDriver driver){
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
    public void clickSubmit(){
        submit.click();
    }
    public void getSubject(String subj){
        subject.clear();
        subject.sendKeys(subj);
    }
    public void getMessage(String text){
        msg.clear();
        msg.sendKeys(text);
    }
    public void clickChooseFile(String path){
        a =new Actions(driver);
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement uploadfile=wait.until(ExpectedConditions.elementToBeClickable(By.name("upload_file")));
        a.moveToElement(uploadfile).sendKeys(path);
    }
    public void clickHome(){
        homebutton.click();
    }
    public String getFilePath(){
        String path="C:\\Users\\403604\\Documents\\test.txt";
        return path;
    }
}