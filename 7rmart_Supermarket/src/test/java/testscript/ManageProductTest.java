package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageProductPage;
import utility.ExcelUtility;

public class ManageProductTest extends Base {
	
	@Test(description="This is for getting all table headlins and check if the product is present or not"
			,retryAnalyzer=retry.Retry.class)
	
	
	public void verifyTheTableinManageProductPage() {
		
		String userName =ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1,1 , "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password)
		.clickonSigninButton();
		ManageProductPage manageproductpage=new ManageProductPage(driver);
        manageproductpage.scrollDown().clickonMoreInfoButton().getTableHeadings().getElementFromTableColumn();
		boolean isElementPresent=manageproductpage.getElementFromTableColumn();
		Assert.assertTrue(isElementPresent, "No Such a Product");
	}

}
