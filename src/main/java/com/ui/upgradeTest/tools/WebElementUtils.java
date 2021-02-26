package com.ui.upgradeTest.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebElementUtils {
    private WebDriver driver;

    public WebElementUtils(WebDriver driver) {
        this.driver = driver;

    }

    public void doAction(WebElement element) {
        Actions builder = new Actions(driver);
        builder.moveToElement(element).build().perform();
    }

    public void doImplicitWait() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void doExplicitWait(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


}
