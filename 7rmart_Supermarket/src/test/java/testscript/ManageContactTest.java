package testscript;

import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.ManageContactPage;
import utility.ExcelUtility;

public class ManageContactTest extends Base
{
	@Test
	public void verifyWhetherUsercanAddAddressEmailandPhoneNumbertoContactUsInformations()
	{
		String userName =ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		ManageContactPage managecontactpage = new ManageContactPage(driver);
		managecontactpage.enterUserNameOnUserNameField(userName);
		managecontactpage.enterPasswordOnPasswordField(password);
		managecontactpage.clickonSigninButton();
		managecontactpage.clickonManageContactMoreInfoButton();
		
		
		
		
		}

}
