import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.lang.System.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class FirstTestSelenium {

    @Test
    public void myFirstTest() {
        //WebDriver driver = new RemoteWebDriver("http://localhost:9515", DesiredCapabilities.chrome());
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\SeleniumWD\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("btnK")).click();
        wait.until(titleIs("webdriver - Google zoeken"));
        driver.quit();
        driver = null;
    }
}
