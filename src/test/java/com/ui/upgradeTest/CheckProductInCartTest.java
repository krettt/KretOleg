package com.ui.upgradeTest;


import com.ui.upgradeTest.pages.OrderMyStorePageUpgrade;
import com.ui.upgradeTest.pages.SearchMyStorePageUpgrade;
import jdk.jfr.Description;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckProductInCartTest extends UpgradeBaseTest {

    private SearchMyStorePageUpgrade searchMyStorePageUpgrade;

    @BeforeClass
    public void beforeClass(){
        initTools().doImplicitWait();
        searchMyStorePageUpgrade =openSearchMyStorePageUpgrade();
    }

    @Test
    @Description("Test to add product into shopping-cart and check him in cart")
    public void checkProductInCart() {

        String searchTitle = "Search - My Store";
        String orderTitle ="Order - My Store";
        String stringBlouse = "Blouse";
        Assert.assertEquals(searchMyStorePageUpgrade.getTitle(),searchTitle);

        initTools().doAction(searchMyStorePageUpgrade.getBlouse());
        searchMyStorePageUpgrade.getBlouseAddToCart().click();
        OrderMyStorePageUpgrade orderMyStorePageUpgrade= searchMyStorePageUpgrade.clickToCheckout
                (searchMyStorePageUpgrade.getCheckout());

        assertEquals(orderMyStorePageUpgrade.getTitle(),orderTitle);
        WebElement productInCart = orderMyStorePageUpgrade.getProductInCart();
        assertTrue(orderMyStorePageUpgrade.checkProduct(productInCart,stringBlouse));
    }
}
