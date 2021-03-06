package selenide.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ProductCategory {
    WOMEN("Women"),
    DRESS("Dresses"),
    T_SHIRTS("T-shirts");

    @Getter
    private String name;

}
