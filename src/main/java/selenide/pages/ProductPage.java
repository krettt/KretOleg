package selenide.pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import lombok.Getter;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.support.ui.Select;
import selenide.models.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class ProductPage {

    @Getter
    Product actualProduct = Product.buildProduct(
            $x("//h1[@itemprop='name']"),
            $x("//span[@id='our_price_display']"));

    @Getter
    List<Product>actualProducts =new ArrayList<>();

    @Step
    public ProductPage checkQuantity() {
        String quantity = Integer.toString(new Random().nextInt(100));
        $x("//input[@id='quantity_wanted']").sendKeys(quantity);
        $x("//i[@class='icon-minus']").click();
        $x("//i[@class='icon-plus']").doubleClick();
        return this;
    }

    @Step
    public ProductPage checkSize() {
        Select mySize = new Select($x("//select[@id='group_1']"));
        mySize.selectByVisibleText("S");
        mySize.selectByVisibleText("L");
        mySize.selectByVisibleText("M");
        return this;
    }

    @Step
    public ProductPage checkColor() {
        ElementsCollection colors = $$x("//ul[@id='color_to_pick_list']/descendant::a");
        colors.get(RandomUtils.nextInt(0,colors.size()-1)).click();
        return this;
    }

    @Step
    public ProductPage addToCart() {
        $x("//span[contains(text(),'Add to cart')]").click();
        actualProducts.add(actualProduct);
        return this;
    }

    @Step
    public ShoppingCartPage clickCheckout() {
        $x("//span[contains(text(),'Proceed to checkout')]").click();
        return new ShoppingCartPage();
    }
}
