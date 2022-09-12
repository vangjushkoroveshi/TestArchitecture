package driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    public RemoteWebDriver initializeDriver(String browser, String url) throws MalformedURLException {

        RemoteWebDriver driver;
        String br = System.getProperty("browser", browser);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", br);

        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                capabilities);
//        if (browser.equalsIgnoreCase("chrome")){
//            WebDriverManager.chromedriver().cachePath("Drivers").setup();
//            driver = new ChromeDriver();
//        } else if(browser.equalsIgnoreCase("firefox")){
//            WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
//            driver = new FirefoxDriver();
//        } else {
//            throw new IllegalStateException("Invalid browser");
//        }

        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
}
