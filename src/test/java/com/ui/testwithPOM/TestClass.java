package com.ui.testwithPOM;

import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class TestClass extends BaseTest {

    private SearchMyStorePage searchMyStorePage;
    private MyStorePage myStorePage;
    public WebElement blouse;
    String stringBlouse = "Blouse";


    @BeforeClass
    public void beforeClass() {
        myStorePage = openMyStorePage();
    }

    @AfterClass
    public void afterClass() {
        tearDown();
    }

    @Test(priority = 1)
    @Description("Test to search dress and check a correct page")
    public void checkSearchPage() {

        String searchWord = "dress";
        searchMyStorePage = myStorePage.inputSearchField(searchWord);
        assertEquals(driver.getTitle(), "Search - My Store");
    }

    @Test(priority = 2, dependsOnMethods = "checkSearchPage")
    @Description("Test to find product and check his price")
    public void checkPriceOfProduct() {
        String priceOfBlouse = "$27.00";
        blouse = searchMyStorePage.findBlouseFromSearchResults(stringBlouse);
        assertTrue(searchMyStorePage.checkPrice(blouse, priceOfBlouse));

    }

    @Test(priority = 3, dependsOnMethods = "checkPriceOfProduct")
    @Description("Test to add product into shopping-cart and check him in cart")
    public void checkProductInCart() {
        searchMyStorePage.doAction(searchMyStorePage.getBlouse());
        searchMyStorePage.getBlouseAddToCart().click();
        searchMyStorePage.doWait(searchMyStorePage.getCheckout());
        OrderMyStorePage orderMyStorePage = searchMyStorePage.clickToCheckout();

        assertEquals(driver.getTitle(), "Order - My Store");
        WebElement productInCart = orderMyStorePage.getProductInCart();
        assertTrue(orderMyStorePage.checkProduct(productInCart, stringBlouse));

    }

}
