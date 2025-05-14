import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidTest {
    AppiumDriver driver;

@BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("automationName","UiAutomator2");
        capabilities.setCapability("platformVersion","16.0");
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("app",System.getProperty("user.dir")+"/apps/ApiDemos-debug.apk");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),capabilities);
    }
    @Test(priority=1)
    public void clickOnAppButton(){
 driver.findElement(AppiumBy.accessibilityId("")).click();
    }
    @AfterTest
    public void tearDown(){
        if(driver!=null){
            driver.close();
        }
}
}
