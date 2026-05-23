package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    @FindBy(xpath="//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]") WebElement email;
    @FindBy(xpath="//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]") WebElement password;
    @FindBy(xpath="//*[@id=\"form\"]/div/div/div[1]/div/form/button") WebElement login;
    @FindBy(xpath="//*[@id=\"form\"]/div/div/div[1]/div/form/p") WebElement msg;
    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void getEmail(String emailid){
        email.clear();
        email.sendKeys(emailid);
    }
    public void getPassword(String pwd){
        password.clear();
        password.sendKeys(pwd);
    }
    public void clickLogin(){
        login.click();
    }
    public String getErrorMsg(){
        String text=msg.getText();
        return text;
    }
}


