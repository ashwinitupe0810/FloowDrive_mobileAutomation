package com.appium.android.mobile;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
//import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.touch.offset.PointOption;

public class Capabilities {
	
	  public static URL url;
	  public static DesiredCapabilities capabilities;
	  public static AppiumDriver<MobileElement> driver;
	  String localDir = System.getProperty("user.dir");
	  File appPath = new File(localDir + "Documents\\Mobile\\Appium_TestNG_FloowDrive\\floowDrive.apk");
	  public String URL_STRING = "http://127.0.0.1:4723/wd/hub";
	   

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Capabilities capabilities = new Capabilities();
		UserRegistration userReg = new UserRegistration();
		LaunchApplication launchApp = new LaunchApplication();
		capabilities.setCapabilities();
		launchApp.installFloowDriveApp();
		userReg.userNewSignIn();
		
	}
	
	public void setCapabilities() throws Exception {
		 url = new URL(URL_STRING);
	  
	    DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "vivo 1723");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        capabilities.setCapability("appPackage", "com.thefloow.thefloowltd.floowdrive.app");
        capabilities.setCapability("appActivity", "com.thefloow.turnkey.ui.launcher.LauncherActivity");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.UDID, "70bd90d1");
        capabilities.setCapability(MobileCapabilityType.APP, appPath);
        driver = new AndroidDriver<MobileElement>(url, capabilities);
    //    AppiumDriver<MobileElement>  driver = new AndroidDriver<MobileElement>(url, capabilities);
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	
	}
		
	
	public void swipe() {
	Dimension size = this.driver.manage ()
		    .window ()
		    .getSize ();
		int startX = size.getWidth () / 2;
		int startY = size.getHeight () / 2;
		int endX = 0;
		int endY = (int) (startY * -1 * 0.75);
		TouchAction action = new TouchAction (this.driver);
		action.press (PointOption.point(startX, startY))
		    .moveTo (PointOption.point(endX, endY))
		    .release ()
		    .perform ();
		
	}
	
	  
	public void hideKeyBoard() throws MalformedURLException {
		((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
	}
	
	
}
