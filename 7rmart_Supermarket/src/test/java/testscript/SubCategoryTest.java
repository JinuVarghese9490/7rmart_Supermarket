package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SubCategoryPage;
import utility.ExcelUtility;

public class SubCategoryTest extends Base {
	@Test(description="This is for adding an item with image to sub category list")

	public void verifyUserAbletoAddaNewItemtoTheSubCategoryList() {
		
		String userName =ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		SubCategoryPage subcategorypage = new SubCategoryPage(driver);
		subcategorypage.enterUserNameOnUserNameField(userName);
		subcategorypage.enterPasswordOnPasswordField(password);
		subcategorypage.clickonSigninButton();
        subcategorypage.clickonMoreInfoButton();
        
        subcategorypage.clickonEditButton();
        subcategorypage.dropDownSubCategory();
        subcategorypage.clickonChooseFile();
        subcategorypage.scrollDown();
        subcategorypage.clickonUpdateButton();
        boolean isSubcategoryCrestedSuccessfully = subcategorypage.isSuccessAlertAvailable();
		Assert.assertTrue(isSubcategoryCrestedSuccessfully, "Sub Category already exists");
	}

}
