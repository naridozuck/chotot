package cucumber;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook {
    WebDriver driver;
    @Before
    public void iniDriver() {
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("URL");
    }

    @After
    public void closedrive() {
        driver.quit();
    }
}
