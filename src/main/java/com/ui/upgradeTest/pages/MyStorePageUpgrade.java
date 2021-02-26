package com.ui.upgradeTest.pages;


import com.ui.testwithPOM.SearchMyStorePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStorePageUpgrade {
    private WebDriver driver;

    public MyStorePageUpgrade(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='search_query_top']")
    private WebElement searchField;

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    private WebElement signInButton;

    public SearchMyStorePageUpgrade inputSearchField(String searchWord,WebElement searchField) {
        searchField.sendKeys(searchWord);
        searchField.sendKeys(Keys.ENTER);
        return new SearchMyStorePageUpgrade(driver);
    }
    public LoginPage clickSignIn(WebElement element){
        element.click();
        return new LoginPage(driver);
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public String getTitle() {
        return driver.getTitle();
    }

}
