package com.ui.upgradeTest;

import com.ui.testwithPOM.BaseTest;
import com.ui.upgradeTest.pages.LoginPage;
import com.ui.upgradeTest.pages.MyAccountPage;
import com.ui.upgradeTest.pages.MyStorePageUpgrade;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends UpgradeBaseTest {
    private MyStorePageUpgrade myStorePageUpgrade;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;

    @BeforeClass
    public void beforeClass() {
        initTools().doImplicitWait();
        myStorePageUpgrade = openMyStorePageUpgrade();

    }

    @Test
    public void loginMyStore() {
        String myStoreTitle = "My Store";
        String loginTitle = "Login - My Store";
        String myAccountTitle = "My account - My Store";
        String email = "olegukkret@gmail.com";
        String pass = "09080706";
        String accountName ="Oleh Kret";

        Assert.assertEquals(myStorePageUpgrade.getTitle(), myStoreTitle);
        loginPage = myStorePageUpgrade.clickSignIn(myStorePageUpgrade.getSignInButton());

        Assert.assertEquals(loginPage.getTitle(),loginTitle);
        myAccountPage = loginPage.signIn(loginPage.getEmailSearchField(),
                loginPage.getPassSearchField(),loginPage.getSignInButton(), email, pass);

        Assert.assertEquals(myAccountPage.getTitle(),myAccountTitle);
        Assert.assertEquals(myAccountPage.getUserInfoButton().getText(),accountName);


    }

}
