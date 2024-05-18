package testcases;

import pages.LoginPage;
import wrappers.GenericWrappers;

public class TC001 {
    public static void main(String[] args) {
        GenericWrappers gw = new GenericWrappers();
        gw.launchAndroidApp("", "", "UiAutomator2", "/apks/leaforg.apk");
        new LoginPage(gw.driver)
                .enterUserName("rajkumar@testleaf.com")
                .enterPassword("Leaf@123")
                .clickLogin()
                .verifyParticipantNameIsDisplayed();
    }
}
