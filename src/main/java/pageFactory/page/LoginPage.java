package pageFactory.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailSearchField;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement passSearchField;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    private WebElement SignInButton;

    public MyAccountPage signIn
            (String strEmail,String strPass){
        emailSearchField.sendKeys(strEmail);
        passSearchField.sendKeys(strPass);
        SignInButton.sendKeys(Keys.ENTER);
        return new MyAccountPage(driver);
    }
    public String getTitle() {
        return driver.getTitle();
    }


}
