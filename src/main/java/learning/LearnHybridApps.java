package learning;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class LearnHybridApps extends GenericWrappers {
    @Test
    public void runCode() {
        launchAndroidApp("", "", "UiAutomator2", "/apks/leaforg.apk");
        printContext();
        switchContext("WEBVIEW_com.testleaf.leaforg");
        enterValue(getWebElement(Locators.XPATH.asString(), "//input[@placeholder=\"Email\"]"), "rajkumar@testleaf.com");
        enterValue(getWebElement(Locators.XPATH.asString(), "//input[@placeholder=\"Password\"]"), "Leaf@123");
        click(getWebElement(Locators.XPATH.asString(), "//span[text()='Login']"));
        sleep(5000);
        closeApp();
    }
}