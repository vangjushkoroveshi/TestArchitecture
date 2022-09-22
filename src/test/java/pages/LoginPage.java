package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    private By loginBtn = By.id("login-button");
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By productTitle = By.xpath("//span[@class=\"title\"]");
    private By errorMsg = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void login(String userName, String pass){
        driver.findElement(username).sendKeys(userName);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    public boolean loginValidate(){
       return this.wait.until(ExpectedConditions.visibilityOf(driver.findElement(productTitle))).isDisplayed();
    }

    public String errorMsgOnLoginPage(){
        return this.wait.until(ExpectedConditions.visibilityOf(driver.findElement(errorMsg))).getText();
    }
}
