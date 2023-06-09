package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	static WebElement ele = null;
	
	//static method
	public static WebElement txtusername(WebDriver driver) {
		return ele = driver.findElement(By.name("email"));
		
	}

	public static WebElement txtpassword(WebDriver driver) {
		return ele = driver.findElement(By.name("password"));
		
	}
	
	public static WebElement btnLogin(WebDriver driver) {
		return ele = driver.findElement(By.xpath("//*[@id=\'content\']/div/div[2]/div/form/input"));
	}
}
