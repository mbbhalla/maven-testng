/*
* Copyright (c) 2013-2014 Software AG, Darmstadt, Germany 
* and/or Software AG USA Inc., Reston, VA, USA, and/or 
* its subsidiaries and or/its affiliates and/or their 
* licensors.
* Use, reproduction, transfer, publication or disclosure 
* is prohibited except as specifically provided for in your 
* License Agreement with Software AG.
*/

package io.accomplice.testing.selenium.utils;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.TestException;

public final class LoginUtils {
	public static void login(final Map<String, Object> args) throws TestException {
		final WebDriver driver = (WebDriver)args.get("DRIVER");
		String url = (String)args.get("URL");
		String username = (String)args.get("USERNAME");
		String password = (String)args.get("PASSWORD");
		
		driver.get(url);
		driver.findElement(By.name("j_username")).sendKeys(username);
		driver.findElement(By.name("j_password")).sendKeys(password);
		driver.findElement(By.name("j_password")).sendKeys(Keys.ENTER);
		String actualpageTitle = driver.getTitle();
		String expectedPageTitle = "accomplice.io | BI Dashboard";

		if(!actualpageTitle.equals(expectedPageTitle)) {
			throw new TestException("actualPageTitle did not match expectedPageTitle - actual = " + actualpageTitle + " - expected = " + expectedPageTitle);
		}
	}
}
