package selenide.models;

import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private String name;
    private String price;

    public static Product buildProduct(SelenideElement nameEle,SelenideElement priceEle){
        return new Product(nameEle.text(),priceEle.getOwnText().trim());
    }
}
