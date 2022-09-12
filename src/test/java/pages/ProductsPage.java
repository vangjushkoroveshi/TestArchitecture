package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {

    private By productList = By.xpath("//div[@class='inventory_item_name']");
    private By dropdownElement = By.xpath("//select[@data-test='product_sort_container']");
    private By shoppingCart = By.xpath("//a[@class='shopping_cart_link' ]");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getListOfProductsSorting() {

        List<String> ProductsName = new ArrayList<>();
        List<WebElement> productsElement = driver.findElements(productList);

        for (int i = 0; i < productsElement.size(); i++) {
            System.out.println(productsElement.get(i).getText());
            ProductsName.add(productsElement.get(i).getText());
        }
        return ProductsName;
    }
    public void select(String value){
        Select dropdown  = new Select(driver.findElement(dropdownElement));
        dropdown.selectByValue(value);
    }
    public void selectProduct(String productName){
        WebElement product = this.driver.findElement(By.xpath("//div[@class='inventory_item_name' and contains(text(), '"+productName+"')]/ancestor::div[@class='inventory_item_label']/following-sibling::div/button"));
        product.click();
    }
    public void goToCard(){
        driver.findElement(shoppingCart).click();
    }

}