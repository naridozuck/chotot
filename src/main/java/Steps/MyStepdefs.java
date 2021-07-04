package Steps;

import Pages.login;
import cucumber.api.java.en.*;

public class MyStepdefs {

    @Given("^User login with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void userLoginWithUsernameAndPassword(String username, String password) {
        login.loginToURL(username, password);
    }

    @Then("^User login successful$")
    public void userLoginSuccessfullyAndNameDisplay()  {
        login.verifyUserLoginSuccessful();
    }

}
