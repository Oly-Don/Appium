package com.set.appium;

import io.appium.java_client.AppiumDriver;

import org.apache.commons.io.FileUtils;
import org.junit.After;  
import org.junit.Before;  
import org.junit.Test;  
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;  
import org.openqa.selenium.remote.CapabilityType;  
import org.openqa.selenium.remote.DesiredCapabilities;  
   
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;  
import java.util.List; 

/**
 * MainRemark TODO
 * Modual TODO
 * @author Tangyoude
 * com.set.appiumAppContact.java
 * 上午9:32:06
 * 
 */
public class AppContact {

	 private static AppiumDriver driver;

	@Before  
	    public void setUp() throws Exception {  
	        // set up appium  
	        File classpathRoot = new File(System.getProperty("user.dir"));  
	        File appDir = new File(classpathRoot, "apps");  
	        File app = new File(appDir, "ContactManager.apk");  
	        DesiredCapabilities capabilities = new DesiredCapabilities();  
	        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");  
	        capabilities.setCapability("platformName", "Android");  
	        capabilities.setCapability("deviceName","Android Emulator");  
	        capabilities.setCapability("platformVersion", "7.0");  
//	        capabilities.setCapability("platformVersion", "5.0");  
	        capabilities.setCapability("app", app.getAbsolutePath());  
	        capabilities.setCapability("appPackage", "com.example.android.contactmanager");  
	        capabilities.setCapability("appActivity", ".ContactManager");  
	        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);  
	    }  
	   
	    @After  
	    public void tearDown() throws Exception {  
	    	screenShot("C", "Test");
	        driver.quit();  
	    }  
	   
	    @Test  
	    public void addContact(){  
	        WebElement el = driver.findElement(By.name("Add Contact"));  
	        el.click();  
	        List<WebElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");  
	        textFieldsList.get(0).sendKeys("Some Name");  
	        textFieldsList.get(2).sendKeys("Some@example.com");  
//	        driver.swipe(100, 500, 100, 100, 2);  
	        driver.findElementByName("Save").click();  
	       
	    }  
	    
		public static void screenShot(String FileDir, String picName) {
			try {
				File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(srcFile, new File(FileDir + "\\"+picName+"appium.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
}
