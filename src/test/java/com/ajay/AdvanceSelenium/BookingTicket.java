package com.ajay.AdvanceSelenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;

public class BookingTicket {
	private WebDriver driver;

	@DataProvider(name = "loginData")
	public String[][] login_data() throws IOException {
		ExcelUtility.setExcelPath("Sheet1", "C:\\Users\\A06438_p5.training\\Desktop\\testdata\\Book1.xlsx");
		String userName = ExcelUtility.getCellData(1, 1);
		String password = ExcelUtility.getCellData(1, 2);
		return new String[][] { new String[] { userName, password } };
	}

	@Test(dataProvider = "loginData")
	public void login(String userName, String password) {
		LoginPageObject.uname.sendKeys(userName);
		LoginPageObject.password.sendKeys(password);
		LoginPageObject.login_button.click();

	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\A06438_p5.training\\Downloads\\Selenium Drivers\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		PageFactory.initElements(driver, LoginPageObject.class);
	}

	@AfterTest
	public void afterTest() {
	}

}
