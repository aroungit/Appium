package learning;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class LearnFirstCodeUsingWrappers extends GenericWrappers {
    @Test
    public void runCode() {
        launchApp("Android", "", "", "", "", "UiAutomator2",
                "", "", "", "", "", "/apks/leaforg.apk",
                "", "");
        removeApp("com.testleaf.leaforg");
        installApp("/apks/Vodqa.apk");
        verifyAndInstallApp("com.testleaf.leaforg",
                "/apks/leaforg.apk");
        click(getWebElement("id", "android:id/button1"));
        enterValue(getWebElement(Locators.CLASS_NAME.asString(), "android.widget.EditText"), "rajkumar@testleaf.com");
        enterValue(getWebElement(Locators.XPATH.asString(), "(//android.widget.EditText)[2]"), "Leaf@123");
        click(getWebElement(Locators.CLASS_NAME.asString(), "android.widget.Button"));
        takeScreenShot();
        setLandscapeOrientation();
        System.out.println(getOrientation());
        sleep(3000);
        setPortraitOrientation();
        System.out.println(getOrientation());
        sleep(3000);
        closeApp();
    }
}