package testscript;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utility.ExcelUtility;

public class LoginTest extends Base {
	@Test(description="This is for successful login",groups= {"smoke"},priority=1,retryAnalyzer=retry.Retry.class)

	public void verifyUserLoginWithValidUserNameAndPassword() {
		String userName =ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1,1 , "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password)
		.clickonSigninButton();
		boolean isNavigatedtoDasboard = loginpage.isDashboardAvailable();
		Assert.assertTrue(isNavigatedtoDasboard, "user is unable to login with valid credentials");
	}

	@Test(description="This is for invalid password",groups= {"regression"},priority=2,retryAnalyzer=retry.Retry.class)
	public void verifyUserLoginWithValidUserNameAndInvalidPassword() {

		String userName =ExcelUtility.getString(2, 0,"LoginPage");
		String password = ExcelUtility.getString(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName)
		.enterPasswordOnPasswordField(password).clickonSigninButton();
		boolean isNavigatedtoDasboard = loginpage.isDashboardAvailable();
		Assert.assertTrue(isNavigatedtoDasboard, "user is able to login with invalid credentials");
	}

	@Test(description="This is for invalid username",groups= {"smoke","regression"},retryAnalyzer=retry.Retry.class)
	
	 public void verifyUserLoginWithInvalidUserNameAndValidPassword() {
		String userName =ExcelUtility.getString(3, 0,"LoginPage");
		String password =ExcelUtility.getString(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password)
		.clickonSigninButton();
		boolean isNavigatedtoDasboard = loginpage.isDashboardAvailable();
		Assert.assertTrue(isNavigatedtoDasboard, "user is able to login with invalid credentials");

	}

	@Test(description="This is for unsuccessful Login",dataProvider="InvalidLoginData",retryAnalyzer=retry.Retry.class)
	public void verifyUserLoginWithInvalidUserNameAndPassword(String userName,String password) {
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password).clickonSigninButton();
		boolean isNavigatedtoDasboard = loginpage.isDashboardAvailable();
		Assert.assertTrue(isNavigatedtoDasboard, "user is able to login with invalid credentials");
	}
	@DataProvider(name="InvalidLoginData")
	public Object[][] getDatafromDataProvider()
	{
		return new Object[][] {
			new Object[] {ExcelUtility.getString(0, 1, "LoginPage"),ExcelUtility.getString(0, 1, "LoginPage")},
		new Object[] {"123","123"}
			
			
		};
	}

}
