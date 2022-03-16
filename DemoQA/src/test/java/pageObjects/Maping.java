package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Maping {

	//WebDriver driver;
	public Maping(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//evita andar buscando en otro momento los siguientes elementos, 
	//hace un mapeo de estos
	
	@FindBy(xpath = "//h5[contains(text(),'Book Store Application')]")
	public WebElement bookStoreApp;
	@FindBy(xpath = "//span[@class=\"text\" and contains(text(),'Web Tables')]")
	public WebElement webTables;
	@FindBy(xpath = "//div[@class='ReactTable -striped -highlight']")
	public WebElement table;
	@FindBy(xpath = "//div[contains(text(),'First Name')]")
	public WebElement tableNamElement;
	@FindBy(xpath = "//span[2]/select/option[1]")
	public WebElement rowsFive;	
	
}
