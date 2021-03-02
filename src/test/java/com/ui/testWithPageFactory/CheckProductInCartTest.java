package com.ui.testWithPageFactory;

import jdk.jfr.Description;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageFactory.page.OrderMyStorePage;
import pageFactory.page.SearchMyStorePage;

import static org.testng.AssertJUnit.assertTrue;

public class CheckProductInCartTest extends BaseTest{
    private SearchMyStorePage searchMyStorePage;

    @BeforeClass
    public void beforeClass(){
        initTools().doImplicitWait();
        searchMyStorePage =openSearchMyStorePage();
    }

    @Test
    @Description("Test to add product into shopping-cart and check him in cart")
    public void checkProductInCart() {

        String searchTitle = "Search - My Store";
        String orderTitle ="Order - My Store";
        String stringBlouse = "Blouse";
        Assert.assertEquals(searchMyStorePage.getTitle(),searchTitle);

        WebElement blouse =searchMyStorePage.findElementFromList(stringBlouse);
        initTools().doAction(blouse);
        searchMyStorePage.getBlouseAddToCart();
        OrderMyStorePage orderMyStorePage= searchMyStorePage.clickToCheckout();

        Assert.assertEquals(orderMyStorePage.getTitle(),orderTitle);
        Assert.assertTrue(orderMyStorePage.isProductInCart(stringBlouse),
                "Cart is empty,or it doesn't correct product");
    }
}
