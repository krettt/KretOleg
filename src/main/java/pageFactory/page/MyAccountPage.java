package pageFactory.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'Oleh Kret')]")
    private WebElement userInfoButton;

    public String getTitle() {
        return driver.getTitle();
    }

    public String getUserName(){
       return userInfoButton.getText();
    }
}
