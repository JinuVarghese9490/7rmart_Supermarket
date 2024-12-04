package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utility.ExcelUtility;

public class LoginTest extends Base {
	@Test

	public void verifyUserLoginWithValidUserNameAndPassword() {
		String userName =ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickonSigninButton();
		boolean isNavigatedtoDasboard = loginpage.isDashboardAvailable();
		Assert.assertTrue(isNavigatedtoDasboard, "user is unable to login with valid credentials");
	}

	@Test
	public void verifyUserLoginWithValidUserNameAndInvalidPassword() {

		String userName =ExcelUtility.getString(2, 0,"LoginPage");
		String password = ExcelUtility.getString(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickonSigninButton();
		boolean isNavigatedtoDasboard = loginpage.isDashboardAvailable();
		Assert.assertTrue(isNavigatedtoDasboard, "user is able to login with invalid credentials");
	}

	@Test
	
	 public void verifyUserLoginWithInvalidUserNameAndValidPassword() {
		String userName =ExcelUtility.getString(3, 0,"LoginPage");
		String password =ExcelUtility.getString(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickonSigninButton();
		boolean isNavigatedtoDasboard = loginpage.isDashboardAvailable();
		Assert.assertTrue(isNavigatedtoDasboard, "user is able to login with invalid credentials");

	}

	@Test
	public void verifyUserLoginWithInvalidUserNameAndPassword() {
		String userName =ExcelUtility.getString(4, 0, "LoginPage");
		String password =ExcelUtility.getString(4, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickonSigninButton();
		boolean isNavigatedtoDasboard = loginpage.isDashboardAvailable();
		Assert.assertTrue(isNavigatedtoDasboard, "user is able to login with invalid credentials");
	}

}
