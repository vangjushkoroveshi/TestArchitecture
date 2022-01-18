package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UiPages {

    private RemoteWebDriver driver;
    private WebDriverWait wait;

    @FindBy (id = "login-button")
    private WebElement loginBtn;

    @FindBy (id = "user-name")
    private WebElement username;

    @FindBy (id = "password")
    private  WebElement password;

    @FindBy(xpath = "//span[@class=\"title\"]")
    private WebElement productTitle;

    public UiPages(RemoteWebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver,this);
    }
    public void goTo(String url){
        this.driver.get(url);
        this.wait.until(ExpectedConditions.visibilityOf(this.loginBtn));
    }
    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.loginBtn.click();
    }

    public boolean loginValidate(){
       return this.wait.until(ExpectedConditions.visibilityOf(this.productTitle)).isDisplayed();
    }
}
