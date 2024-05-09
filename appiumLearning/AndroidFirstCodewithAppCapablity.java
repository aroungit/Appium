package appiumLearning;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

public class AndroidFirstCodewithAppCapablity {
	
	@Test
	public void executeCode() throws MalformedURLException, URISyntaxException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "android");
		dc.setCapability("automationName", "uiAutomator2");
		dc.setCapability("app", System.getProperty("user.dir")+ File.separator+"apks"+File.separator+"leaforg.apk");
		AppiumDriver driver = new AppiumDriver(new URI("http://127.0.0.1:4723/").toURL(), dc);
		driver.quit();
		
	}

}
