package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.LoginPage;
import utility.ExcelUtility;

public class CategoryTest extends Base {
	@Test(description="This is for view the status and enter a new categories such as category name and "
			+ "uploading a file",retryAnalyzer=retry.Retry.class)

	public void veryfyUsercanViewStatusandAddnNewCategorytoListCategoryPage() {

		String userName =ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password).clickonSigninButton();
		CategoryPage categorypage = new CategoryPage(driver);
		categorypage.clickonCategoryMoreInfoButton().clickonEditIcon().enterCategoryField()
		.clickonSelectGroup().scrollDown().clickonChooseFile().scrollDown().clickonUpdateIcon();
		boolean isCategoryListUpdated=categorypage.isAddingItemSuccefully();
		Assert.assertTrue(isCategoryListUpdated, "Category updation failed");
		}
}//some error in site
