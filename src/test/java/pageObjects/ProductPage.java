package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

	WebDriver driver;
	public ProductPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[normalize-space()=\"Tablets\"]")
	WebElement lnkTablets;
	
	@FindBy(xpath="//span[normalize-space()=\"Add to Cart\"]")
	WebElement lnkaddTocart;
	
	
	@FindBy(xpath="//div[@class=\"alert alert-success alert-dismissible\"]")
	WebElement confirmation;
	
	
	public void clickOnTablet()
	{
		lnkTablets.click();
	}
	
	public void addToCart()
	{
		lnkaddTocart.click();
	}
	
	public boolean cnfMessage()
	{
		try {
		return(confirmation.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
}
