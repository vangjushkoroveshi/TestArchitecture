package tests.ui;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import java.util.Collections;
import java.util.List;

public class ProductsSortTest extends BaseTest {

    @Test
    @Parameters({"username", "password"})
    public void sortProducts(String username, String invalidPassword){

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(username, invalidPassword);

        ProductsPage productsPage = new ProductsPage(getDriver());
        productsPage.select("az");
        List<String> list_A_Z = productsPage.getListOfProductsSorting();
        productsPage.select("za");
        List<String> list_Z_A = productsPage.getListOfProductsSorting();

        // Revers the first list and compare
        Collections.reverse(list_A_Z);
        Assert.assertTrue(list_Z_A.equals(list_A_Z));;

    }
}
