package com.set.appium.testcase.contack;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.set.appium.driver.SingleDriver;
/**
 * 
 * Module: test login and send a message in wchat
 * @author Tangyoude
 * @PAth   com.set.appium.testcase.contack.WchatTest.java
 * @PAth   上午2:18:23
 * @tags
 */
public class WchatTest {
  private WebDriver driver;
  boolean passFlag=false;
@Test
  public void f() {
	//pemissue admit
	driver.findElement(By.name("始终允许")).click();
	driver.findElement(By.name("始终允许")).click();
	driver.findElement(By.name("始终允许")).click();
	//login
	driver.findElement(By.id("com.tencent.mm:id/cnx")).click();
//	driver.findElement(By.id("com.tencent.mm:id/hb")).sendKeys("15626416001");
//	driver.findElement(By.id("com.tencent.mm:id/aey")).click();
		
	//login by QQ ID
	driver.findElement(By.id("com.tencent.mm:id/blj")).click();
	
	//username
	try {
		//upper level
		driver.findElement(By.id("com.tencent.mm:id/blh"));
		//sub level
		driver.findElement(By.id("com.tencent.mm:id/hb")).sendKeys("694728793");
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	//passwd
	try {
		driver.findElement(By.id("com.tencent.mm:id/bli")).click();
//		driver.findElement(By.xpath(".//*[@id='com.tencent.mm:id/hb']")).sendKeys("fellow52%");
		WebElement pswdText = driver.findElement(By.name("请填写密码"));
		pswdText.sendKeys("fellow52%");
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	//login button
	driver.findElement(By.id("com.tencent.mm:id/blk")).click();
	
	try {
		//short message vertify show when vertifyd in frist time,then,would not appear...so there's code in try catch
		//vertify message
		driver.findElement(By.name("通过短信验证身份")).click();
		
		//input by hand mark templaty
		System.out.println("input you phone short message");
		String vertifyCode=(String)new Scanner(System.in).nextLine();
		
		//sendKeys to vertify
//	driver.findElement(By.name("填写验证码")).sendKeys(vertifyCode);
		driver.findElement(By.id("com.tencent.mm:id/sx")).sendKeys(vertifyCode);
		//click next step
		driver.findElement(By.id("com.tencent.mm:id/gx")).click();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	//click yes to vertify alert
	driver.findElement(By.id("com.tencent.mm:id/aga")).click();
	
	//chat page
	driver.findElement(By.id("com.tencent.mm:id/ajz")).click();
	driver.findElement(By.id("com.tencent.mm:id/a71")).sendKeys("this is send from app auto tool Appium");
	driver.findElement(By.id("com.tencent.mm:id/a71")).sendKeys(Keys.ENTER);
	List<WebElement> texts = driver.findElements(By.id("com.tencent.mm:id/iy"));
	for(WebElement ele:texts) {
		System.out.println(ele.getAttribute("index")+ele.getAttribute("bounds")+ele.getText());
		if(ele.getText().equals("this is send from app auto tool Appium")){
			passFlag=true;
		}
	}
 }

  @BeforeTest
  public void beforeTest() {
	  driver=SingleDriver.getSpecialDriver(null, "7.0", "com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
	  assertTrue(passFlag);
  }

}
