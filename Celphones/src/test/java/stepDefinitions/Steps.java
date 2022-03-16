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
	String driverPath = "src/test/resources/driver/chromedriver";
	public WebDriver driver;
	public String baseUrl = "https://www.demoblaze.com/index.html";
	Maping map;

	@BeforeMethod
	private void startDriver() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", driverPath);
		// setear browser en primer param chrome driver, 2o param direccion de resources
		// driver
		// ChromeDriverService service = ChromeDriverService.createDefaultService();
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}

	@Test
	public void testMethod() throws InterruptedException {
		this.map = new Maping(this.driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
				
		this.map.phonesCat.click();
		wait.until(ExpectedConditions.visibilityOf(map.phoneItem1));
		Assert.assertEquals(map.phoneItem1.getText(), "Samsung galaxy s6");
		this.map.phoneItem1.click();
		wait.until(ExpectedConditions.visibilityOf(map.addCartBtn));
		this.map.addCartBtn.click();
		this.map.cartTag.click();
		this.map.placeOrder.click();
		wait.until(ExpectedConditions.visibilityOf(map.orderName));
		this.map.orderName.sendKeys("Vero");
		this.map.orderCard.sendKeys("123456789");
		this.map.purchaseBtn.click();
		wait.until(ExpectedConditions.visibilityOf(map.okConfirmBtn));
		assert(map.okConfirmBtn.isDisplayed());
		this.map.okConfirmBtn.click();
	}

	@AfterMethod
	public void terminateBrowser() {
		driver.quit();
	}

}