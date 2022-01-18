package tests.ui;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.UiPages;

public class UiTests extends BaseTest {

    @Test
    @Parameters({"url", "username", "password"})
    public void uiTest(String url, String username, String password){

        UiPages ui = new UiPages(driver);
        ui.goTo(url);
        System.out.println(url);
        ui.login(username, password);
        System.out.println(username+" ----- " +password);
        Assert.assertTrue(ui.loginValidate());
        System.out.println(ui.loginValidate());
    }
}
