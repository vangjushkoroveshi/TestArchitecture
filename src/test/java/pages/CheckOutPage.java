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

public class CheckOutPage extends BasePage {

    private By checkout = By.id("checkout");
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueBtn = By.id("continue");
    private By productName = By.xpath("//div[@class='inventory_item_name']");
    private By finish = By.id("finish");
    private By message = By.xpath("//div[@id='checkout_complete_container']/h2");
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckoutButton(){
        driver.findElement(checkout).click();
    }

    public void adduserInformation(String firsname, String lastname, String zipCode){
        driver.findElement(firstName).sendKeys(firsname);
        driver.findElement(lastName).sendKeys(lastname);
        driver.findElement(postalCode).sendKeys(zipCode);
    }
    public void clickContinue(){
        driver.findElement(continueBtn).click();
    }
    public String ProductName(){
        return this.wait.until(ExpectedConditions.visibilityOf(driver.findElement(productName))).getText();
    }
    public void clickFinish(){
        driver.findElement(finish).click();
    }
    public String checkoutMessage(){
        return this.wait.until(ExpectedConditions.visibilityOf(driver.findElement(message))).getText();
    }
}
