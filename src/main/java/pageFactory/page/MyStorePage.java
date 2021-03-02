package pageFactory.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStorePage {
    private WebDriver driver;

    public MyStorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='search_query_top']")
    private WebElement searchField;

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    private WebElement signInButton;

    public SearchMyStorePage inputSearchField(String searchWord) {
        searchField.sendKeys(searchWord);
        searchField.sendKeys(Keys.ENTER);
        return new SearchMyStorePage(driver);
    }

    public LoginPage clickSignIn() {
        signInButton.click();
        return new LoginPage(driver);
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
