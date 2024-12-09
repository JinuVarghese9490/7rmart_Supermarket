package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManageContactPage;
import utility.ExcelUtility;

public class ManageContactTest extends Base {
	@Test(description="This is for adding user details such as address,email and mobile number",retryAnalyzer=retry.Retry.class)
	public void verifyWhetherUsercanAddAddressEmailandPhoneNumbertoContactUsInformations() {
		String userName = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password)
		.clickonSigninButton();
		ManageContactPage managecontactpage = new ManageContactPage(driver);
		managecontactpage.clickonManageContactMoreInfoButton().clickonActionIcon().phoneField().emailField()
		.addressField().deliveryTimeField().deliveryChargeLimitField().scrollDown().clickonUpdateIcon();
		boolean isContactUpdatedSuccessfully = managecontactpage.isAlertAvailable();
		Assert.assertTrue(isContactUpdatedSuccessfully, "Contact Updation Failed");

	}

}
