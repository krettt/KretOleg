package selenide;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    private static final String URL = "http://automationpractice.com/index.php";

    @BeforeMethod
    public void startDriver() { open(URL); }

    @AfterTest(alwaysRun = true)
    public void closeDriver() { closeWebDriver(); }
}
