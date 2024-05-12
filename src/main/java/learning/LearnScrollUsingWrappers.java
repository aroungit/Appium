package learning;

import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class LearnScrollUsingWrappers extends GenericWrappers {
    @Test
    public void runCode() {
        launchApp("Android", "my device", "",
                "", "", "UiAutomator2",
                "", "", "", "",
                "", "/apks/MultiTouch Tester_v1.2.apk", "", "");
        swipe("up");
        swipe("down");
        swipe("left");
        swipe("right");
        pinchInApp();
        zoomInApp();
        Dimension size = driver.manage().window().getSize();
        doubleTap((int) (size.getWidth() * 0.5), (int) (size.getHeight() * 0.5));
        longPress((int) (size.getWidth() * 0.5), (int) (size.getHeight() * 0.5));
        sleep(1000);
//        stopRunningApp("com.the511plus.MultiTouchTester");
        closeApp();
    }
}