package stepDefinitions;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import pageObjects.Mapping;

public class Steps {
	
	String driverPath = "src/test/resources/chromedriver";
	public WebDriver driver;
	public String baseUrl = "https://www.phptravels.net/";
	Mapping map;

	@BeforeMethod
	private void startDriver(){
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		map = new Mapping(this.driver);
		driver.get(baseUrl);
		driver.manage().window().maximize();
		}
	
	@Test
	public void testMethod() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 10);
				
		this.map.flightTab.click();
		
		wait.until(ExpectedConditions.visibilityOf(map.roundRadio));
		assert(map.roundRadio.isDisplayed());
		this.map.roundRadio.click();
		
		this.map.flyghtTypeDD.click();
		wait.until(ExpectedConditions.visibilityOf(map.departureDateField));
		this.map.flyingFromIn.sendKeys("MTY");
		this.map.destinationIn.sendKeys("CUN");
		
		//todays date
		ZoneId zoneId = ZoneId.systemDefault();
		LocalDate today = LocalDate.now(zoneId);
		
		this.map.dateLeftForm.clear();
		this.map.dateLeftForm.sendKeys(today.toString());
		
		//ten days
		LocalDate tenDays = today.plusDays(10);
		this.map.dateReturnForm.clear();
		this.map.dateReturnForm.sendKeys(tenDays.toString());
		
		this.map.passengers.click();
		this.map.adultQt.clear();
		this.map.adultQt.sendKeys("3");
		this.map.childQt.clear();
		this.map.childQt.sendKeys("3");
		
		this.map.searchBtn.click();
		wait.until(ExpectedConditions.visibilityOf(map.result));
	}
	
	@AfterMethod
	public void terminateBrowser() {
		driver.quit();
	}
	
	
}
