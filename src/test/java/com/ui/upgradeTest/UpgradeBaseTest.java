package com.ui.upgradeTest;

import com.ui.upgradeTest.pages.MyStorePageUpgrade;
import com.ui.upgradeTest.pages.SearchMyStorePageUpgrade;
import com.ui.upgradeTest.tools.WebElementUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class UpgradeBaseTest {
    protected WebDriver driver;
    protected WebElementUtils webElementUtils;



    @BeforeClass
    public void initDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public MyStorePageUpgrade openMyStorePageUpgrade() {
        driver.get("http://automationpractice.com/index.php");
        return new MyStorePageUpgrade(driver);
    }
    public SearchMyStorePageUpgrade openSearchMyStorePageUpgrade(){
        driver.get("http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=");
        return new SearchMyStorePageUpgrade(driver);
    }

    public WebElementUtils initTools() {
        return webElementUtils = new WebElementUtils(driver);
    }
}
