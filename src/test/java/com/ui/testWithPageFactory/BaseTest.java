package com.ui.testWithPageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageFactory.page.MyStorePage;
import pageFactory.page.SearchMyStorePage;
import pageFactory.tools.WebElementUtils;

public class BaseTest {
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

    public MyStorePage openMyStorePage() {
        driver.get("http://automationpractice.com/index.php");
        return new MyStorePage(driver);
    }
    public SearchMyStorePage openSearchMyStorePage(){
        driver.get("http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=");
        return new SearchMyStorePage(driver);
    }

    public WebElementUtils initTools() {
        return webElementUtils = new WebElementUtils(driver);
    }
}
