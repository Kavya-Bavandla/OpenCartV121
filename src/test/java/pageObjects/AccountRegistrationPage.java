package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage{
	
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txtFirstname;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txtLastname;
	@FindBy(xpath="//input[@id='input-email']") WebElement txtEmail;
	@FindBy(xpath="//input[@placeholder='Telephone']") WebElement txttelephone;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtpassword;
	@FindBy(xpath="//input[@placeholder='Password Confirm']") WebElement txtconfpassword;
	@FindBy(xpath="//input[@name='agree']") WebElement chkpolicy;
	@FindBy(xpath="//input[@value = 'Continue']") WebElement butnsubmit;
	@FindBy(xpath="//div[@id='content']//h1") WebElement successmsg;
	
	public void setFirstName(String fname)
	{
		txtFirstname.sendKeys(fname);
	}
	public void setLastName(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	public void setemail(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void settelephone(String tele)
	{
		txttelephone.sendKeys(tele);
	}
	public void setpassword(String pass)
	{
		txtpassword.sendKeys(pass);
	}
	public void setcpassword(String cpass)
	{
		txtconfpassword.sendKeys(cpass);
		
	}
	public void checkp()
	{
		chkpolicy.click();
	}
	public void submit()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",butnsubmit);
	}
	
	
	//validation
	public String getsuccessmsg() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement successElement = wait.until(ExpectedConditions.visibilityOf(successmsg));
	        return (successElement.getText());
	    } catch (Exception e) {
	        System.out.println("Success message not found!");
	        return null;
	    }
	}



	
	
}
