package com.mobile.automation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class YoutubeTestNG {

	WebDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "5.0");
		capabilities.setCapability("deviceName", "Emulator");
		capabilities.setCapability("platformName", "Android");

		capabilities.setCapability("appPackage", "com.google.android.youtube");
		// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appActivity", "com.google.android.apps.youtube.app.WatchWhileActivity"); // This
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	}

	@Test
	public void testCal() throws Exception {
		// locate the Text on the calculator by using By.name()

		WebElement one = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Search']"));

		one.click();
		WebElement plus = driver.findElement(By.xpath("//android.widget.EditText[@text='Search YouTube']"));

		plus.sendKeys("Hello Adele");
		plus.click();
		Thread.sleep(3000);
		WebElement two = driver.findElement(By.xpath("//android.widget.TextView[@text='hello adele']"));
		two.click();

		Thread.sleep(3000);
		WebElement four = driver.findElement(By.xpath("//android.widget.TextView[@text='Adele - Hello']"));
		four.click();

		
	}

	@AfterClass
	public void teardown() {
		// close the app
		driver.quit();
	}

}
