package com.vcentry.lab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vcentry.lab.Initializer.Initializer;

public class Loginpage  extends Initializer{

	public static void enterUsername(String data) {
		getElementByName("Username_type_name").sendKeys(data);
		
	}
	
public static void enterPassword(String data) {
	getElementByName("Password_type_name").sendKeys(data);
	
	
	
	}

public static void clickLoginbutton() {
	getElementByxpath("Loginbutton_click_xpath").click();
	
	
	
	
}
	
	
}
