package testBase;

import org.testng.annotations.BeforeClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

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
		  desiredCapabilities.setCapability("platformName", "iOS");
		  desiredCapabilities.setCapability("platformVersion", "14.3");
		  desiredCapabilities.setCapability("deviceName", "iPhone");
		  desiredCapabilities.setCapability("automationName", "XCUITest");
		  desiredCapabilities.setCapability("bundleId", "com.VodafoneIreland.MyVodafone");
		  desiredCapabilities.setCapability("udid", "22c5feb1942a7fe03a2175d284ab1b17234aa3d1");
		  
		  URL url = new URL("http://0.0.0.0:4723/wd/hub");
		  
		  driver = new IOSDriver(url, desiredCapabilities);
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
