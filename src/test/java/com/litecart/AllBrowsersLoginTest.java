package com.litecart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

/**
 * Run Login test in different browsers: Chrome, Firefox, Internet Explorer
 */
public class AllBrowsersLoginTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Test
    public void loginLitecartChrome() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void loginLitecartIE() {
        driver = new InternetExplorerDriver();
        wait = new WebDriverWait(driver, 1);
        driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void loginLitecartEdge() {
        driver = new EdgeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        //driver.findElement(By.name("login")).click();
    }

    //Run test with Firefox ESR old schema
    @Test
    public void loginLitecartFirefox() {
        FirefoxOptions options = new FirefoxOptions().setLegacy(true);
        driver = new FirefoxDriver(options);
        wait = new WebDriverWait(driver, 1);
        driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    //Run test with Firefox Nightly new schema
    @Test
    public void loginLitecartFirefoxNightly() {
        File firefoxNightly = new File("C:\\Program Files\\Nightly\\firefox.exe");
        FirefoxOptions options = new FirefoxOptions().setLegacy(false).setBinary(new FirefoxBinary(firefoxNightly));

        driver = new FirefoxDriver(options);
        //driver = new FirefoxDriver(new FirefoxBinary(new File("C:\\Program Files\\Nightly\\firefox.exe")),
        //        new FirefoxProfile(), caps);
        wait = new WebDriverWait(driver, 1);
        driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
