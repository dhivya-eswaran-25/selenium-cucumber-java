package pages;

import java.time.Duration;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewCartPage {
WebDriver driver;
Actions a;
@FindBy(xpath="//table[contains(@id,'cart_info_table')]//tr[contains(@id,'product')]") List<WebElement> products;
@FindBy(xpath="//table[contains(@id,'cart_info_table')]//tr[contains(@id,'product')]//td[contains(@class,'cart_description')]") List<WebElement> name;
@FindBy(xpath="//table[contains(@id,'cart_info_table')]//tr[contains(@id,'product')]//td[contains(@class,'cart_price')]") List<WebElement> price;
@FindBy(xpath="//table[contains(@id,'cart_info_table')]//tr[contains(@id,'product')]//td[contains(@class,'cart_quantity')]") List<WebElement> quantity;
@FindBy(xpath="//table[contains(@id,'cart_info_table')]//tr[contains(@id,'product')]//td[contains(@class,'cart_total')]") List<WebElement> total;
@FindBy(xpath="//table[contains(@id,'cart_info_table')]//tr[contains(@id,'product')]//td[contains(@class,'cart_delete')]") List<WebElement> delete;
@FindBy(xpath="/html/body/section/div/div[2]/span/p/a") WebElement addproductslink;
@FindBy(xpath="//*[@id=\"do_action\"]/div[1]/div/div/a") WebElement proceedtocheckout;
@FindBy(xpath="/html/body/section/div/section/div[2]/div/div/div[3]/button") WebElement continueoncart;
@FindBy(xpath="//div[contains(@id,'checkoutModal')]") WebElement modal;
@FindBy(xpath="//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a") WebElement loginlink;


public ViewCartPage(WebDriver driver){
    a=new Actions(driver);
    this.driver=driver;
    PageFactory.initElements(driver, this);
}
    public void clickAddProductsLink(){
        addproductslink.click();
    }
    public WebElement productName(int i){
        List<WebElement> element = driver.findElements(By.xpath("//table[contains(@id,'cart_info_table')]//tr[contains(@id,'product')]//td[contains(@class,'cart_description')]"));
        return element.get(i); 
    }
    public void clickDeleteProduct(String productname){
        int l=products.size();
        for(int i=0;i<l;i++){
            WebElement p= productName(i);
            WebElement d=productName(i).findElement(By.xpath("//i[contains(@class,'fa fa-times')]"));
            String text=p.getText();
            if(text.contains(productname)){
                a.moveToElement(d);
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(@class,'cart_delete')]")));
                d.click();
                break;
            }
        }     
    }
    public List<String> getProductList(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        List<String> productname=new ArrayList<>();
        List<WebElement> element = driver.findElements(By.xpath("//table[contains(@id,'cart_info_table')]//tr[contains(@id,'product')]//td[contains(@class,'cart_description')]"));
        for(WebElement e:element){
            productname.add(e.getText());
        }
        return productname; 
        }
    public void clickProceedToCheckout(){
        proceedtocheckout.click();
    }
    public void clickContinueOnCart(){
        continueoncart.click();
    }
    public String getMessage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        a.moveToElement(modal);
        String text=modal.getText();
        return text;
    }
    public void clickRegisterLoginLink(){
        loginlink.click();
    }
    public void clickProductDescLink(String productname){
        int l=name.size();
        for(int i=0;i<l;i++){
            WebElement d=driver.findElement(By.xpath("//table[contains(@id,'cart_info_table')]//tr[contains(@id,'product')]//td[contains(@class,'cart_description')]//a[contains(@href,'product_details')]"));
            String text=d.getText();
            if(text.contains(productname)){
                a.moveToElement(d);
                d.click();
                break;
            }
        }     
    }
}


