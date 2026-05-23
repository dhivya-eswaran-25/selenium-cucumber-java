package pages;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;

public class ProductsPage {
WebDriver driver;
Actions a;
@FindBy(xpath="//*[@id=\"sale_image\"]") WebElement saleImage;
@FindBy(xpath="//*[@id=\"search_product\"]") WebElement searchBox;
@FindBy(xpath="//*[@id=\"submit_search\"]") WebElement searchButton;
@FindBy(xpath="//div[contains(@class, 'productinfo text-center')]") List<WebElement> products;
@FindBy(xpath="//*[@id=\"accordian\"]/div[1]/div[1]/h4/a") WebElement Women;
@FindBy(xpath="//*[@id=\"Women\"]/div/ul/li[1]/a") WebElement womenDress;
@FindBy(xpath="//*[@id=\"Women\"]/div/ul/li[2]/a") WebElement womenTops;
@FindBy(xpath="//*[@id=\"Women\"]/div/ul/li[3]/a") WebElement womenSaree;
@FindBy(xpath="//*[@id=\"accordian\"]/div[2]/div[1]/h4/a") WebElement Men;
@FindBy(xpath="//*[@id=\"Men\"]/div/ul/li[1]/a") WebElement menTshirt;
@FindBy(xpath="//*[@id=\"Men\"]/div/ul/li[2]/a") WebElement menJeans;
@FindBy(xpath="//*[@id=\"accordian\"]/div[3]/div[1]/h4/a") WebElement Kids;
@FindBy(xpath="//*[@id=\"Kids\"]/div/ul/li[1]/a") WebElement kidsDress;
@FindBy(xpath="//*[@id=\"Kids\"]/div/ul/li[2]/a") WebElement kidsTops;
@FindBy(xpath="//div[contains(@class, 'brands-name')]") WebElement brands;
@FindBy(xpath="//li[contains(@href,'Polo']") WebElement polo;


public ProductsPage(WebDriver driver){
    this.driver=driver;
    a=new Actions(driver);
    PageFactory.initElements(driver, this);
}
public Map<String,Float> productList(){
    Map<String,Float> itemList=new LinkedHashMap<>();
    for(WebElement e:products){
        String[] text=e.getText().replaceAll("Add to cart","").substring(4).split("\\s");
        String itemprice=text[0];
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<text.length;i++){
            sb.append(text[i]).append(" ");
        }
        String name=sb.toString();
        float price=Float.parseFloat(itemprice);
        itemList.put(name,price);
        }return itemList;    
    }
    public void getSearchText(String text){
        searchBox.click();
        searchBox.sendKeys(text);
    }
    public void clickSearchButton(){
        searchButton.click();
    }
    public void clickWomenDress(){
        a.moveToElement(Women).click(Women).perform();
        a.moveToElement(womenDress).click(womenDress).perform();        
    }
    public void clickWomenTops(){
        a.moveToElement(Women).click(Women).perform();
        a.moveToElement(womenTops).click(womenTops).perform();        
    }
    public void clickWomenSaree(){
        a.moveToElement(Women).click(Women).perform();
        a.moveToElement(womenSaree).click(womenSaree).perform();
    }
    public void clickMenTshirt(){
        a.moveToElement(Men).click(Men).perform();
        a.moveToElement(menTshirt).click(menTshirt).perform();
             
    }
    public void clickMenJeans(){
        a.moveToElement(Men).click(Men).perform();
        menJeans.click();        
    }
    public void clickKidsDress(){
        a.moveToElement(Kids).click(Kids).perform();
        kidsDress.click();        
    }
    public void clickKidsTops(){
        a.moveToElement(Kids).click(Kids).perform();
        kidsTops.click();        
    }
    public Map<String,Integer> listBrands(){
        Map<String,Integer> brandname=new LinkedHashMap<>();
        List<WebElement> options=brands.findElements(By.tagName("li"));
        for(WebElement e:options){  
            String name=e.findElement(By.tagName("a")).getText().substring(3); 
            String c=e.findElement(By.tagName("span")).getText().substring(1).replaceAll("\\)","");
            int count=Integer.parseInt(c);
            //JavascriptExecutor js=(JavascriptExecutor)driver;
            //name=(String)js.executeScript("return arguments[0].childNodes[1].nodeValue",e);        
            brandname.put(name,count);
        }return brandname; 
    }
    public void clickBrand(String brandname){
            List<WebElement> options=brands.findElements(By.tagName("li"));
            for(WebElement list:options){
                WebElement brand=list.findElement(By.tagName("a"));
                String name=list.findElement(By.tagName("a")).getText();
                if(name.contains(brandname)){
                    brand.click();
                    break;
                } 
            }
    }
}

