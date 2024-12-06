package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.ContactUsPage;
import utility.ExcelUtility;

public class ContactUsTest extends Base {
	@Test
	public void verifyWhetherUsercanAddAddressEmailandPhoneNumbertoContactUsInformations() {
		String userName = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		ContactUsPage contactuspage = new ContactUsPage(driver);
		contactuspage.enterUserNameOnUserNameField(userName);
		contactuspage.enterPasswordOnPasswordField(password);
		contactuspage.clickonSigninButton();
		contactuspage.clickonManageContactMoreInfoButton();
		contactuspage.clickonActionIcon();
		contactuspage.phoneField();
		contactuspage.emailField();
		contactuspage.addressField();
		contactuspage.deliveryTimeField();
		contactuspage.deliveryChargeLimitField();
		contactuspage.scrollDown();
		contactuspage.clickonUpdateIcon();
		boolean isContactUpdatedSuccessfully = contactuspage.isAlertAvailable();
		Assert.assertTrue(isContactUpdatedSuccessfully, "Contact Updation Failed");

	}

}
