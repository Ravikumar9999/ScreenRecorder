package screenRecord;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class ScreenRecorder {
 
 WebDriver driver;
 String baseUrl = "http://www.google.com";
 ATUTestRecorder recorder;

 @BeforeTest
 public void setup() throws ATUTestRecorderException {
	 
	
	 System.setProperty("webdriver.gecko.driver", "C:\\Selenium Drivers\\geckodriver.exe");
		
	
	
	System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
	System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
	recorder = new ATUTestRecorder("./recording/","GoogleTestExtention", false);
	recorder.start();
	
	FirefoxOptions options = new FirefoxOptions();
	driver = new FirefoxDriver(options);
	
	options.setLogLevel(FirefoxDriverLogLevel.TRACE);
	options.addPreference("browser.tabs.remote.autostart", false);
	options.addPreference("security.sandbox.content.level", 5);
	
  
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  //driver.get("http://google.com/");
 }

 @Test(description = "TC_1 Open Google Site")
 public void openUrl(){  
  driver.get(baseUrl);
  System.out.println("Firefox Browser opens URL");
  
  String actual_title = driver.getTitle();
  System.out.println("Page Actual title is: " + actual_title);
  
  String expected_title = "Google";
  System.out.println("Page Expected title is: " + expected_title);
  
  assertEquals(actual_title, expected_title);
  Reporter.log("Google site is open");
  System.out.println("Google website is open Successfully");
 } 
 
 @AfterTest
 public void tearDown() throws ATUTestRecorderException {
  driver.quit();
  recorder.stop();;
 }

}
