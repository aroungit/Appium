package learning;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class LearnSwitchBetweenApps extends GenericWrappers {
    @Test
    public void runCode() {
        launchApp("Android", "", "", "", "", "UiAutomator2",
                "", "", "", "", "", "/apks/leaforg.apk",
                "", "");
        enterValue(getWebElement(Locators.CLASS_NAME.asString(), "android.widget.EditText"), "rajkumar@testleaf.com");
        enterValue(getWebElement(Locators.XPATH.asString(), "(//android.widget.EditText)[2]"), "Leaf@123");
        click(getWebElement(Locators.CLASS_NAME.asString(), "android.widget.Button"));
        switchToAnotherApp("com.the511plus.MultiTouchTester");
        swipe("up");
        stopRunningApp("com.testleaf.leaforg");
        switchToAnotherApp("com.testleaf.leaforg");
        closeApp();
    }
}