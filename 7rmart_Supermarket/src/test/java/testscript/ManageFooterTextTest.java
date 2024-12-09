package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooterTextPage;
import utility.ExcelUtility;

public class ManageFooterTextTest extends Base{
	
	@Test(description="This is for adding Address,email and phonenumber to Footer text Information",retryAnalyzer=retry.Retry.class)
	
	
public void verifyUsercanUpdateFooterTextInformationbyEnteringAddressEmailandPhoneNumber() {
		
		String userName =ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1,1 , "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password)
		.clickonSigninButton();
		ManageFooterTextPage managefootertextpage=new ManageFooterTextPage(driver);
		managefootertextpage.scrollDown().clickonMoreInfoButton().clickonEditIcon().enterAddressonAddressField()
		.entereEmailonEmailField().entereNumberonPhoneNumberField().scrollDown().clickonSubmitButton();
		boolean isFooterTextUpdatedSuccessfully=managefootertextpage.isAlertavailable();
		Assert.assertTrue(isFooterTextUpdatedSuccessfully, "Footer Text Updation Failed");
		}
}