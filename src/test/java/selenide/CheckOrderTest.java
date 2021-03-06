package selenide;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;
import selenide.enums.ProductCategory;
import selenide.models.Product;
import selenide.pages.MainPage;
import selenide.pages.ProductPage;
import selenide.pages.ShoppingCartPage;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckOrderTest extends BaseTest {
    private static final String ORDER_PAGE = "Order - My Store";

    @Test(description = "Compare selected product with product in shoping cart")
    public void checkProductInShoppingCart() {
        MainPage mainPage = new MainPage().selectMainPageProduct().
                searchProduct(ProductCategory.DRESS);
        ProductPage productPage = mainPage.openProductPage();
        ShoppingCartPage shoppingCartPage = productPage.addToCart().clickCheckout();
        assertThat(Selenide.title()).isEqualTo(ORDER_PAGE);

        List<Product> shoppingCartProducts = shoppingCartPage.
                selectShoppingCartProduct().getShoppingCartProduct();
        assertThat(productPage.getActualProducts()).containsAll(shoppingCartProducts);
    }
}
