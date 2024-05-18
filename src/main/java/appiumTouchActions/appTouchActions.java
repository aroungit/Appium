package appiumTouchActions;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Interactive;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import wrappers.GenericWrappers;

public class appTouchActions extends GenericWrappers {
	
	static AppiumDriver driver;


	@Test
	public void AmazonAppLaunch() throws MalformedURLException, URISyntaxException, Exception {

		// setting up Desired Capabilities
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "android");
		dc.setCapability("automationName", "uiAutomator2");
		//dc.setCapability("app",System.getProperty("user.dir") + File.separator + "apks" + File.separator + "Amazon.apk");
		// dc.setCapability("appPackage", "com.testleaf.leaforg");
		dc.setCapability("appPackage", "com.amazon.mShop.android.shopping");
		dc.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
		// dc.setCapability("appActivity", "com.testleaf.leaforg.MainActivity");

		// instantiating the Appium Driver
		driver = new AppiumDriver(new URI("http://127.0.0.1:4723/").toURL(), dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(AppiumBy.id("com.amazon.mShop.android.shopping:id/skip_sign_in_button")).click();
       
		scrollup();
		scrollup();
		scrollup();
		
		// login

	
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"See all deals\"]")).click();
		
		scrollup();
		scrollup();
		
		
		driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"Deal: Branded Suitcase, Backpacks and Duffles - American Tourister, Safari, Skybags, etc.; \"]")).click();
		Thread.sleep(5000);
		driver.navigate().back();
		
		/*
		 * driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys(
		 * "rajkumar@testleaf.com");
		 * driver.findElement(AppiumBy.xpath("(//android.widget.EditText)[2]")).sendKeys
		 * ("Leaf@123");
		 * driver.findElement(AppiumBy.className("android.widget.Button")).click();
		 */
		System.out.println("the element is selected");
		driver.quit();
	}
	
	
	public static void scrollup() {
		 int maxX = driver.manage().window().getSize().getWidth();
	     int maxY = driver.manage().window().getSize().getHeight();
	     int startX = 0, startY = 0, endX = 0, endY = 0;
	      //Swipe towards up
	        startX = (int) (maxX * 0.5);
	        startY = (int) (maxY * 0.85);
	        endX = (int) (maxX * 0.5);
	        endY = (int) (maxY * 0.16);
	        PointerInput input1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
	        Sequence swipeUp = new Sequence(input1, 1);
	        swipeUp.addAction(input1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
	        swipeUp.addAction(input1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	        swipeUp.addAction(input1.createPointerMove(Duration.ofMillis(2000), PointerInput.Origin.viewport(), endX, endY));
	        swipeUp.addAction(input1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	        driver.perform(Collections.singletonList(swipeUp));
		
	}
	
	


	}

