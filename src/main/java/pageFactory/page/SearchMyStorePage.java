package pageFactory.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.NoSuchElementException;

public class SearchMyStorePage {
    private WebDriver driver;
    private WebElement blouse;

    public SearchMyStorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[contains(@class,'ajax_block_product')]")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//a[@data-id-product='2']/child::span[contains(text(),'Add to cart')]")
    private WebElement blouseAddToCart;

    @FindBy(xpath = "//span[contains(.,'Proceed to checkout')]")
    private WebElement checkout;

    public String getTitle() {
        return driver.getTitle();
    }

    public WebElement findElementFromList(String searchElement) {
        return searchResults.stream().
                filter(element -> element.getText().
                        contains(searchElement)).findAny().
                orElseThrow(() -> new NoSuchElementException(
                        "WebElement that contains text "
                        + searchElement + " is not found"));
    }

    public boolean checkPrice(WebElement checkElement, String price) {
        return checkElement.getText().contains(price);
    }

    public OrderMyStorePage clickToCheckout() {
        checkout.click();
        return new OrderMyStorePage(driver);
    }

    public void getBlouseAddToCart() {
        blouseAddToCart.click();
    }
}
