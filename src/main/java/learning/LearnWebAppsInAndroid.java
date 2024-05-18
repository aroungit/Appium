package learning;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class LearnWebAppsInAndroid extends GenericWrappers {
    @Test
    public void runCode() {
        launchBrowser("Android", "Chrome",
                "", "https://www.google.com", "",
                "", "", "", "");
        enterValue(getWebElement(Locators.NAME.asString(), "q"), "Lokesh Kumar");
        pressEnter();
        takeScreenShot();
    }
}