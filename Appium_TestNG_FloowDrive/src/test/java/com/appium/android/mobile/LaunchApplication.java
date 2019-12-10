package com.appium.android.mobile;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class LaunchApplication extends Capabilities{

	public static URL url;
	public static DesiredCapabilities capabilities;
//	public static AndroidDriver<MobileElement> driver;
	public String appPath = "C:\\Users\\DELL\\Documents\\Mobile\\Appium_TestNG_FloowDrive\\floowDrive.apk";

	public void installFloowDriveApp() throws InterruptedException {
		try {
			driver.removeApp(appPath);
			driver.installApp(appPath);
			driver.launchApp();
		} catch (Exception e) {
			driver.resetApp();
			Reporter.log("Floowdrive App is installed successfully");
			Thread.sleep(4000);
			driver.launchApp();
		}
	}

}
