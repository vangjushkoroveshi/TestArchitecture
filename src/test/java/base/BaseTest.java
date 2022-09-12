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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    private final ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    protected void setDriver(RemoteWebDriver driver) {
        this.driver.set(driver);
    }
    protected WebDriver getDriver() {
        return this.driver.get();
    }

    @BeforeMethod
    public synchronized void setUp() throws MalformedURLException {
        setDriver(new DriverManager().initializeDriver());
    }

    @AfterMethod
    public synchronized void tearDown() {
        getDriver().quit();
    }
}