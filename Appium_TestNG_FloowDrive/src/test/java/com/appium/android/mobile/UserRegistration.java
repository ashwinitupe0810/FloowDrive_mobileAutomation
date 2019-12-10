package com.appium.android.mobile;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.touch.offset.PointOption;

public class UserRegistration extends Capabilities {
	
	public void userNewSignIn() throws Exception {
		Random rand = new Random(); 
		int rand_int1 = rand.nextInt(10000);
		Thread.sleep(4000);
		driver.findElementById("register_email_address").sendKeys(rand_int1+"ashwini@gmail.com");
		driver.findElementById("register_password").sendKeys("Ashwini@123");
		driver.findElementById("register_confirm_password").sendKeys("Ashwini@123");
		swipe();
		driver.findElementById("register_forename").sendKeys("Test User");
		driver.findElementById("register_surname").sendKeys("Ashwini");
		driver.findElementById("register_dob").click();
		driver.findElementByXPath("//android.view.View[@content-desc='01 January 2001']").click();
		driver.findElementByXPath("//*[@text='OK']").click();
		Thread.sleep(3000);
		swipe();
		driver.findElementById("register_postcode").sendKeys("G5 0UH");
		hideKeyBoard();
		TouchAction action = new TouchAction (this.driver);
		action.press (PointOption.point(404, 1938))
		    .moveTo (PointOption.point(439, 468)) .release () .perform ();
		Thread.sleep(3000);
		driver.findElementById("chk_agree").click();
		driver.findElementById("btn_register").click();
		Thread.sleep(13000);
		
	}
	
	public static Timestamp getRandomTime(){
		String test;
		  Random r = new Random();
		  int Low = 100;
		  int High = 1500;
		  int Result = r.nextInt(High-Low) + Low;
		  int ResultSec = r.nextInt(High-Low) + Low;

		  Calendar calendar = Calendar.getInstance();
		  calendar.add(Calendar.MINUTE, - Result);
		  calendar.add(Calendar.SECOND, - ResultSec);

		  java.sql.Timestamp ts = new java.sql.Timestamp(calendar.getTimeInMillis());
		  return ts;
		}
	
}
