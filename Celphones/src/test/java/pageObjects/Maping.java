package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Maping {

	//WebDriver driver;
	public Maping(WebDriver driver) {
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//evita andar buscando en otro momento los siguientes elementos, 
	//hace un mapeo de estos
	
	@FindBy(xpath = "//a[@id='itemc' and contains(text(),'Phones')]")
	public WebElement phonesCat;
	@FindBy(xpath = "//div[1]/div/div/h4/a")
	public WebElement phoneItem1;
	@FindBy(xpath = "//div[2]/div/div/h4/a")
	public WebElement phoneItem2;
	@FindBy(xpath = "//div[3]/div/div/h4/a")
	public WebElement phoneItem3;
	@FindBy(xpath = "//html/body/div[5]/div/div[2]/div[2]/div/a")
	public WebElement addCartBtn;
	@FindBy(xpath = "//div/ul/li[4]/a")
	public WebElement cartTag;
	//@FindBy(xpath = "/html/body/div[10]/h2")
	//public WebElement addMessag;
	@FindBy(xpath = "//button[@type='button' and contains(text(),'Place Order')]")
	public WebElement placeOrder;
	@FindBy(xpath = "//form//div//input[@id='name']")
	public WebElement orderName;
	@FindBy(xpath = "//form//div//input[@id='card']")
	public WebElement orderCard;
	@FindBy(xpath = "//div[3]/button[@type='button' and contains(text(),'Purchase') ]")
	public WebElement purchaseBtn;
	@FindBy(xpath = "//div[10]/div[7]/div/button[contains(text(),'OK')]")
	public WebElement okConfirmBtn;
	
}
