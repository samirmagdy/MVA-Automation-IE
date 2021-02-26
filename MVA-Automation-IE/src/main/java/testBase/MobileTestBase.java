package testBase;

import org.testng.annotations.BeforeClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterClass;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MobileTestBase {
	protected AppiumDriver driver;
 
  @BeforeClass
  public void beforeClass() {
	  try {
		  DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		  desiredCapabilities.setCapability("platformName", "Android");
		  desiredCapabilities.setCapability("platformVersion", "Version");
		  desiredCapabilities.setCapability("deviceName", "Device Name");
		  desiredCapabilities.setCapability("automationName", "UiAutomator2");
		  desiredCapabilities.setCapability("appPackage", "App Package");
		  desiredCapabilities.setCapability("appActivity", "App Activity");
		  
		  URL url = new URL("http://127.0.0.1:4723/wd/hub");
		  
		  driver = new AndroidDriver(url, desiredCapabilities);
		  String sessionId = driver.getSessionId().toString();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	} catch (Exception e) {
		e.printStackTrace();
	}
	  
	  
  }

  @AfterClass
  public void afterClass() {
  }

}
