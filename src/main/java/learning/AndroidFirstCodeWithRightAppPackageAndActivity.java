package learning;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class AndroidFirstCodeWithRightAppPackageAndActivity {
    @Test
    public void runCode() throws URISyntaxException, InterruptedException, MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("automationName", "UiAutomator2");
//        dc.setCapability("app", System.getProperty("user.dir") + File.separator + "apks" + File.separator + "amazon.apk");
        dc.setCapability("appPackage", "com.amazon.mShop.android.shopping");
        dc.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
        AppiumDriver driver = new AppiumDriver(new URI("http://127.0.0.1:4723/").toURL(), dc);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Thread.sleep(5000);
        driver.quit();
    }
}