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

    //BROWSER => chrome/firefox
    //HUB_HOST =>localhost / 10.0.1.3 / hostname

    String host = "localhost";

    @BeforeTest

    public void setupDriver() throws MalformedURLException {

        if (System.getProperty("BROWSER") !=null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setCapability("platformName", Platform.LINUX);

            host = System.getProperty("HUB_HOST");
            this.driver = new RemoteWebDriver(new URL("http://"+host+":4444"), firefoxOptions);

        }
        else{
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setCapability("platformName", Platform.LINUX);
            host = System.getProperty("HUB_HOST");
            this.driver = new RemoteWebDriver(new URL("http://"+host+":4444"), chromeOptions);

        }
        driver.manage().window().maximize();
    }

    @AfterTest
    public void quiteBrowser(){
        this.driver.quit();
    }
}
