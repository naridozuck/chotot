package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static sun.management.Agent.error;

public class login {
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal();
    protected WebElement currentElement;

    public static void loginToURL(String username, String password) throws Exception {
        openBrowser("VDVDV");
        login(username, password);
    }

    public static void openBrowser(String url) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(2000);
    }
    public void login(String userName, String passWord) throws Exception {
        click("login_btn_");
        typeText("user_name",userName);
        typeText("pwd",passWord);
        click("login_btn_2");
        Thread.sleep(2000);
    }
    public WebElement findElement(String objPath) throws Exception {
        this.currentElement = null;
        this.currentElement = driver.get().findElement(By.xpath(objPath));
        if (this.currentElement == null) {
            error("Cannot find " + objPath);
            throw new Exception("Cannot find " + objPath);
        } else {
            return this.currentElement;
        }
    }
    public void typeText(String objPath, CharSequence... text) throws Exception {
        this.findElement(objPath);
        this.currentElement.clear();
        this.currentElement.sendKeys(text);
    }
    public void click(String objPath) throws Exception {
        this.findElement(objPath);
        this.currentElement.click();
    }
}
