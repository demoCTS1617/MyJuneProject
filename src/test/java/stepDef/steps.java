package stepDef;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
//import PageObjectPF.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class steps {
	WebDriver driver;
	MyAccountPage myac;
	
	LoginPage lp;//= new LoginPage(driver);;
	Logger logger; //for logging
	//String url = "https://tutorialsninja.com/demo/";

	//Hooks
	@Before
	public void setup() {
		//for logging
        logger= LogManager.getLogger(this.getClass());
	}
	
	@After
	public void teardown() {
		//Screenshot
	}
	
	@Given("User Launch browser")
	public void user_launch_browser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		logger.info("Browser is launched....");
	}

	@And("opens URL {string}")
	public void opens_url(String url) {
		driver.get(url);
		logger.info("Application is launched...."+url);
	}

	@When("User navigate to MyAccount menu")
	public void user_navigate_to_my_account_menu() {
		driver.findElement(By.xpath("//*[@id=\'top-links\']/ul/li[2]/a/span[1]")).click();

	}

	@And("click on Login")
	public void click_on_login() {
		driver.findElement(By.linkText("Login")).click();
		logger.info("Clicked on Login button........");
	}

	@And("User enters Email as {string} and Password as {string}")
	public void email_and_password(String email,String pwd) {
		//driver.findElement(By.name("email")).sendKeys(email);
		//driver.findElement(By.name("password")).sendKeys(pwd);
		lp.txtusername(driver).sendKeys(email);
		lp.txtpassword(driver).sendKeys(pwd);
		logger.info("Entered email and password...");
	}

	@And("Click on Login button")
	public void click_on_login_button() {
		//driver.findElement(By.xpath("//*[@id=\'content\']/div/div[2]/div/form/input")).click();
	    lp.btnLogin(driver).click();
	    logger.info("Clicked on Login button........");
	}

	@Then("User navigates to MyAccount Page")
	public void user_navigates_to_my_account_page() throws IOException {
		System.out.println("It opens welcome screen....");
		myac=new MyAccountPage(driver);
		boolean targetpage=myac.isMyAccountPageExists();
	
        if(targetpage)
        {
            //logger.info("Login Success ");
            Assert.assertTrue(true);
            logger.info("Welcome to MyAccountPage........");
        }
        else
        {
            //logger.error("Login Failed ");
        	//take a screenshot
        	 File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
             FileUtils.copyFile(screenshotFile, new File("C:\\Users\\NileshW2\\WSseleniumJava_April23\\MyJuneProject\\Snapshot\\Error.jpg"));
        	 Assert.assertTrue(false);
            logger.error("Failed");
        }

		driver.close();
		logger.info("Browser closed........");
	}

}
