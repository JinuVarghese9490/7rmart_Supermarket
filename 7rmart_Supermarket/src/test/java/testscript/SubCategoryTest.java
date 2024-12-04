package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SubCategoryPage;
import utility.ExcelUtility;

public class SubCategoryTest extends Base {
	@Test

	public void verifyUserAbletoAddaNewItemtoTheSubCategoryList() {
		
		String userName =ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String subCategoryName =ExcelUtility.getString(5, 0, "LoginPage");
		SubCategoryPage subcategorypage = new SubCategoryPage(driver);
		subcategorypage.enterUserNameOnUserNameField(userName);
		subcategorypage.enterPasswordOnPasswordField(password);
		subcategorypage.clickonSigninButton();
        subcategorypage.clickonMoreInfoButton();
        
        subcategorypage.clickonEditButton();
        subcategorypage.dropDownSubCategory();
        subcategorypage.clickonChooseFile();
        subcategorypage.clickonUpdateButton();
       
        subcategorypage.clickonSearchButton();
        subcategorypage.selectDropdown();
		subcategorypage.enterSubCategoryonSubCategoryField(subCategoryName);
		subcategorypage.submitonSearchButton();
        boolean isActiveIconDisplayed = subcategorypage.isResultAvailable();
		Assert.assertTrue(isActiveIconDisplayed, "unable to search in Search List Sub Categories");
	}

}
