package learning;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Arrays;

public class LearnPinchAndZoom {
    @Test
    public void runCode() throws MalformedURLException, URISyntaxException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("automationName", "UiAutomator2");
        dc.setCapability("noReset", true);
        dc.setCapability("app", System.getProperty("user.dir") + "/apks/MultiTouch Tester_v1.2.apk");
        AppiumDriver driver = new AppiumDriver(new URI("http://127.0.0.1:4723/").toURL(), dc);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        int maxX = driver.manage().window().getSize().getWidth();
        int maxY = driver.manage().window().getSize().getHeight();
//      Pinch
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger 1");
        Sequence finger_1 = new Sequence(finger1, 1);
        finger_1.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), (int) (maxX * 0.25), (int) (maxY * 0.75)));
        finger_1.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        finger_1.addAction(finger1.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), (int) (maxX * 0.5), (int) (maxY * 0.5)));
        finger_1.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger 2");
        Sequence finger_2 = new Sequence(finger2, 1);
        finger_2.addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), (int) (maxX * 0.75), (int) (maxY * 0.25)));
        finger_2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        finger_2.addAction(finger2.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), (int) (maxX * 0.5), (int) (maxY * 0.5)));
        finger_2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(finger_1, finger_2));

//        Pinch
        PointerInput finger3 = new PointerInput(PointerInput.Kind.TOUCH, "finger 3");
        Sequence finger_3 = new Sequence(finger3, 1);
        finger_3.addAction(finger3.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), (int) (maxX * 0.5), (int) (maxY * 0.5)));
        finger_3.addAction(finger3.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        finger_3.addAction(finger3.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), (int) (maxX * 0.25), (int) (maxY * 0.75)));
        finger_3.addAction(finger3.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        PointerInput finger4 = new PointerInput(PointerInput.Kind.TOUCH, "finger 4");
        Sequence finger_4 = new Sequence(finger4, 1);
        finger_4.addAction(finger4.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), (int) (maxX * 0.5), (int) (maxY * 0.5)));
        finger_4.addAction(finger4.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        finger_4.addAction(finger4.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), (int) (maxX * 0.75), (int) (maxY * 0.25)));
        finger_4.addAction(finger4.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(finger_3, finger_4));
        driver.quit();
    }
}