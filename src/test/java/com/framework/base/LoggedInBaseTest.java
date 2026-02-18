package com.framework.base;

import org.testng.annotations.BeforeMethod;

import com.framework.pages.LoginPage;

public class LoggedInBaseTest extends BaseTest {

    @BeforeMethod
    public void loginSetup() {

        LoginPage lp = new LoginPage(driver);

        lp.login(
            prop.getProperty("username"),
            prop.getProperty("password")
        );
    }
}
