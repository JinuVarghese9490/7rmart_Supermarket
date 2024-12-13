package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminUsersPage;
import pages.LoginPage;
import utility.ExcelUtility;

public class AdminUsersTest extends Base {
	LoginPage loginpage;
	AdminUsersPage adminuserspage;

	@Test(description = "This is for add a new user name and password")

	public void verifyWhethertheUsercanAddaNewUsernameandPasswordtotheAdminUsersList() {

		String userName = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		loginpage = new LoginPage(driver);
		adminuserspage = loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password)
				.clickonSigninButton().clickonAdminUserMoreInfoIcon().clickonNewIcon().clickonNewIcon()
				.enterNewUserName().enterNewPassword().selectDropdown().clickonSaveButton();
		String alertMessageIs = adminuserspage.alertAvailable();
		boolean isAlertSuccessAvailabe = adminuserspage.alertSuccessDisplayed();
		Assert.assertTrue(isAlertSuccessAvailabe, "User Cannot Add New Username and Password");
	}

}
