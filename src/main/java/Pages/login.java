package Pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static sun.management.Agent.error;

public class login {
    protected ThreadLocal<WebDriver> driver = new ThreadLocal();
    protected WebElement currentElement;

    public void loginToURL(String username, String password) throws Exception {
        openBrowser("${chotot.url}");
        login(username, password);
    }

    public static void openBrowser(String url) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(2000);
    }

    public void verifyUserLoginSuccessful() throws Exception {
        verifyElementExist("user login successful","account" );
    }

    public void verifyElementExist(String mes, String xpath) throws Exception {
        Assert.assertTrue(mes + " is not exist.\n Xpath: " + xpath, isElementExist(xpath));
    }

    public boolean isElementExist(String objPath) throws Exception {
        Boolean r = true;
        String myEle = String.valueOf(this.findElement(objPath));
        if (myEle == null) {
            r = false;
        }
        return r;
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
            throw new Exception("Cannot find ");
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
