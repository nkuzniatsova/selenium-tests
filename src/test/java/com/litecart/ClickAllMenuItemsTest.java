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

public class ClickAllMenuItemsTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        //setProperty("webdriver.chrome.driver", "C:\\Tools\\SeleniumWD\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    // Login Litecart aplication and click all menu and submenu items, verify all pages have a title
    @Test
    public void clickAllMenuItems() throws InterruptedException {
        driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        //System.out.println(driver.findElements(By.xpath("//*[@id='app-']/a")).size());
        //System.out.println(driver.findElements(By.cssSelector("#box-apps-menu.list-vertical a")).size());
        //if (driver.findElements(By.cssSelector("#box-apps-menu.list-vertical a")).size() > 0) {

        if (driver.getCurrentUrl().equals("http://localhost/litecart/admin/") && driver.findElements(By.cssSelector("#box-apps-menu.list-vertical a")).size() > 0) {
            List<WebElement> menuItems = driver.findElements(By.xpath("//*[@id='app-']/a"));
            for (int i=0; i < menuItems.size(); i++) {
                driver.findElements(By.xpath("//*[@id='app-']/a")).get(i).click();
                //Verify if the page has a header - element with a tag h1
                if (driver.findElements(By.tagName("h1")).size() == 0) {
                    String pageName = driver.findElements(By.xpath("//*[@id='app-']/a")).get(i).getText();
                    System.out.println("Page " + pageName + " has no title!");
                }
                //Verify, if there are submenu items click on each submenu items
                int subMenuSize = driver.findElements(By.cssSelector(".docs a")).size();
                if (subMenuSize > 0) {
                    for (int n = 0; n < subMenuSize; n++) {
                        driver.findElements(By.cssSelector(".docs a")).get(n).click();
                        //Verify if the page has a header - element with a tag h1
                        if (driver.findElements(By.tagName("h1")).size() == 0) {
                            String pageName = driver.findElements(By.xpath("//*[@id='app-']/a")).get(i).getText();
                            System.out.println("Page " + pageName + " has no title!");
                        }
                    }
                }
            }

        } else {
            System.out.println("There are no menu items found!");
        }

    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
