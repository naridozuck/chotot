package cucumber;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook {
    public WebDriver driver;
    @Before
    public void iniDriver() {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("URL");
    }

    @After
    public void closeDrive() {
        driver.quit();
    }
}
