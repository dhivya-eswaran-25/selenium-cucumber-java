package stepdefs;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.*;

public class LaunchWebsite{
    public static WebDriver driver;
    public static String url="https://www.automationexercise.com/";
    @Before
    public void openWebsite(){
        driver=ChooseBrowser.chooseBrowser("chrome");
        driver.get(url);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img")));
        System.out.println("Website launched successfully");
    }
    //@After
    public void closeBrowser(){
            if(driver != null){
            driver.quit();
            driver=null;
        }
    }
}
