package tests.ui;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;

public class InvalidLoginTest extends BaseTest {

    @Test
    @Parameters({"username", "password"})
    public void loginTestWithIncorrectCredential(String username, String invalidPassword){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(username, invalidPassword);
        Assert.assertEquals(loginPage.errorMsgOnLoginPage(), "Epic sadface: Username and password do not match any user in this service");
    }
}
