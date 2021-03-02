package com.ui.testWithPageFactory;

import jdk.jfr.Description;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageFactory.page.SearchMyStorePage;

import static org.testng.Assert.assertTrue;

public class CheckPriceOfProductTest extends BaseTest{
    private SearchMyStorePage searchMyStorePage;

    @BeforeClass
    public void beforeClass(){
        initTools().doImplicitWait();
        searchMyStorePage =openSearchMyStorePage();
    }


    @Test
    @Description("Test to find product and check his price")
    public void checkPriceOfProduct() {

        String searchMyStoreTitle = "Search - My Store";
        String priceOfBlouse = "$27.00";
        String stringBlouse = "Blouse";

        Assert.assertEquals(searchMyStorePage.getTitle(),searchMyStoreTitle);

        WebElement blouse =searchMyStorePage.findElementFromList(stringBlouse);
        Assert.assertTrue(searchMyStorePage.checkPrice(blouse,priceOfBlouse),
                "The price does not correspond to the price of the product");
    }

}

