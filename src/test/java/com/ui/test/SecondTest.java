package com.ui.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SecondTest {
    WebDriver driver;
    WebElement searchField, blouse;

    @BeforeMethod
    //    or BeforeClass
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    @Description("Test to search dress and check a correct page")
    public void checkPage() {
        searchField = driver.findElement(By.xpath("//input[@id='search_query_top']"));
        searchField.sendKeys("dress");
        searchField.sendKeys(Keys.ENTER);
        assertEquals(driver.getTitle(), "Search - My Store");
    }

    @Test(priority = 2,dependsOnMethods = "checkPage")
    @Description("Test to find product and check his price")
    public void checkPriceOfProduct() {
        List<WebElement> searchResults = driver.findElements(By.xpath("//li[contains(@class,'ajax_block_product')]"));
        blouse = searchResults.stream().
                filter(element -> element.getText().
                        contains("Blouse")).findAny().orElseThrow();
        assertTrue(blouse.getText().contains("$27.00"));
    }

    @Test(priority = 3,dependsOnMethods = "checkPage")
    @Description("Test to add product into shopping-cart and check him in cart")
    public void checkProductInShoppingCart() {


        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(
                By.xpath("//h5[@itemprop='name']/child::a[contains(text(),'Blouse')]"));
        builder.moveToElement(element).build().perform();

        WebElement addToCart = driver.findElement(
                By.xpath("//a[@data-id-product='2']/child::span[contains(text(),'Add to cart')]"));
        addToCart.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement checkout = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//span[contains(.,'Proceed to checkout')]")));
        checkout.click();

        assertEquals(driver.getTitle(), "Order - My Store");
        WebElement productInCart = driver.findElement(By.xpath("//tr[@id='product_2_7_0_0']"));
        assertTrue(productInCart.getText().contains("Blouse"));
    }


    @AfterMethod
//    or AfterClass
    public void tearDown() {
        driver.quit();
    }
}
