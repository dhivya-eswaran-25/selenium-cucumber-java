package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class CartPage {
WebDriver driver;
Actions a;
@FindBy(xpath="//div[contains(@class, 'product-image-wrapper')]") List<WebElement> products;
@FindBy(xpath="/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button") WebElement viewproductaddtocart;
@FindBy(xpath="//button[contains(@class,'btn btn-success close-modal btn-block')]") WebElement continueshopping;
@FindBy(xpath="//div[contains(@id,'cartModal')]") WebElement messagebox;
@FindBy(xpath="//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a") WebElement viewcart;
//@FindBy(xpath="//div[contains(@id,'cartModal')]") WebElement modal;

@SuppressWarnings("null")
public CartPage(WebDriver driver){
    a=new Actions(driver);
    this.driver=driver;
    PageFactory.initElements(driver, this);
}
    public WebElement product(int i){
        List<WebElement>element = new ArrayList<>();
        element=driver.findElements(By.xpath("//div[contains(@class, 'product-image-wrapper')]"));
        return element.get(i); 
    }
    public WebElement addToCart(int i){
        List<WebElement>element = new ArrayList<>();
        element=driver.findElements(By.xpath("//a[contains(@class, 'btn btn-default add-to-cart')]"));
        return element.get(i); 
    }
    public void clickProductAddToCart(String productname){
        int l=products.size();
        for(int i=0;i<l;i++){
            WebElement p=product(i);
            String text=p.getText();
            WebElement prdt=addToCart(i);
            if(text.contains(productname)){
                prdt.click();
                break;
            }
        }
    }
    public void addMultiProductsToCart(String pn){
        int l=products.size();
        for(int i=0;i<l;i++){
            WebElement pr=product(i);
            String text=pr.getText();
            WebElement prdt=addToCart(i);
            if(text.contains(pn)){
                prdt.click();
                clickContinueShopping();
                break;
            }
        }
    }
    public void clickAddToCart(){
        viewproductaddtocart.click();
    }
    public void clickContinueShopping(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cartModal\"]")));
        continueshopping.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"cartModal\"]")));
    }
    public String getMessage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        a.moveToElement(messagebox);
        String text=messagebox.getText();
        return text;
    }
    public void clickViewCartLink(){
        viewcart.click();
    }
}


