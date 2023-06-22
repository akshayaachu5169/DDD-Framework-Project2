package com.vcentry.lab.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vcentry.lab.Initializer.Initializer;
import com.vcentry.lab.pages.Loginpage;

public class LoginTest extends Initializer {

	@Test(dataProvider = "test data")
	public void validateLoginTest(String username, String password) throws IOException {
		initializer();
		wd.get(envprop.getProperty("Url"));
		Loginpage.enterUsername(username);
		Loginpage.enterPassword(password);
		Loginpage.clickLoginbutton();
		wd.quit();
	}

	@DataProvider(name = "test data")
	public static Object[][] getLoginTest() throws InterruptedException, IOException {
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(
				"C:\\WorkSpace3\\I2_DDDTest\\src\\test\\resources\\com\\vcentry\\lab\\config\\DDDdata.xlsx"));
		XSSFSheet sheet = workbook.getSheet("Home");
		int rowsize = sheet.getLastRowNum() + 1;
		int cellsize = sheet.getRow(0).getLastCellNum();
		Object data[][] = new Object[rowsize][cellsize];
		for (int i = 0; i < rowsize; i++) {
			for (int j = 0; j < cellsize; j++) {

				data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();

			}

		}
		return data;
	}
}
