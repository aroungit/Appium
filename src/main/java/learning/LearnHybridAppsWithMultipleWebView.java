package learning;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class LearnHybridAppsWithMultipleWebView extends GenericWrappers {

    @Test
    public void runCode() {
        launchAndroidApp("io.cloudgrey.the_app", "io.cloudgrey.the_app.MainActivity", "UiAutomator2",
                "/apks/TheApp-v1.10.0.apk");
        click(getWebElement(Locators.XPATH.asString(), "//android.widget.TextView[@text=\"Dual Webview Demo\"]"));
        printContext();
        switchContext("WEBVIEW_io.cloudgrey.the_app");
        switchToLastWindow();
        System.out.println(getText(getWebElement(Locators.TAG_NAME.asString(), "h2")));
        switchToFirstWindow();
        System.out.println(getText(getWebElement(Locators.TAG_NAME.asString(), "h2")));
    }
}