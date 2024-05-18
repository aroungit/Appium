package pages;

import io.appium.java_client.AppiumDriver;
import wrappers.GenericWrappers;

public class HomePage extends GenericWrappers {
    public HomePage(AppiumDriver driver) {
       this.driver = driver;
        eleIsDisplayed(getWebElement(Locators.XPATH.asString(), "//android.view.View[@text='PARTICIPANT NAME']"));
    }

    public HomePage verifyParticipantNameIsDisplayed() {
        boolean eleDisplayed = eleIsDisplayed(getWebElement(Locators.XPATH.asString(), "//android.view.View[@text='PARTICIPANT NAME']"));
        if (eleDisplayed) {
            System.out.println("Home page is displayed");
        } else {
            System.out.println("Home page is not displayed");
        }
        return this;
    }
}
