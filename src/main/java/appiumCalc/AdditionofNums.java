package appiumCalc;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class AdditionofNums {

	@Test
	public void calciAddMul() throws MalformedURLException, URISyntaxException {

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "android");
		dc.setCapability("automationName", "uiAutomator2");
		dc.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		dc.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");

		AppiumDriver driver = new AppiumDriver(new URI("http://127.0.0.1:4723/").toURL(), dc);

		driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_09")).click();
		driver.findElement(AppiumBy.accessibilityId("Plus")).click();
		driver.findElement(AppiumBy.xpath("(//android.widget.Button)[6]")).click();
		driver.findElement(AppiumBy.accessibilityId("Equal")).click();
		String Addition = driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_edt_formula"))
				.getText();
		driver.findElement(AppiumBy.accessibilityId("Clear")).click();
		System.out.println(Addition);

		driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_handle_btn_history")).click();
		driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_history_item_result")).click();
		driver.findElement(AppiumBy.accessibilityId("Keypad Button")).click();
		driver.findElement(AppiumBy.accessibilityId("Multiplication")).click();
		driver.findElement(AppiumBy.accessibilityId("1")).click();
		driver.findElement(AppiumBy.accessibilityId("5")).click();
		driver.findElement(AppiumBy.accessibilityId("Equal")).click();
		String Multiplication = driver
				.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).getText();
		System.out.println(Multiplication);
		driver.quit();

	}

}
