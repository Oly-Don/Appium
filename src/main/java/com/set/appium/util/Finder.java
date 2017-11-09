package com.set.appium.util;

import static org.junit.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.set.appium.driver.SingleDriver;

/**
 * MainRemark finder Element by id name xpath
 * 
 * @author Tangyoude com.set.appium.utilFinder.java 下午9:56:23
 * 
 */
public class Finder extends SingleDriver {

	public static WebElement findById(String id) {
		return driver.findElement(By.id(id));
	}

	public static WebElement findByName(String name) {
		return driver.findElement(By.name(name));
	}

	public static WebElement findByXpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}
	
	public static List<WebElement> findByIds(String id) {
		return driver.findElements(By.id(id));
	}

	public static List<WebElement> findByNames(String name) {
		return driver.findElements(By.name(name));
	}

	public static List<WebElement> findByXpaths(String xpath) {
		return driver.findElements(By.xpath(xpath));
	}
	
	public static void clickById(String id) {
		findById(id).click();
	}

	public static void clickByName(String name) {
		findByName(name).click();
	}

	public static void clickByXpath(String xpath) {
		findByXpath(xpath).click();
	}

	public static void sendKeysById(String id, String idKeys) {
		findById(id).sendKeys(idKeys);
	}

	public static void sendKeysByName(String name, String nameKeys) {
		findByName(name).sendKeys(nameKeys);
	}

	public static void sendKeysByXpath(String xpath, String xpathKeys) {
		findByXpath(xpath).sendKeys(xpathKeys);
	}

	
}
