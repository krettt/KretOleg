package selenide;

import org.testng.annotations.Test;
import selenide.enums.ProductCategory;
import selenide.pages.MainPage;
import selenide.pages.ProductPage;
import selenide.models.Product;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class CheckProductTest extends BaseTest {

    @Test()
    public void compareProduct() {
        MainPage mainPage = new MainPage().
                searchProduct(ProductCategory.DRESS).selectMainPageProduct();

        ProductPage productPage = mainPage.openProductPage().checkQuantity().checkColor().checkSize();

        List<Product> expectedProduct = mainPage.getListProducts();
        assertThat(expectedProduct).contains(productPage.getActualProduct());
    }
}
