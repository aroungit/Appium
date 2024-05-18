package wrappers;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class ProjectSpecificWrappers extends GenericWrappers{

    @Parameters({"platformName","udid","automationName","systemPort","app","mjpegServerPort"})
    @BeforeMethod
    public void bm(String platformName, String udid, String automationName, String systemPort,String app, String mjpegServerPort) {
        //launchAndroidApp("","","UiAutomator2","\\apks\\leaforg.apk");
        launchApp(platformName,"",udid,"","",automationName,"",systemPort,
                "","","",app,mjpegServerPort,"");
    }

    @AfterMethod
    public void am() {
        closeApp();
    }
}
