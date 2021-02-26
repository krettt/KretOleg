package com.ui.upgradeTest.pages;


import com.ui.testwithPOM.OrderMyStorePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchMyStorePageUpgrade {
    private WebDriver driver;

    public SearchMyStorePageUpgrade(WebDriver driver) {
        this.driver = driver;
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

    public String getTitle() {
        return driver.getTitle();
    }

    public WebElement findBlouseFromSearchResults(List<WebElement> searchResults,String searchElement) {
        return searchResults.stream().
                filter(element -> element.getText().
                        contains(searchElement)).findAny().orElseThrow();
    }

    public boolean checkPrice(WebElement checkElement, String price) {
        return checkElement.getText().contains(price);
    }

    public OrderMyStorePageUpgrade clickToCheckout(WebElement checkout) {
        checkout.click();
        return new OrderMyStorePageUpgrade(driver);
    }

    public List<WebElement> getSearchResults() {
        return searchResults;
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
