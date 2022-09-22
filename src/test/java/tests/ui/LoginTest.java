package tests.ui;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
public class LoginTest extends BaseTest {

    @Test
    @Parameters({"username", "password"})
    public void loginTestWithCorrectCredentials(String username, String password){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.loginValidate());
    }
}
