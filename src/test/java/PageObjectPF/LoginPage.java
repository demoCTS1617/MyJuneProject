package PageObjectPF;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Base {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "email")
	WebElement txtEmailAddress;

	@FindBy(name = "password")
	WebElement txtPassword;

	@FindBy(xpath = "/*[@id=\\'content\\']/div/div[2]/div/form/input")
	WebElement btnLogin;


	public void setEmail(String email1) {
		txtEmailAddress.sendKeys(email1);
	}

	public void setPassword(String pwd1) {
		txtPassword.sendKeys(pwd1);
	}

	public void clickLogin() {
		btnLogin.click();
	}

	

}
