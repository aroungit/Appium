package pages;

import io.appium.java_client.AppiumDriver;
import wrappers.GenericWrappers;

public class LoginPage extends GenericWrappers {
    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        eleIsDisplayed(getWebElement(Locators.CLASS_NAME.asString(), "android.widget.EditText"));
    }

    public LoginPage enterUserName(String userName) {
//        driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys(userName);
        enterValue(getWebElement(Locators.CLASS_NAME.asString(), "android.widget.EditText"), userName);
        return this;
    }

    public LoginPage enterPassword(String password) {
        enterValue(getWebElement(Locators.XPATH.asString(), "//android.widget.EditText[@hint='Password']"), password);
        return this;
    }

    public HomePage clickLogin() {
        click(getWebElement(Locators.CLASS_NAME.asString(), "android.widget.Button"));
        return new HomePage(driver);
    }

    public LoginPage clickLoginForFailure() {
        click(getWebElement(Locators.CLASS_NAME.asString(), "android.widget.Button"));
        return this;
    }
}
