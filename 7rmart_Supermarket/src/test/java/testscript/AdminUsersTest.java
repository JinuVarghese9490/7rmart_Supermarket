package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminUsersPage;
import utility.ExcelUtility;

public class AdminUsersTest extends Base {
	@Test

	public void verifyWhethertheUsercanAddaNewUsernameandPasswordtotheAdminUsersList() {

		String userName =ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		AdminUsersPage adminuserspage = new AdminUsersPage(driver);
		adminuserspage.enterUserNameOnUserNameField(userName);
		adminuserspage.enterPasswordOnPasswordField(password);
		adminuserspage.clickonSigninButton();
		adminuserspage.clickonAdminUserMoreInfoIcon();
		adminuserspage.clickonNewIcon();
		
		adminuserspage.enterNewUserName();
		adminuserspage.enterNewPassword();
		adminuserspage.selectDropdown();
		adminuserspage.clickonSaveButton();
		String alertMessageIs = adminuserspage.alertAvailable();
		boolean isAlertSuccessAvailabe=adminuserspage.alertSuccessDisplayed();
		Assert.assertTrue(isAlertSuccessAvailabe,"User Cannot Add New Username and Password");
	}

}
