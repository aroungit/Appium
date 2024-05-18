package learning;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Collections;

public class LearnSwipeWithinWebElement {
    @Test
    public void runCode() throws MalformedURLException, URISyntaxException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("automationName", "UiAutomator2");
        dc.setCapability("noReset", true);
        dc.setCapability("appPackage", "com.android.vending");
        dc.setCapability("appActivity", "com.android.vending.AssetBrowserActivity");
        AppiumDriver driver = new AppiumDriver(new URI("http://127.0.0.1:4723/").toURL(), dc);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement ele = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Suggested for you\"]/following-sibling::android.view.View"));
        int eleStartX = ele.getLocation().getX();
        int eleStartY = ele.getLocation().getY();
        int eleHeight = ele.getSize().getHeight();
        int eleWidth = ele.getSize().getWidth();

        int startX = (int) (eleStartX + (eleWidth * 0.9));
        int startY = (int) (eleStartY + (eleHeight * 0.5));
        int endX = (int) (eleStartX + (eleWidth * 0.1));
        int endY = (int) (eleStartY + (eleHeight * 0.5));

        System.out.println(startX);
        System.out.println(startY);
        System.out.println(endX);
        System.out.println(endY);
        PointerInput input3 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipeLeft = new Sequence(input3, 1);
        swipeLeft.addAction(input3.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipeLeft.addAction(input3.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipeLeft.addAction(input3.createPointerMove(Duration.ofMillis(2000), PointerInput.Origin.viewport(), endX, endY));
        swipeLeft.addAction(input3.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(swipeLeft));
        driver.quit();
    }
}