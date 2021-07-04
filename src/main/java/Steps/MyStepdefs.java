package Steps;

import Pages.login;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefs {
    WebDriver driver;

    @Given("^User login with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void userLoginWithUsernameAndPassword(String username, String password) {
        login.loginToURL(username, password);
    }

    @Then("^User login successfully and name display$")
    public void userLoginSuccessfullyAndNameDisplay() throws InterruptedException {
        driver.findElement(By.id("UC06_040")).click();
        driver.findElement(By.name("formContent:cuid")).sendKeys("6603642");
        driver.findElement(By.name("buttonPanel:search")).click();
        Thread.sleep(2000);
        WebElement spancuid = driver.findElement(By.xpath("//span[contains(text(),'CUID')]/following-sibling::span//span"));
        String cuid = spancuid.getText();
        Assert.assertEquals(cuid, "6603642");
    }

}
