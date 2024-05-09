package appiumSMS;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

public class ReadDelSMS {
	
	static AppiumDriver driver;
	
	@Test
	public static void ReadSMS() throws Exception, URISyntaxException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "android");
		dc.setCapability("automationName", "uiAutomator2");
		dc.setCapability("appPackage", "com.samsung.android.messaging");
		dc.setCapability("appActivity", "com.android.mms.ui.ConversationComposer");
		
		driver = new AppiumDriver(new URI("http://127.0.0.1:4723/").toURL(), dc);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(AppiumBy.accessibilityId("Compose new message")).click();
		driver.findElement(AppiumBy.id("com.samsung.android.messaging:id/recipients_editor_to")).sendKeys("+91-9444047658");
		driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@resource-id=\"com.samsung.android.messaging:id/bubble_list_view\"]/android.widget.LinearLayout")).click();
		driver.findElement(AppiumBy.id("com.samsung.android.messaging:id/message_edit_text")).sendKeys("AppiumTest1");
		driver.findElement(AppiumBy.accessibilityId("SIM card 1 Send")).click();
		
		Thread.sleep(500);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(AppiumBy.id("com.samsung.android.messaging:id/composer_up")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(AppiumBy.xpath("(//android.widget.LinearLayout[@resource-id=\"com.samsung.android.messaging:id/card_view_list_item\"])[1]/android.widget.LinearLayout")).click();
		//WebElement lp = driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@resource-id=\"com.samsung.android.messaging:id/content_text_view\"])[11]"));
		WebElement lp = driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@text ='AppiumTest1'])[11]"));
		longpress(lp);
		
		Thread.sleep(10);
		
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Delete\"]")).click();
		driver.findElement(AppiumBy.id("com.samsung.android.messaging:id/delete")).click();
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//		action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(myElement)).withDuration(Duration.ofMillis(500))).release().perform();
//		
//		new Actions(driver).
//		new Actions(driver).clickAndHold(ele).perform();
		driver.quit();
		
		
	}


	public static void longpress(WebElement ele) {
		
		Point location = ele.getLocation();
		
		PointerInput input = new PointerInput(PointerInput.Kind.TOUCH,"finger");
		Sequence sequence = new Sequence(input, 0);
		sequence.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), location.x,location.y));
		sequence.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		sequence.addAction(input.createPointerMove(Duration.ofSeconds(5), PointerInput.Origin.viewport(), location.x, location.y));
		sequence.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(ImmutableList.of(sequence));
		
	}

}
