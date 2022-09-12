package base;

import driverFactory.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class BaseTest {

    private final ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    protected void setDriver(RemoteWebDriver driver) {
        this.driver.set(driver);
    }
    protected WebDriver getDriver() {
        return this.driver.get();
    }

    @BeforeMethod
    @Parameters({"browser","url"})
    public synchronized void setUp(String browser, String url) throws MalformedURLException {
        setDriver(new DriverManager().initializeDriver(browser, url));
    }

    @AfterMethod
    public synchronized void tearDown() {
        getDriver().quit();
    }
}