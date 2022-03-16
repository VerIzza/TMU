package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Maping;

public class Steps {
	String driverPath = "src/test/resources/chromedriver";
	public String baseUrl = "https://demoqa.com/";
	public WebDriver driver = new ChromeDriver();
	Maping map = new Maping(this.driver);

	@BeforeMethod
	private void startDriver() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}

	@Test
	public void testMethod() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		this.map.bookStoreApp.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
		this.map.webTables.click();
		wait.until(ExpectedConditions.visibilityOf(map.table));
		Assert.assertEquals(map.tableNamElement.getText(), "First Name");
		this.map.rowsFive.click();

	}

	@AfterMethod
	public void terminateBrowser() {
		driver.quit();
	}

}