package pages;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;

public class ProductDetailsPage {
WebDriver driver;
Actions a;
@FindBy(xpath="//div[contains(@class, 'product-image-wrapper')]") List<WebElement> products;
@FindBy(xpath="//div[contains(@class,'choose')]//a[contains(@href,'/product_details/')]") List<WebElement> viewproduct;
@FindBy(xpath="/html/body/section/div/div/div[2]/div[2]/div[2]/div") WebElement productinfo;
@FindBy(xpath="/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button") WebElement addtocart;
@FindBy(xpath="//*[@id=\"quantity\"]") WebElement quantity;
@FindBy(xpath="//*[@id=\"name\"]") WebElement yourname;
@FindBy(xpath="//*[@id=\"email\"]") WebElement emailaddress;
@FindBy(xpath="//*[@id=\"review\"]") WebElement reviewtext;
@FindBy(xpath="//*[@id=\"button-review\"]") WebElement submit;


public ProductDetailsPage(WebDriver driver){
    a=new Actions(driver);
    this.driver=driver;
    PageFactory.initElements(driver, this);
}
    public WebElement products(int i){
    List<WebElement>element = driver.findElements(By.xpath("//div[contains(@class, 'product-image-wrapper')]"));
    return element.get(i); 
    } 
    public WebElement viewProduct(int i){
        List<WebElement>element = driver.findElements(By.xpath("//div[contains(@class,'choose')]//a[contains(@href,'/product_details/')]"));
        return element.get(i); 
        }
    public void clickViewProduct(String productname){
        int l=products.size();
        for(int i=0;i<l;i++){
            WebElement p=products(i);
            WebElement prdt = viewProduct(i);
            String text=p.getText();
            if(text.contains(productname)){
                prdt.click();
                break;
            }
        }
    }
    public void getQuantity(String qty){
        quantity.clear();
        quantity.sendKeys(qty);
    }
    public String getProductDetails(){
        String text=productinfo.getText();
        return text;
    } 
    public void getReviewDetails(String name,String email,String review){
        a.moveToElement(yourname).click(yourname);
        yourname.sendKeys(name);
        emailaddress.sendKeys(email);
        reviewtext.sendKeys(review);
    }
    public void clickSubmit(){
        submit.click();
    }
}


