package com.mobile.automation;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class Facebook {

	private AppiumDriver<AndroidElement> driver;

	public void setUp() throws Exception {

		// set up appium and tell from where it can install the apk file from
		// computer to device
		//File appDir = new File("C:\\Users\\Shiv\\Desktop\\Java\\Softwares");
		//File app = new File(appDir, "com.facebook.apk");
		// Very important properties you need for Appium to work, change as per
		// SDK and device name
		 File classpathRoot = new File(System.getProperty("user.dir"));
	        File appDir = new File(classpathRoot, "../../../apps/ContactManager");
	        File app = new File(appDir, "ContactManager.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("device", "Android");
		capabilities.setCapability("deviceName", "6D9D6T4TUWYDMJZT");
		capabilities.setCapability("platformName", "Android");
		// You need to have this sdk installed for Appium to work
		capabilities.setCapability("platformVersion", "5.0");
		capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.example.android.contactmanager");
        capabilities.setCapability("appActivity", ".ContactManager");
		//capabilities.setCapability("app", "settings");
		// The URL where the hub will start
		//driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),
			//	capabilities);
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//		WebElement accept = driver.findElement(By
//				.id("com.facebook:id/eula_accept"));	
//		accept.click();
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		addContact();
		driver.quit();
	}

	public static void main(String args[]){
		Facebook ws = new Facebook();
		try{
			System.out.println("Start the music");
		ws.setUp();
		}catch(Exception e){
			System.out.println(e);
		}
	}
		
	 public void addContact(){
	        WebElement el = driver.findElement(By.name("Add Contact"));
	        el.click();
	        List<AndroidElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
	        textFieldsList.get(0).sendKeys("TestAppium");
	        textFieldsList.get(2).sendKeys("Some@example.com");
	        driver.swipe(100, 500, 100, 100, 2);
	        driver.findElementByName("Save").click();
	    }

		
	
//	@AfterMethod
//	public void tearDown() throws Exception {
//		driver.quit();
//	}
//
//	@Test
//	public void whatsAppinstall() {
//		// Find and click the accept button
//		WebElement accept = driver.findElement(By
//				.id("com.whatsapp:id/eula_accept"));
//		accept.click();
//		// Verify nect page title after you click accept button
//		Assert.assertEquals("Verify your phone number",
//				driver.findElement(By.id("android:id/action_bar_title"))
//						.getText());
//	}

}