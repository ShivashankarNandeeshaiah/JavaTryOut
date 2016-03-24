package com.mobile.automation;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Youtube {

	WebDriver driver;


	public void setUp() throws MalformedURLException{

		//File appDir = new File("C:\\Users\\Shiv\\Desktop\\Java\\Softwares\\android-sdk_r24.4.1-windows\\android-sdk-windows\\build-tools\\androidApk");
		//File app = new File(appDir, "com.google.android.youtube.apk");
		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "5.0"); 
		capabilities.setCapability("deviceName","Emulator");
		capabilities.setCapability("platformName","Android");

		//capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.google.android.youtube");
		// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appActivity","com.google.android.apps.youtube.app.WatchWhileActivity"); // This is Launcher activity of your app (you can get it from apk info app)
		//Create RemoteWebDriver instance and connect to the Appium server
		//It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


	}


	public void testCal() throws Exception {
		//locate the Text on the calculator by using By.name()
		//WebElement two=driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Account']"));
		WebElement one=driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Search']"));

		one.click();
		WebElement plus=driver.findElement(By.xpath("//android.widget.EditText[@text='Search YouTube']"));

		plus.sendKeys("Hello Adele");
		plus.click();
		Thread.sleep(3000);
		WebElement two=driver.findElement(By.xpath("//android.widget.TextView[@text='hello adele']"));
		two.click();

		Thread.sleep(3000);
		WebElement four=driver.findElement(By.xpath("//android.widget.TextView[@text='Adele - Hello']"));
		four.click();
		Thread.sleep(9000);
		 driver.quit();
	}


	public static void main(String[] args) {
		Youtube ct = new Youtube();
		try{
			ct.setUp();
			ct.testCal();
			
			
		}catch(Exception e){
			System.out.println(e);
		}

	}

}
