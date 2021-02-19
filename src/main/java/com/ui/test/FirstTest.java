package com.ui.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class FirstTest {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");

        WebElement search = driver.findElement(By.xpath("//input[@id='search_query_top']"));
        search.sendKeys("dress");

        WebElement submitButton = driver.findElement(By.xpath("//button[@name='submit_search']"));
        submitButton.click();

        WebElement addToCartSpan = driver.findElement(By.xpath("//a[@data-id-product='1']/child::span[contains(text(),'Add to cart')]"));
        addToCartSpan.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement checkout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-default button button-medium']")));
        checkout.click();

        driver.quit();
    }
}
