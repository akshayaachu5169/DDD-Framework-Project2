package com.vcentry.lab.Initializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Initializer {
	public static FileInputStream envfis;
	public static Properties envprop;
	public static FileInputStream locfis;
	public static Properties locprop;

	public static WebDriver wd;

	public  void initializer() throws IOException {
		// env prop
		envfis = new FileInputStream(
				System.getProperty("user.dir") + File.separator+"src"+File.separator+"test"+File.separator +"resources"+File.separator+"com"+File.separator+"vcentry"+File.separator+"lab"+File.separator+"config"+File.separator+"env.properties");
		envprop = new Properties();
		envprop.load(envfis);

		// loc prop
		locfis =new FileInputStream(System.getProperty("user.dir") + File.separator+"src"+File.separator+"test"+File.separator +"resources"+File.separator+"com"+File.separator+"vcentry"+File.separator+"lab"+File.separator+"config"+File.separator+"locator.properties");
		locprop = new Properties();
		locprop.load(locfis);

		if (envprop.get("Browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			wd = new ChromeDriver();

		} else if (envprop.get("Browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			wd = new FirefoxDriver();

		}

		wd.manage().window().maximize();
		wd.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
	
	public static WebElement getElementByName(String name) {
		return wd.findElement(By.name(locprop.getProperty(name)));
	}
public static WebElement getElementByid(String id) {
	return wd.findElement(By.id(locprop.getProperty(id)));
	}

public static WebElement getElementByxpath(String xpath) {
	return wd.findElement(By.xpath(locprop.getProperty(xpath)));
}
	
}
