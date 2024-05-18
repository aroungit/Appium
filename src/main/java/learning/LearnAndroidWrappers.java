package learning;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class LearnAndroidWrappers extends GenericWrappers {
    @Test
    public void runCode() {
        launchAndroidApp("", "", "UiAutomator2", "/apks/leaforg.apk");
        enterValue(getWebElement(Locators.CLASS_NAME.asString(), "android.widget.EditText"), "rajkumar@testleaf.com");
        enterValue(getWebElement(Locators.XPATH.asString(), "(//android.widget.EditText)[2]"), "Leaf@123");
        click(getWebElement(Locators.CLASS_NAME.asString(), "android.widget.Button"));
        switchToAnotherApp("com.amazon.mShop.android.shopping");
        startAnAppUsingActivity("com.the511plus.MultiTouchTester", "com.the511plus.MultiTouchTester.MultiTouchTester");
        swipe("up");
        startAnAppUsingActivity("com.testleaf.leaforg", "com.testleaf.leaforg.MainActivity");
        dataOffInAndroid();
        sleep(5000);
        dataOnInAndroid();
        sleep(5000);
        closeApp();
    }
}