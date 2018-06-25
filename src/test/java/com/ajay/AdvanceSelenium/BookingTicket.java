package com.ajay.AdvanceSelenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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

	@Test(priority = 1, dataProvider = "loginData")
	public void login(String userName, String password) {
		LoginPageObject.uname.sendKeys(userName);
		LoginPageObject.password.sendKeys(password);
		LoginPageObject.login_button.click();
		// assertEquals("Find a Flight: Mercury Tours:",driver.getTitle());

	}

	@Test(priority = 2)
	public void bookTicket() {
		driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(5) > td:nth-child(1) > form:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2) > b:nth-child(1) > font:nth-child(1) > input:nth-child(2)"))
				.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Select s = new Select(driver.findElement(By.cssSelector(
				"html body div table tbody tr td table tbody tr td table tbody tr td table tbody tr td form table tbody tr td b select")));
		s.selectByValue("3");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Select s1 = new Select(driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(5) > td:nth-child(1) > form:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(2) > select:nth-child(1)")));
		s1.selectByValue("London");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Select s2 = new Select(driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(5) > td:nth-child(1) > form:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(5) > td:nth-child(2) > select:nth-child(1)")));
		s2.selectByValue("2");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Select s3 = new Select(driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(5) > td:nth-child(1) > form:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(5) > td:nth-child(2) > select:nth-child(2)")));
		s3.selectByValue("1");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(5) > td:nth-child(1) > form:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(9) > td:nth-child(2) > font:nth-child(1) > font:nth-child(2) > input:nth-child(4)"));
		Select s4 = new Select(driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(5) > td:nth-child(1) > form:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(10) > td:nth-child(2) > select:nth-child(1)")));
		s4.selectByVisibleText("Blue Skies Airlines");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.name("findFlights")).click();

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
