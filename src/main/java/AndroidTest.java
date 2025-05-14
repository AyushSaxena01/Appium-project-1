import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;


public class AndroidTest extends Utility{

    @Test(priority=1)
    public void clickOnAppButton(){
 driver.findElement(AppiumBy.accessibilityId("Preference")).click();
    }

}
