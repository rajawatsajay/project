package com.ajay.AdvanceSelenium;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BookingTicket {
	private WebDriver driver;
	private int colnum = 2;
	private static int rownum = 1;
	private static Logger log = Logger.getLogger(BookingTicket.class.getSimpleName());

	@DataProvider(name = "loginData")
	public String[][] login_data() throws IOException {
		ExcelUtility.setExcelPath("Sheet1", "C:\\Users\\A06438_p5.training\\Desktop\\testdata\\Book1.xlsx");

		String[][] excelData = ExcelUtility.getExcelTable();
		return excelData;
	}

	@Test(priority = 1, dataProvider = "loginData")
	public void login(String userName, String password) throws IOException {
		try {
			log.info("Entering the user name");
			LoginPageObject.uname.sendKeys(userName);
			log.info("Entering the Password");
			LoginPageObject.password.sendKeys(password);
			log.info("Click on login");
			LoginPageObject.login_button.click();
			// WebDriverWait wait = new WebDriverWait(driver, 50);
			// wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("tripType")));
			// assertEquals("Find a Flight: Mercury Tours:", driver.getTitle());
			ExcelUtility.setExcelData(rownum, colnum, "pass");
			rownum++;
			driver.get("http://newtours.demoaut.com/");
			driver.manage().window().maximize();
		} catch (AssertionError e) {
			ExcelUtility.setExcelData(rownum, colnum, "fail");
		}

	}

	// @Test(priority = 2)
	// public void bookTicket() {
	// // driver.findElement(By.cssSelector(
	// // "body > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) >
	// // tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) >
	// tbody:nth-child(1) >
	// // tr:nth-child(4) > td:nth-child(1) > table:nth-child(1) >
	// tbody:nth-child(1) >
	// // tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) >
	// tbody:nth-child(1) >
	// // tr:nth-child(5) > td:nth-child(1) > form:nth-child(1) > table:nth-child(1)
	// >
	// // tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2) > b:nth-child(1) >
	// // font:nth-child(1) > input:nth-child(2)"))
	// // .click();
	// driver.findElement(By.cssSelector("input[value='oneway']")).click();
	// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	// Select s = new Select(driver.findElement(By.cssSelector(
	// "html body div table tbody tr td table tbody tr td table tbody tr td table
	// tbody tr td form table tbody tr td b select")));
	// s.selectByValue("3");
	// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	// Select s1 = new Select(driver.findElement(By.cssSelector(
	// "body > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) >
	// tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) >
	// tr:nth-child(4) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) >
	// tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) >
	// tr:nth-child(5) > td:nth-child(1) > form:nth-child(1) > table:nth-child(1) >
	// tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(2) >
	// select:nth-child(1)")));
	// s1.selectByValue("London");
	// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	// Select s2 = new Select(driver.findElement(By.cssSelector(
	// "body > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) >
	// tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) >
	// tr:nth-child(4) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) >
	// tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) >
	// tr:nth-child(5) > td:nth-child(1) > form:nth-child(1) > table:nth-child(1) >
	// tbody:nth-child(1) > tr:nth-child(5) > td:nth-child(2) >
	// select:nth-child(1)")));
	// s2.selectByValue("2");
	// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	// Select s3 = new Select(driver.findElement(By.cssSelector(
	// "body > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) >
	// tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) >
	// tr:nth-child(4) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) >
	// tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) >
	// tr:nth-child(5) > td:nth-child(1) > form:nth-child(1) > table:nth-child(1) >
	// tbody:nth-child(1) > tr:nth-child(5) > td:nth-child(2) >
	// select:nth-child(2)")));
	// s3.selectByValue("1");
	// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	// driver.findElement(By.cssSelector(
	// "body > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) >
	// tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) >
	// tr:nth-child(4) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) >
	// tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) >
	// tr:nth-child(5) > td:nth-child(1) > form:nth-child(1) > table:nth-child(1) >
	// tbody:nth-child(1) > tr:nth-child(9) > td:nth-child(2) > font:nth-child(1) >
	// font:nth-child(2) > input:nth-child(4)"));
	// Select s4 = new Select(driver.findElement(By.cssSelector(
	// "body > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) >
	// tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) >
	// tr:nth-child(4) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) >
	// tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) >
	// tr:nth-child(5) > td:nth-child(1) > form:nth-child(1) > table:nth-child(1) >
	// tbody:nth-child(1) > tr:nth-child(10) > td:nth-child(2) >
	// select:nth-child(1)")));
	// s4.selectByVisibleText("Blue Skies Airlines");
	// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	// driver.findElement(By.name("findFlights")).click();
	//
	// }

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\A06438_p5.training\\Downloads\\Selenium Drivers\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		PageFactory.initElements(driver, LoginPageObject.class);
		DOMConfigurator.configure("Log4g.xml");
	//	TakesScreenshot src=((TakesScreenshot)driver);
		
	}

	@AfterTest
	public void afterTest() {
	}
	

}
