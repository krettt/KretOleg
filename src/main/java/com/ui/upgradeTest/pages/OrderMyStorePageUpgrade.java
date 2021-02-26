package com.ui.upgradeTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderMyStorePageUpgrade {
    private WebDriver driver;

    public OrderMyStorePageUpgrade(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tr[@id='product_2_7_0_0']")
    WebElement productInCart;

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean checkProduct(WebElement checkElement, String name) {
        return checkElement.getText().contains(name);
    }

    public WebElement getProductInCart() {
        return productInCart;
    }
}
