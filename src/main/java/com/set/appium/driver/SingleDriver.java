package com.set.appium.driver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

/**
 * MainRemark get a single driver case avoid double driver; Modual TODO
 * 
 * @author Tangyoude com.set.appiumSingleDriver.java 下午9:47:09
 * 
 */
public class SingleDriver {
	static {
		//driver = getSingleDriver();
	}
	protected static WebDriver driver;

	public static WebDriver getSingleDriver() {
		if (driver == null) {
			File classpathRoot = new File(System.getProperty("user.dir"));
			File appDir = new File(classpathRoot, "apps");
			File app = new File(appDir, "ContactManager.apk");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("deviceName", "Android Emulator");
			capabilities.setCapability("platformVersion", "7.0");
			capabilities.setCapability("app", app.getAbsolutePath());
			capabilities.setCapability("appPackage", "com.example.android.contactmanager");
			capabilities.setCapability("appActivity", ".ContactManager");
			try {
				driver = new AppiumDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return driver;
	}

	/**
	 * @Use        app.apk file should put in this project's apps dir
	   * @Paramers @param appdir             ContactManager.apk
	   * @Paramers @param platformVersion    7.0
	   * @Paramers @param appPackage         com.example.android.* 
	   * @Paramers @param appActivity        official .ContactManager 
	   * @Paramers @return
	   * @Return   WebDriver
	   * @modify   下午10:56:47
	 */
	public static WebDriver getSpecialDriver(String appdir, String platformVersion, String appPackage,
			String appActivity) {
		appdir=null;
//		File classpathRoot = new File(System.getProperty("user.dir"));
//		// File appDir = new File(classpathRoot, "apps");
//		File appDir = new File(classpathRoot, "apps");
//		File app = new File(appDir, appdir);
		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Android Emulator");
		// capabilities.setCapability("platformVersion", "7.0");
		capabilities.setCapability("platformVersion", platformVersion);
//		capabilities.setCapability("app", app.getAbsolutePath());
		// capabilities.setCapability("appPackage","com.example.android.contactmanager");
		capabilities.setCapability("appPackage", appPackage);
		// capabilities.setCapability("appActivity", ".ContactManager");
		capabilities.setCapability("appActivity", appActivity);
		 //A new session could not be created的解决方法
		capabilities.setCapability("appWaitActivity",appActivity);
		//每次启动时覆盖session，否则第二次后运行会报错不能新建session
		capabilities.setCapability("sessionOverride", true);
		WebDriver driver = null;
		try {
			driver = new AppiumDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}
}
/*
 public static WebDriver getSpecialDriver(String appdir, String platformVersion, String appPackage,
			String appActivity) {
		File classpathRoot = new File(System.getProperty("user.dir"));
		// File appDir = new File(classpathRoot, "apps");
		File appDir = new File(classpathRoot, "apps");
		File app = new File(appDir, appdir);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Android Emulator");
		// capabilities.setCapability("platformVersion", "7.0");
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("app", app.getAbsolutePath());
		// capabilities.setCapability("appPackage","com.example.android.contactmanager");
		capabilities.setCapability("appPackage", appPackage);
		// capabilities.setCapability("appActivity", ".ContactManager");
		capabilities.setCapability("appActivity", appActivity);
		 //A new session could not be created的解决方法
		capabilities.setCapability("appWaitActivity",appActivity);
		//每次启动时覆盖session，否则第二次后运行会报错不能新建session
		capabilities.setCapability("sessionOverride", true);
		WebDriver driver = null;
		try {
			driver = new AppiumDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}
 */
