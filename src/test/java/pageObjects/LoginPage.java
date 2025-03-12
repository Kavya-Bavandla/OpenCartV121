package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	@FindBy(xpath="//input[@placeholder='E-Mail Address']") WebElement txtEmailAddress;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement txtPassword;
	@FindBy(xpath="//input[@value ='Login']") WebElement btnLogin;
	
	
	public void setemail(String email)
	{
		txtEmailAddress.sendKeys(email);
	}
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	public void clickLogin()
	{
		btnLogin.click();
	}
}
