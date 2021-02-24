package com.ui.testwithPOM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStorePage {
    WebDriver driver;

    public MyStorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='search_query_top']")
    private WebElement searchField;


    public SearchMyStorePage inputSearchField(String searchWord){
        searchField.sendKeys(searchWord);
        searchField.sendKeys(Keys.ENTER);
        return new SearchMyStorePage(driver);
    }


}
