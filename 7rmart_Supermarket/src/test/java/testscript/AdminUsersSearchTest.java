package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersSearchPage;
import pages.LoginPage;
import utility.ExcelUtility;

public class AdminUsersSearchTest extends Base{
	
	@Test(description="This is for searching AdminUsers using username and usertype and get matching output",retryAnalyzer=retry.Retry.class)
	
	public void verifyWhetherUsercanSearchAdminUsersandGetMatchingResults()
	{
		String userName =ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1,1 , "LoginPage");
		String name=ExcelUtility.getString(8, 0, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password)
		.clickonSigninButton();
		
		AdminUsersSearchPage adminuserssearchpage = new AdminUsersSearchPage(driver);
		adminuserssearchpage.clickonAdminUserMoreInfoIcon().clickonSearchField().enterUserNameField(name)
		.selectUserTypeField().submitSearchButton().scrollDown();
		boolean isMatchingResultFound=adminuserssearchpage.activeStatusChecking();
		Assert.assertTrue(isMatchingResultFound,"Result Not Found");
	}

}
