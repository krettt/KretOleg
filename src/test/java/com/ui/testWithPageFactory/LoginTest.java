package com.ui.testWithPageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageFactory.page.LoginPage;
import pageFactory.page.MyAccountPage;
import pageFactory.page.MyStorePage;

public class LoginTest extends BaseTest{
    private MyStorePage myStorePage;

    @BeforeClass
    public void beforeClass() {
        initTools().doImplicitWait();
        myStorePage = openMyStorePage();

    }

    @Test
    public void loginMyStore() {
        String myStoreTitle = "My Store";
        String loginTitle = "Login - My Store";
        String myAccountTitle = "My account - My Store";
        String email = "olegukkret@gmail.com";
        String pass = "09080706";
        String accountName ="Oleh Kret";

        Assert.assertEquals(myStorePage.getTitle(), myStoreTitle);
        LoginPage loginPage = myStorePage.clickSignIn();

        Assert.assertEquals(loginPage.getTitle(),loginTitle);
        MyAccountPage myAccountPage = loginPage.signIn(email, pass);

        Assert.assertEquals(myAccountPage.getTitle(),myAccountTitle);
        Assert.assertEquals(myAccountPage.getUserName(),accountName);


    }
}
