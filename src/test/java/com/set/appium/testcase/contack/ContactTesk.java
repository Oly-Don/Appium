package com.set.appium.testcase.contack;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.set.appium.driver.SingleDriver;

/**
 * 
 * Module: test a apk
 * 
 * @author Tangyoude
 * @PAth com.set.appium.testcase.contack.ContactTesk.java
 * @PAth 下午10:47:12
 * @tags
 */
public class ContactTesk {
	private static WebDriver driver;

	@Test
	public void test() {
//		List<WebElement> texts = driver.findElements(By.className("android.widget.TextView"));
//		for(WebElement ele:texts) {
//			System.out.println(ele.getText());
//		}
		
//		List<WebElement> messageBody = driver.findElements(By.className("com.android.mms:id/emui_list_view"));
		//get name or id by android install dir 's tools .there are a uiautomatorviewer.bat.
		driver.findElement(By.name("新建")).click();;
		driver.findElement(By.name("输入收件人")).sendKeys("10010");
		driver.findElement(By.name("输入信息")).sendKeys("test from appium");
		driver.findElement(By.id("com.android.mms:id/send_button_sms")).click();
		List<WebElement> specialTexts = driver.findElements(By.className("com.android.mms:id/text_view"));
		for(WebElement ele:specialTexts) {
			System.out.println(ele.getText());
		}
//		assertTrue(findByIds.get(findByIds.size()-1).getText().indexOf("联通") != -1);
	}

	@BeforeMethod
	public void beforeMethod() {
//		driver = SingleDriver.getSpecialDriver("com.android.mms", "7.0", "com.android.mms",
//				"com.android.mms.ui.ComposeMessageActivity");
		//get  appPackage appActivity by adb command
		//cmd  -->  C:\Users\69472> adb shell dumpsys window w |findstr \/ |findstr name=
		driver = SingleDriver.getSpecialDriver("com.android.mms", "7.0", "com.android.mms",
				"com.android.mms.ui.ConversationList");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {
		
	}

}
