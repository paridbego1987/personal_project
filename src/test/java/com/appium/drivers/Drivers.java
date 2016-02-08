package com.appium.drivers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

/**
 * Created by parid on 14/10/15.
 */


public class Drivers {
	private static DesiredCapabilities caps = new DesiredCapabilities();
	private static AppiumDriver<MobileElement> driver;
	public static Properties prop = new Properties();
	static InputStream input = null;
	public static String device = null;
	public static String build = null;
	public static String platform = null;

	public static String getDevice() {
		device = System.getProperty("device");
		return device;
	}

	public static String getBuild() {
		build = System.getProperty("env");
		return build;
	}

	public static String getPlatform() {
		platform = System.getProperty("platform");
		return platform;
	}

	public static AppiumDriver<MobileElement> getDriver() throws IOException {
//		load properties file
		input = new FileInputStream("properties/driver.properties");
		prop.load(input);

		getDevice();
		getBuild();
		getPlatform();

//		device is set at command line
		if (device.equals("android_sim")) {
			androidSimSetup();
		} else if (device.equals("ios_sim")){
			iosSimSetup();
		} else if (device.equals("iphone6")) {
			iPhone6Setup();
		} else if (device.equals("iphone5s")) {
			iPhone5sSetup();
		} else if (device.equals("iphone6Plus")){
			iPhone6PlusSetup();
		} else if (device.equals("iphone6s")){
			iPhone6sSetup();
		} else if (device.equals("iphone5c")){
			iPhone5cSetup();
		} else if (device.equals("samsung")){
			androidSamsungSetup();
		} else if (device.equals("htc")){
			androidHtcSetup();
		} else if (device.equals("nexus")){
			androidTabletSetup();
		} else if (device.equals("nexus5x")){
			android5xSetup();
		} else {
			iosSimSetup();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

	public static void androidSimSetup() throws MalformedURLException {
		caps.setCapability("platformName", prop.getProperty("android_platform_name"));
		caps.setCapability("platformVersion", System.getProperty("version"));
		caps.setCapability("deviceName", System.getProperty("name"));
		caps.setCapability("app", System.getProperty("user.dir") + prop.getProperty("apk"));
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4728/wd/hub"), caps);
	}

	public static void iosSimSetup() throws MalformedURLException {
		caps.setCapability("platformName", prop.getProperty("ios_platform_name"));
		caps.setCapability("platformVersion", System.getProperty("version"));
		caps.setCapability("deviceName", System.getProperty("name"));
		caps.setCapability("app", System.getProperty("user.dir") + prop.getProperty("ios_app_" + build));
		driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	}

	public static void iPhone6Setup() throws MalformedURLException {
		caps.setCapability("platformName", prop.getProperty("ios_platform_name"));
		caps.setCapability("deviceName", prop.getProperty("ios_device_name"));
		caps.setCapability("udid", prop.getProperty("udid"));
		caps.setCapability("app", System.getProperty("user.dir") + prop.getProperty("ios_ipa_" + build));
		driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	}

	public static void iPhone5sSetup() throws MalformedURLException {
		caps.setCapability("platformName", prop.getProperty("ios_platform_name"));
		caps.setCapability("deviceName", prop.getProperty("iphone5s_device_name"));
		caps.setCapability("udid", prop.getProperty("iphone5s_udid"));
		caps.setCapability("app", System.getProperty("user.dir") + prop.getProperty("ios_ipa_" + build));
		driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	}

	public static void iPhone6PlusSetup() throws MalformedURLException {
		caps.setCapability("platformName", prop.getProperty("ios_platform_name"));
		caps.setCapability("deviceName", prop.getProperty("6Plus_device_name"));
		caps.setCapability("udid", prop.getProperty("6Plus_udid"));
		caps.setCapability("app", System.getProperty("user.dir") + prop.getProperty("ios_ipa_" + build));
		driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	}

	public static void iPhone6sSetup() throws MalformedURLException {
		caps.setCapability("platformName", prop.getProperty("ios_platform_name"));
		caps.setCapability("deviceName", prop.getProperty("6S_device_name"));
		caps.setCapability("udid", prop.getProperty("6S_udid"));
		caps.setCapability("app", System.getProperty("user.dir") + prop.getProperty("ios_ipa_" + build));
		driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	}

	public static void iPhone5cSetup() throws MalformedURLException {
		caps.setCapability("platformName", prop.getProperty("ios_platform_name"));
		caps.setCapability("deviceName", prop.getProperty("ios_device_name_2"));
		caps.setCapability("udid", prop.getProperty("udid_2"));
		caps.setCapability("app", System.getProperty("user.dir") + prop.getProperty("ios_ipa_" + build));
		driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	}

	public static void androidSamsungSetup() throws MalformedURLException {
		caps.setCapability("platformName", prop.getProperty("android_platform_name"));
//		caps.setCapability("platformVersion", System.getProperty("version"));
		caps.setCapability("deviceName", prop.getProperty("samsung_device_name"));
		caps.setCapability("app", System.getProperty("user.dir") + prop.getProperty("apk"));
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	}

	public static void androidHtcSetup() throws MalformedURLException {
		caps.setCapability("platformName", prop.getProperty("android_platform_name"));
//		caps.setCapability("platformVersion", System.getProperty("version"));
		caps.setCapability("deviceName", prop.getProperty("android_htc_device_name"));
		caps.setCapability("app", System.getProperty("user.dir") + prop.getProperty("apk"));
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	}

	public static void androidTabletSetup() throws MalformedURLException {
		caps.setCapability("platformName", prop.getProperty("android_platform_name"));
//		caps.setCapability("platformVersion", System.getProperty("version"));
		caps.setCapability("deviceName", prop.getProperty("android_tablet_device_name"));
		caps.setCapability("app", System.getProperty("user.dir") + prop.getProperty("apk"));
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	}

	public static void android5xSetup() throws MalformedURLException {
		caps.setCapability("platformName", prop.getProperty("android_platform_name"));
//		caps.setCapability("platformVersion", System.getProperty("version"));
		caps.setCapability("deviceName", prop.getProperty("android_nexus5x_device_name"));
		caps.setCapability("app", System.getProperty("user.dir") + prop.getProperty("apk"));
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	}

}
