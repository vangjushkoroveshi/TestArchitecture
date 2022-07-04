package base;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected RemoteWebDriver driver;

    @BeforeTest
    public void setupDriver() throws MalformedURLException {

        if (System.getProperty("BROWSER") !=null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setCapability("platformName", Platform.LINUX);

            driver = new RemoteWebDriver(new URL("http://localhost:4444"), firefoxOptions);

        }
        else{
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setCapability("platformName", Platform.LINUX);
            chromeOptions.setCapability("browserName", "chrome");
            driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);

        }
        driver.manage().window().maximize();
    }

    @AfterTest
    public void quiteBrowser(){
        this.driver.quit();
    }
}
