package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups={"Regression", "Master"})
	void verify_Account_Regis() {

		logger.info("***** Starting TC001_AccountRegistrationTest  ****");
		logger.debug("This is a debug log message");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount Link.. ");

			hp.clickRegister();
			logger.info("Clicked on Register Link.. ");

			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

			logger.info("Providing customer details...");
			regpage.setFirstName(randomeString().toUpperCase());
			regpage.setLastName(randomeString().toUpperCase());
			regpage.setemail(randomeString() + "@gmail.com");// randomly generated the email
			regpage.settelephone(randomeNumber());

			String password = randomeAlphaNumberic();

			regpage.setpassword(password);
			regpage.setcpassword(password);

			regpage.checkp();
			regpage.submit();

			logger.info("Validating expected message..");

			String confmsg = regpage.getsuccessmsg();
			if(confmsg.equals("Your Account Has Been Created!"))
			{
				Assert.assertTrue(true);
			}
			else
			{
				logger.info("test failed");
				logger.debug("debug logs");
				Assert.assertTrue(false);
			}

			
		} 
		catch (Exception e) 
		{
			Assert.fail();
		} 
		finally {
			logger.info("***** Finished TC001_AccountRegistrationTest *****");

		}
	}

}
