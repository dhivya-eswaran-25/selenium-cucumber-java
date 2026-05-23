package stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ChooseBrowser{
    public static WebDriver driver;
    public static WebDriver chooseBrowser(String browser){
        switch(browser.toLowerCase()){
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new"); // Required for CI
                options.addArguments("--no-sandbox"); // Required for GitHub Actions
                options.addArguments("--disable-dev-shm-usage"); // Prevents crashes in Docker
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1080");
                //WebDriver driver = new ChromeDriver(options);
                return new ChromeDriver(options);
            case "edge":
                return new EdgeDriver();
            case "firefox":
                return new FirefoxDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);

        }
    }
}
