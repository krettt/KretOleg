package com.ui.testWithPageFactory;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageFactory.page.MyStorePage;
import pageFactory.page.SearchMyStorePage;

public class CheckSearchPageTest extends BaseTest{
    private MyStorePage myStorePage;

    @BeforeClass
    public void beforeClass(){
        initTools().doImplicitWait();
        myStorePage = openMyStorePage();
    }

    @Test
    @Description("Test to search dress and check a correct page")
    public void checkSearchPage() {
        String searchWord = "dress";
        String myStoreTitle = "My Store";
        String searchTitle = "Search - My Store";

        Assert.assertEquals(myStorePage.getTitle(),myStoreTitle);
        SearchMyStorePage searchMyStorePage = myStorePage.inputSearchField(searchWord);
        Assert.assertEquals(searchMyStorePage.getTitle(),searchTitle);
    }
}
