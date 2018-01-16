package com.litecart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class VerifyProductSticker {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        //setProperty("webdriver.chrome.driver", "C:\\Tools\\SeleniumWD\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void verifySticker() {
        driver.navigate().to("http://localhost/litecart/");

        //List<WebElement> productsCollection = driver.findElements(By.xpath("//*[contains(@class,'box')]//a[contains(@class,'link')]"));
        List<WebElement> productsCollection = driver.findElements(By.className("product"));
        int numberProducts = productsCollection.size();
        //System.out.println(numberProducts);

        if (numberProducts > 0) {

            for (int i = 0; i < numberProducts; i++) {
                int numberOfStickers = productsCollection.get(i).findElements(By.xpath(".//*[contains(@class, 'sticker')]")).size();
                if (numberOfStickers != 1) {
                    System.out.println("The following product has incorrect number of stickers other then 1: " + productsCollection.get(i).getText() + " number of stickers: " + numberOfStickers);
                }
            }
        }
    }


    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}


