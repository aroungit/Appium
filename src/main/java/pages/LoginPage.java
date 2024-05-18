package pages;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import wrappers.GenericWrappers;

public class LoginPage extends GenericWrappers {
    public LoginPage() {
        eleIsDisplayed(getWebElement(Locators.CLASS_NAME.asString(), "android.widget.EditText"));
    }

    @When("username is entered as {string}")
    public LoginPage enterUserName(String userName) {
//        driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys(userName);
        enterValue(getWebElement(Locators.CLASS_NAME.asString(), "android.widget.EditText"), userName);
        return this;
    }

    @When("password is entered as {string}")
    public LoginPage enterPassword(String password) {
        enterValue(getWebElement(Locators.XPATH.asString(), "//android.widget.EditText[@hint='Password']"), password);
        return this;
    }

    @When("login button is clicked")
    public HomePage clickLogin() {
        click(getWebElement(Locators.CLASS_NAME.asString(), "android.widget.Button"));
        return new HomePage();
    }

    @When("login button is clicked for failure")
    public LoginPage clickLoginForFailure() {
        click(getWebElement(Locators.CLASS_NAME.asString(), "android.widget.Button"));
        return this;
    }

    @Then("Verify login page is displayed")
    public LoginPage verifyLoginPageIsDisplayed() {
        eleIsDisplayed(getWebElement(Locators.CLASS_NAME.asString(), "android.widget.EditText"));
        return this;
    }
}
