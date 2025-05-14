import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Utility {
    public AppiumDriver driver;
    public AppiumDriverLocalService service;
    @BeforeClass
    public void setup() throws MalformedURLException {

        service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\imaginative_freak\\AppData\\Roaming\\npm\\node_modules\\appium\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Android Emulator");
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setPlatformVersion("16.0");
        options.setApp(System.getProperty("user.dir")+"/apps/ApiDemos-debug.apk");


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
    }

    @AfterClass
    public void tearDown(){
        if(driver!=null){
            driver.quit();
            service.stop();
        }
    }
}
