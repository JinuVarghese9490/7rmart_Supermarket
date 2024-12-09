package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utility.ExcelUtility;

public class ManageNewsTest extends Base{
	
	@Test(groups="smoke",description="This for updaing new news informations",retryAnalyzer=retry.Retry.class)
	
	public void verifyUsercanEnterNewNewsInformations()
	{
		
		String userName = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password)
		.clickonSigninButton();
		ManageNewsPage managenewspage=new ManageNewsPage(driver);
		managenewspage.clickOnManageNewsButton().clickNewButton().enterTheNews().clickOnSave();
		boolean isNewsCreatedSuccessfully=managenewspage.isalertAvailable();
		Assert.assertTrue(isNewsCreatedSuccessfully, "NewsUpdated Failed");
	}
}


