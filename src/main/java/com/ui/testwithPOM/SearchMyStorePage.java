package com.ui.testwithPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchMyStorePage {
    WebDriver driver;
    private WebDriverWait wait;

    public SearchMyStorePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,5 );
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[contains(@class,'ajax_block_product')]")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//h5[@itemprop='name']/child::a[contains(text(),'Blouse')]")
    private WebElement blouse;

    @FindBy(xpath = "//a[@data-id-product='2']/child::span[contains(text(),'Add to cart')]")
    private WebElement blouseAddToCart;

    @FindBy(xpath = "//span[contains(.,'Proceed to checkout')]")
    private WebElement checkout;

    public WebElement findBlouseFromSearchResults(String searchElement) {
        return searchResults.stream().
                filter(element -> element.getText().
                        contains(searchElement)).findAny().orElseThrow();
    }
    public boolean checkPrice(WebElement checkElement,String price){
        return checkElement.getText().contains(price);
    }

    public void doAction(WebElement element){
        Actions builder = new Actions(driver);
        builder.moveToElement(element).build().perform();
    }

    public void doWait(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element)
        );
    }
    public OrderMyStorePage clickToCheckout(){
        checkout.click();
        return new OrderMyStorePage(driver);
    }

    public WebElement getBlouse() {
        return blouse;
    }

    public WebElement getBlouseAddToCart() {
        return blouseAddToCart;
    }

    public WebElement getCheckout() {
        return checkout;
    }
}
