package selenide.pages;

import io.qameta.allure.Step;
import lombok.Getter;
import selenide.models.Product;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;

public class ShoppingCartPage {

    @Getter
    List<Product> shoppingCartProduct = new ArrayList<>();

    @Step
    public ShoppingCartPage selectShoppingCartProduct() {
        $$x("//tr[contains(@class,'cart_item')]").forEach(product ->
             shoppingCartProduct.add(Product.buildProduct(
                     product.$x("descendant::p[@class='product-name']/a"),
                     product.$x("descendant::span/span[@class='price' and contains(text(),'$')]")))
        );
        return this;
    }

}
