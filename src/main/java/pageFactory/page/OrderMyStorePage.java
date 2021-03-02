package pageFactory.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderMyStorePage {
    private WebDriver driver;

    public OrderMyStorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tr[@id='product_2_7_0_0']")
    WebElement productInCart;

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean isProductInCart( String name) {
        return productInCart.getText().contains(name);
    }
}
