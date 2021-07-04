package cucumber;

import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook {
    WebDriver driver;
    @Before
    public void iniDriver() {
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
        WebDriver driver = (WebDriver) new ChromeDriver();
    }

    @After
    public void closedrive() {
        driver.quit();
    }
}
