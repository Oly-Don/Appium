package com.set.appium.testcase.contack;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.set.appium.driver.SingleDriver;
import com.set.appium.util.Waiter;

import io.appium.java_client.FindsByFluentSelector;

/*
 * Module: test login and send a message in wchat
 * @author Tangyoude
 * @PAth   com.set.appium.testcase.contack.WchatTest.java
 * @PAth   上午2:18:23
 * @tags
 */
public class WchatTest {
	private WebDriver driver;
	boolean passFlag = false;

	@BeforeTest
	public void beforeTest() {
		driver = SingleDriver.getSpecialDriver(null, "7.0", "com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
	}

	@AfterTest
	public void afterTest() {
//		assertTrue(passFlag);
		driver.close();
	}
	
	@Test
	public void f() {
		try {
			// pemissue admit
			Waiter.sleep(2);
			driver.findElement(By.name("始终允许")).click();
			driver.findElement(By.name("始终允许")).click();
			driver.findElement(By.name("始终允许")).click();
		} catch (Exception e1) {
//			e1.printStackTrace();//debug
		}
		
		// login
		driver.findElement(By.id("com.tencent.mm:id/cnx")).click();
		// driver.findElement(By.id("com.tencent.mm:id/hb")).sendKeys("15626416001");
		// driver.findElement(By.id("com.tencent.mm:id/aey")).click();

		// login by QQ ID
		driver.findElement(By.id("com.tencent.mm:id/blj")).click();

		// username
		try {
			// upper level
			driver.findElement(By.id("com.tencent.mm:id/blh"));
			// sub level
			driver.findElement(By.id("com.tencent.mm:id/hb")).sendKeys("694728793");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// passwd
		try {
			driver.findElement(By.id("com.tencent.mm:id/bli")).click();
			WebElement pswdText = driver.findElement(By.name("请填写密码"));
			pswdText.sendKeys("fellow52%");
		} catch (Exception e) {
			e.printStackTrace();  
		}

		// login button
//		waitEle(By.id("com.tencent.mm:id/blk"),6);

		try {
			driver.findElement(By.id("com.tencent.mm:id/blk")).click();
		} catch (Exception e1) {
//			e1.printStackTrace(); //debug
		}

		try {
			// short message vertify show when vertifyd in frist time,then,would not
			// appear...so there's code in try catch
			// vertify message
			driver.findElement(By.name("通过短信验证身份")).click();

			// input by hand mark templaty
			System.out.println("input you phone short message");
			String vertifyCode = (String) new Scanner(System.in).nextLine();

			// sendKeys to vertify
			// driver.findElement(By.name("填写验证码")).sendKeys(vertifyCode);
			driver.findElement(By.id("com.tencent.mm:id/sx")).sendKeys(vertifyCode);
			// click next step
			driver.findElement(By.id("com.tencent.mm:id/gx")).click();
		} catch (Exception e) {
//			e.printStackTrace();//debug
		}

		// click yes to vertify alert
		driver.findElement(By.id("com.tencent.mm:id/aga")).click();

		Waiter.sleep(20);
		// chat page
		try {
			driver.findElements(By.id("com.tencent.mm:id/ajz")).get(0).click();
//		driver.findElement(By.id("com.tencent.mm:id/a71")).sendKeys("this is send from app auto tool Appium");
		} catch (Exception e) {
			driver.findElements(By.id("com.tencent.mm:id/ajz")).get(1).click();
		}
		
//		driver.findElement(By.id("com.tencent.mm:id/a71")).sendKeys("you wo de 我的小淑君  最可爱啦");
		
		//send button
//		driver.findElement(By.id("com.tencent.mm:id/a77")).click();
		// done
//		FindsByFluentSelector selector=(FindsByFluentSelector)driver;
//		selector.findElement("id","com.tencent.mm:id/a71").sendKeys("FindsByFluentSelector ok");
//		driver.findElement(By.id("com.tencent.mm:id/a77")).click();
		
		//fuctions
		Waiter.sleep(1);
		//add
		driver.findElement(By.id("com.tencent.mm:id/a76")).click();
		Waiter.sleep(1);
		try {
			driver.findElement(By.id("//*[text='视频聊天')]")).click();
		} catch (Exception e) {
			driver.findElements(By.id("com.tencent.mm:id/n1")).get(2).click();
			e.printStackTrace();
		}
		Waiter.sleep(1);
		try {
			driver.findElement(By.id("//*[contains(text, '视频聊天')]")).click();
		} catch (Exception e) {
			driver.findElements(By.id("com.tencent.mm:id/n1")).get(1).click();
			e.printStackTrace();
		}
		
		List<WebElement> texts = driver.findElements(By.id("com.tencent.mm:id/iy"));
		if(texts.size() != 0) {
			passFlag = true;
		}
//		//can't get this ele's value
//		for (WebElement ele : texts) {
//			if (ele.getText().equals("you wo de 我的小淑君  最可爱啦")) {
//				passFlag = true;
//			}
//		}
	
	}

	 /**
	  * @Use        TODO
	    * @Paramers @param by
	    * @Paramers @param time
	    * @Return   void
	    * @modify   下午6:08:35
	  */
	public void waitEle(By by, int time) {
		for (int i = 0;; i++) {
			if (i > time) {
				fail("timeout");
			}
			try {
				if (driver.findElement(by).isDisplayed()) {
					break;
				}
			} catch (Exception e) {
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}



}
