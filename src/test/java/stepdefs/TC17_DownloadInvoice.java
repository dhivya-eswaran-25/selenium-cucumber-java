package stepdefs;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CheckoutPage;
import pages.PaymentPage;
import pages.HomePage;
import io.cucumber.java.en.*;

public class TC17_DownloadInvoice{
    private WebDriver driver;
    HomePage hp;
    PaymentPage pp; 
    CheckoutPage cp;
    public TC17_DownloadInvoice(){
        this.driver=LaunchWebsite.driver;
        hp=new HomePage(driver);
        pp=new PaymentPage(driver);
        cp=new CheckoutPage(driver);
    }
    @When("User clicks download invoice button")
    public void clikDownloadInvoice(){
        pp.clickDownloadInvoice();
        String url=driver.getCurrentUrl();
        System.out.println(url);
        Assert.assertTrue(url.contains("https://www.automationexercise.com/payment_done/"));
    } 
    @Then("Verify invoice is downloaded")
    public void verifyInvoiceDownloaded() throws InterruptedException{
        String filename = pp.getInvoiceDownloadPath();
        Thread.sleep(100);
        File file = new File(filename);
        //File[] dirContents = dir.listFiles();
        if (file.exists()){
            System.out.println("Invoice is Dowloaded");
        } else{
            System.out.println("Invoice is not downloaded");
        }
    }
    @And("Verify invoice contents")
    public void readFileContent() throws IOException{
        String filename=pp.getInvoiceDownloadPath();
        List<String> filecontent=Files.readAllLines(Paths.get(filename));
        String amount=cp.totalAmount();
        String actualfilecontent = filecontent.stream().collect(Collectors.joining(""));
        System.out.println(actualfilecontent);
        String expectedfilecontent="Hi first last, Your total purchase amount is "+amount+". Thank you";
        Assert.assertEquals(actualfilecontent.trim(),expectedfilecontent.trim());
    }
        
}    


