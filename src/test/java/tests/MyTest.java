package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import screenRecord.MyScreenRecorder;
import screenRecord.ScreenRecorder;
import screenRecord.ScreenRecorderUtil;

public class MyTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
	}
	
	
	@Test
	public void navigationTest() throws Exception {
		//MyScreenRecorder.startRecording("navigationTest");
		ScreenRecorderUtil.startRecord("navigationTest");
		driver.get("http://www.google.com");
		driver.navigate().to("http://www.facebook.com");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().forward();
		ScreenRecorderUtil.stopRecord();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
