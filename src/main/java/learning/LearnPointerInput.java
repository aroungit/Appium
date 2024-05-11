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
import java.util.Collections;

public class LearnPointerInput {
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
        int startX = 0, startY = 0, endX = 0, endY = 0;
        //Swipe towards up
        startX = (int) (maxX * 0.5);
        startY = (int) (maxY * 0.8);
        endX = (int) (maxX * 0.5);
        endY = (int) (maxY * 0.2);
        PointerInput input1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipeUp = new Sequence(input1, 1);
        swipeUp.addAction(input1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipeUp.addAction(input1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipeUp.addAction(input1.createPointerMove(Duration.ofMillis(2000), PointerInput.Origin.viewport(), endX, endY));
        swipeUp.addAction(input1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(swipeUp));

        //Swipe towards down
        startX = (int) (maxX * 0.5);
        startY = (int) (maxY * 0.2);
        endX = (int) (maxX * 0.5);
        endY = (int) (maxY * 0.8);
        PointerInput input2 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipeDown = new Sequence(input2, 1);
        swipeDown.addAction(input2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipeDown.addAction(input2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipeDown.addAction(input2.createPointerMove(Duration.ofMillis(2000), PointerInput.Origin.viewport(), endX, endY));
        swipeDown.addAction(input2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(swipeDown));

        //Swipe towards left
        startX = (int) (maxX * 0.8);
        startY = (int) (maxY * 0.5);
        endX = (int) (maxX * 0.2);
        endY = (int) (maxY * 0.5);
        PointerInput input3 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipeLeft = new Sequence(input3, 1);
        swipeLeft.addAction(input3.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipeLeft.addAction(input3.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipeLeft.addAction(input3.createPointerMove(Duration.ofMillis(2000), PointerInput.Origin.viewport(), endX, endY));
        swipeLeft.addAction(input3.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(swipeLeft));

        //Swipe towards right
        startX = (int) (maxX * 0.2);
        startY = (int) (maxY * 0.5);
        endX = (int) (maxX * 0.8);
        endY = (int) (maxY * 0.5);
        PointerInput input4 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipeRight = new Sequence(input4, 1);
        swipeRight.addAction(input4.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipeRight.addAction(input4.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipeRight.addAction(input4.createPointerMove(Duration.ofMillis(2000), PointerInput.Origin.viewport(), endX, endY));
        swipeRight.addAction(input4.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(swipeRight));

        driver.quit();
    }
}