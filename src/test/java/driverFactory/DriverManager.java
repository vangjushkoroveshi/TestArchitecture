package driverFactory;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    public RemoteWebDriver initializeDriver(String browser, String url) throws MalformedURLException {

        RemoteWebDriver driver;
        String br = System.getProperty("browser", browser);

        if (br.equalsIgnoreCase("chrome")){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            chromeOptions.addArguments("--lang=en");
            chromeOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
            chromeOptions.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
            chromeOptions.addArguments("--disable-extensions");
            chromeOptions.addArguments("--ignore-certificate-errors");
            chromeOptions.addArguments("disable-infobars");
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                    chromeOptions);
            driver.manage().window().maximize();
            driver.get(url);
            return driver;
        } else if(browser.equalsIgnoreCase("firefox")){
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                    firefoxOptions);
            driver.manage().window().maximize();
            driver.get(url);
            return driver;
        } else {
            throw new IllegalStateException("Invalid browser");
        }
    }
}








//if (br.equalsIgnoreCase("chrome")){
//        ChromeOptions chromeOptions = new ChromeOptions();
//        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
//        chromeOptions);
//        } else if(browser.equalsIgnoreCase("firefox")){
//        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
//        firefoxOptions);
//        } else {
//        throw new IllegalStateException("Invalid browser");
//        }


//        if (browser.equalsIgnoreCase("chrome")){
//            WebDriverManager.chromedriver().cachePath("Drivers").setup();
//            driver = new ChromeDriver();
//        } else if(browser.equalsIgnoreCase("firefox")){
//            WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
//            driver = new FirefoxDriver();
//        } else {
//            throw new IllegalStateException("Invalid browser");
//    4.3.0-20220628    }