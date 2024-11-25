package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.ProductPage;

public class step extends BaseClass{

	public WebDriver driver;
	
	@Before
	public void setup() throws IOException
	{
		p = new Properties();
		FileInputStream file= new FileInputStream("D:\\pavan\\OpencartWithCucumber\\src\\test\\resources\\config.properties");
		p.load(file);
		String br = p.getProperty("browser");
		switch(br.toLowerCase())
		{
		case	"chrome" : 	driver = new ChromeDriver();break;
		case	"firefox":  driver	= new FirefoxDriver();break;
		case	"edge"	 :  driver = new EdgeDriver();break;
		default:	System.out.println("Invalid Browser..");return;
		}
		logger = LogManager.getLogger(step.class.getName());
		logger.info("******Open the Browser*****");
		
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
	    driver.manage().window().maximize();
	}
	
	@Given("open the url in browser")
	public void open_the_url_in_browser() {
		
		
	    logger.info("******created Objects*****");
	    hp = new HomePage(driver);
	    lp = new LoginPage(driver);
	    myact = new MyAccountPage(driver);
	    pr = new ProductPage(driver);
	}
	
	
	@And("Enter the email id {string}")
	public void enter_the_email_id(String emailid) {

		logger.info("*****Entered the Email ID*******");
		
	    hp.clickMyAccount();
	    hp.clickLogin();
	    lp.setEmail(emailid);
	}

	@Then("Enter the password {string}")
	public void enter_the_password(String password) {
		logger.info("*****Entered the password*******");
	    lp.setPassword(password);
	}


	@Then("click on the login button")
	public void click_on_the_login_button() {
		logger.info("*****Clicked Login*******");
		 lp.clickLogin();
	}

	@Then("check the my account page is displayed or not")
	public void check_the_my_account_page_is_displayed_or_not() {
		
		logger.debug("*****Validation*******");
		
	   if( myact.account()==true)
	   {
		   Assert.assertTrue(true);
	   }
	   
	   else {
		   Assert.assertTrue(false);
	   }
	}

	@And("close the browser")
	public void close_the_browser() {
	   driver.quit();
	}
	
	
	//Add product to the cart
	@Then("click on the product tablet")
	public void click_on_the_product_tablet() {
		pr.clickOnTablet();
	}

	@Then("click Add to cart")
	public void click_add_to_cart() {
	    pr.addToCart();
	}

	@Then("chck the product add confirmation")
	public void chck_the_product_add_confirmation() {
	   if(pr.cnfMessage()==true)
	   {
		   Assert.assertTrue(true);
	   }
	   else
	   {
		   Assert.assertTrue(false);
	   }
	}
	

}
