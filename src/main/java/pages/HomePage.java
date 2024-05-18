package pages;

import io.cucumber.java.en.Then;
import wrappers.GenericWrappers;

public class HomePage extends GenericWrappers {
    public HomePage() {
        eleIsDisplayed(getWebElement(Locators.XPATH.asString(), "//android.view.View[@text='PARTICIPANT NAME']"));
    }

    @Then("Verify home page is displayed")
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
