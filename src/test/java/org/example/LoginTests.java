package org.example;

import org.example.pageobjects.LoginPage;
import org.example.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends TestRunner {

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {"testaddress728@gmail.com", "PassForTests",}};
    }

    @Test(dataProvider = "loginData")
    public void validLoginTest(String email, String password) {
        LoginPage loginPage = new LoginPage(getDriver());
        String greetings = loginPage
                .enterEmail(email)
                .enter()
                .enterPassword(password)
                .submit()
                .getGreetings();

        Assert.assertTrue(greetings.contains("Test"));
    }

    @Test
    public void invalidEmailLogin() {
        LoginPage loginPage = new LoginPage(getDriver());
        boolean isErrorAppeared = loginPage
                .enterEmail("testinvalid322@gmail.com")
                .enter()
                .isErrorMessageVisible();

        Assert.assertTrue(isErrorAppeared);
    }

    @Test(dataProvider = "loginData")
    public void invalidPasswordLogin(String email, String password) {
        LoginPage loginPage = new LoginPage(getDriver());
        boolean isErrorAppeared = loginPage
                .enterEmail(email)
                .enter()
                .enterPassword("pass")
                .enter()
                .isErrorMessageVisible();

        Assert.assertTrue(isErrorAppeared);
    }

    @Test
    public void emptyEmailLogin() {
        LoginPage loginPage = new LoginPage(getDriver());
        boolean isErrorAppeared = loginPage
                .enterEmail("")
                .enter()
                .isErrorMessageVisible();

        Assert.assertTrue(isErrorAppeared);
    }
}
