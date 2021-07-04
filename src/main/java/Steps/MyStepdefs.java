package Steps;

import cucumber.api.java.en.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefs {
    WebDriver driver;
    @Given("^User log in to system$")
    public void userLogInToSystem() throws InterruptedException {
        driver.findElement(By.xpath("login_btn_")).click();
        driver.findElement(By.xpath("user_name")).sendKeys("u_username");
        driver.findElement(By.xpath("pwd")).sendKeys("p_password");
        driver.findElement(By.xpath("login_btn_2")).click();
        Thread.sleep(2000);
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
