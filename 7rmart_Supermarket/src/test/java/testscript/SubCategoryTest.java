package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SubCategoryPage;
import utility.ExcelUtility;

public class SubCategoryTest extends Base {
	@Test(description="This is for adding category and sub category with image to sub category list"
			,retryAnalyzer=retry.Retry.class)

	public void verifyUserAbletoAddaNewItemtoTheSubCategoryList() {
		
		String userName =ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password)
		.clickonSigninButton();
		SubCategoryPage subcategorypage = new SubCategoryPage(driver);
        subcategorypage.clickonMoreInfoButton().clickonEditButton().dropDownSubCategory().enterSubCategoryField()
		.clickonChooseFile().scrollDown().clickonUpdateButton();
        boolean isSubcategoryCrestedSuccessfully = subcategorypage.isSuccessAlertAvailable();
		Assert.assertTrue(isSubcategoryCrestedSuccessfully, "Sub Category updation Failed");
	}

}
