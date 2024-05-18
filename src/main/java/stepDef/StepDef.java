package stepDef;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URI;
import java.time.Duration;

public class StepDef {
    public AppiumDriver driver;
    boolean useExistingApp = false;
    public boolean launchApp(String platformName, String deviceName, String udid, String appPackage, String appActivity,
                            String automationName, String chromeDriverPort, String systemPort, String xcodeOrgId, String xcodeSigningId,
                            String bundleId, String app, String mjpegServerPort, String wdaLocalPort) {
        try {
            DesiredCapabilities dc = new DesiredCapabilities();
            // To pass the Unique Device IDentifier
            if (!udid.equals(""))
                dc.setCapability("udid", udid);
            // To pass the absolute path of the application
            if (!app.equals(""))
                dc.setCapability("app", System.getProperty("user.dir") + app);
            // To set the device name
            if (!deviceName.equals(""))
                dc.setCapability("deviceName", deviceName);
            // Android
            if (!appPackage.equals(""))
                dc.setCapability("appPackage", appPackage);
            if (!appActivity.equals(""))
                dc.setCapability("appActivity", appActivity);
            // For hybrid app parallel testing
            if (!chromeDriverPort.equals(""))
                dc.setCapability("chromedriverPort", chromeDriverPort);
            // For native app parallel testing
            if (!mjpegServerPort.equals(""))
                dc.setCapability("mjpegServerPort", mjpegServerPort);
            // For hybrid/native app parallel testing
            if (!systemPort.equals(""))
                dc.setCapability("systemPort", systemPort);
            // iOS
            // For hybrid/native app parallel testing
            if (!wdaLocalPort.equals(""))
                dc.setCapability("wdaLocalPort", wdaLocalPort);
            // To pass the Xcode Org ID if the application and WDA are built with different developer certificates
            if (!xcodeOrgId.equals(""))
                dc.setCapability("xcodeOrgId", xcodeOrgId);
            // To pass the Xcode Signing ID if the application and WDA are built with different developer certificates
            if (!xcodeSigningId.equals(""))
                dc.setCapability("xcodeSigningId", xcodeSigningId);
            if (!bundleId.equals(""))
                dc.setCapability("bundleId", bundleId);
            // Mandatory desired capabilities
            // To pass the VDM
            dc.setCapability("automationName", automationName);
            // Comment the below line based on need
            if (useExistingApp) {
                // Below script helps to not clear the cache and data of the app
                dc.setCapability("noReset", true);
                // Below script helps to re-launch the app everytime the session starts
                dc.setCapability("forceAppLaunch", true);
                // Below script helps to close the app when driver.quit() is called
                dc.setCapability("shouldTerminateApp", true);
            }
            if (platformName.equalsIgnoreCase("Android")) {
                // Comment the below line based on need
                dc.setCapability("autoGrantPermissions", true);
                driver = new AndroidDriver(new URI("http://0.0.0.0:4723").toURL(), dc);
            } else if (platformName.equalsIgnoreCase("iOS")) {
                // Comment the below line based on need
                dc.setCapability("autoAcceptAlerts", true);
                driver = new IOSDriver(new URI("http://0.0.0.0:4723").toURL(), dc);
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    @Given("application is launched")
    public void applicationIsLaunched() {
        launchApp("Android", "", "", "", "", "UiAutomator2", "", "",
                "", "", "", "/apks/leaforg.apk", "", "");
    }
    @When("username is entered as {string}")
    public void usernameIsEnteredAs(String string) {
        driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys(string);
    }
    @When("password is entered as {string}")
    public void passwordIsEnteredAs(String string) {
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@hint='Password']")).sendKeys(string);
    }
    @When("login button is clicked")
    public void loginButtonIsClicked() {
        driver.findElement(AppiumBy.className("android.widget.Button")).click();
    }
    @Then("Verify home page is displayed")
    public void verifyHomePageIsDisplayed() {
        driver.findElement(AppiumBy.xpath("//android.view.View[@text='PARTICIPANT NAME']")).isDisplayed();
    }

    @Then("Verify login page is displayed")
    public void verifyLoginPageIsDisplayed() {
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@hint='Password']")).isDisplayed();
    }

}
