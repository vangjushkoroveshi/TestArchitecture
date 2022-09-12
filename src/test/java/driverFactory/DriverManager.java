package driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.ConfigLoader;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    public RemoteWebDriver initializeDriver() throws MalformedURLException {

        RemoteWebDriver driver;
        String browser = System.getProperty("browser", ConfigLoader.getInstance().getBrowser());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);

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
        driver.get(ConfigLoader.getInstance().getBaseUrl());
        return driver;
    }
}
