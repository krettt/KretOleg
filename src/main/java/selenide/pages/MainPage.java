package selenide.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.Keys;
import selenide.enums.ProductCategory;
import selenide.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    @Getter
    public List<Product> listProducts = new ArrayList<>();

    @Step
    public MainPage searchProduct(ProductCategory product) {
        SelenideElement searchField = $x("//input[@id='search_query_top']");
        searchField.sendKeys(product.getName());
        searchField.sendKeys(Keys.ENTER);
        return this;
    }

    @Step
    public MainPage selectMainPageProduct() {
        ElementsCollection containers = $$x("//div[@class='product-container']");
        containers.forEach(
                product ->
                        listProducts.add(Product.buildProduct(
                                product.$x("descendant::a[@class='product-name']"),
                                product.$x("descendant::span[@itemprop='price']"))));
        return this;
    }

    @Step
    public ProductPage openProductPage() {
        Product randomProduct = listProducts.get(new Random().nextInt(6) + 1);
        $x("//span[contains(text(),'"+randomProduct.getPrice()+"')]" +
                "/ancestor::div[@class='product-container']" +
                "/descendant::a[contains(text(),'"+randomProduct.getName()+"')]").click();
        return new ProductPage();
    }
}
