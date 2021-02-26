package com.ui.upgradeTest;



import com.ui.upgradeTest.pages.SearchMyStorePageUpgrade;
import jdk.jfr.Description;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CheckPriceOfProductTest extends UpgradeBaseTest{
    private SearchMyStorePageUpgrade searchMyStorePageUpgrade;

    @BeforeClass
    public void beforeClass(){
        initTools().doImplicitWait();
        searchMyStorePageUpgrade =openSearchMyStorePageUpgrade();
    }


    @Test
    @Description("Test to find product and check his price")
    public void checkPriceOfProduct() {

        String searchMyStoreTitle = "Search - My Store";
        String priceOfBlouse = "$27.00";
        String stringBlouse = "Blouse";

        Assert.assertEquals(searchMyStorePageUpgrade.getTitle(),searchMyStoreTitle);

        WebElement blouse =searchMyStorePageUpgrade.findBlouseFromSearchResults
                (searchMyStorePageUpgrade.getSearchResults(),stringBlouse);

        assertTrue(searchMyStorePageUpgrade.checkPrice(blouse,priceOfBlouse));
    }

}
