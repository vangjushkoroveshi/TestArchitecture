package tests.ui;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CheckOutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class BuyProductTest extends BaseTest {

    @Test
    @Parameters({"username", "password"})
    public void loginTestWithCorrectCredentials(String username, String password){

        LoginPage loginPage = new LoginPage(getDriver());
//        loginPage.goTo(url);
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.loginValidate());

        ProductsPage productsPage = new ProductsPage(getDriver());
        productsPage.selectProduct("Sauce Labs Backpack");
        productsPage.goToCard();

        CheckOutPage checkOutPage = new CheckOutPage(getDriver());
        checkOutPage.clickCheckoutButton();
        checkOutPage.adduserInformation("Test","Test","1001");
        checkOutPage.clickContinue();
        Assert.assertEquals(checkOutPage.ProductName(), "Sauce Labs Backpack");

        checkOutPage.clickFinish();
        Assert.assertEquals(checkOutPage.checkoutMessage(), "THANK YOU FOR YOUR ORDER");
    }
}
