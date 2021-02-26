package com.ui.upgradeTest;


import com.ui.upgradeTest.pages.MyStorePageUpgrade;
import com.ui.upgradeTest.pages.SearchMyStorePageUpgrade;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckSearchPageTest extends UpgradeBaseTest{
    private MyStorePageUpgrade myStorePageUpgrade;

    @BeforeClass
    public void beforeClass(){
        initTools().doImplicitWait();
        myStorePageUpgrade = openMyStorePageUpgrade();

    }

    @Test
    @Description("Test to search dress and check a correct page")
    public void checkSearchPage() {
        String searchWord = "dress";
        String myStoreTitle = "My Store";
        String searchTitle = "Search - My Store";

        Assert.assertEquals(myStorePageUpgrade.getTitle(),myStoreTitle);
        SearchMyStorePageUpgrade searchMyStorePageUpgrade = myStorePageUpgrade.inputSearchField
                (searchWord, myStorePageUpgrade.getSearchField());
        Assert.assertEquals(searchMyStorePageUpgrade.getTitle(),searchTitle);


    }


}
