package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ListCategoryPage;
import utility.ExcelUtility;

public class ListCategoryTest extends Base {
	@Test(description="This is for view the status and enter a new categories such as category name and uploadin a file")

	public void veryfyUsercanViewStatusandAddnNewCategorytoListCategoryPage() {

		String userName =ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		ListCategoryPage listcategorypage = new ListCategoryPage(driver);
        listcategorypage.enterUserNameOnUserNameField(userName);
		listcategorypage.enterPasswordOnPasswordField(password);
		listcategorypage.clickonSigninButton();
		listcategorypage.clickonCategoryMoreInfoButton();
		listcategorypage.clickonActiveField();
		listcategorypage.clickonEditIcon();
		listcategorypage.scrollDown();
		listcategorypage.clickonChooseFile();
		listcategorypage.clickonUpdateIcon();
		boolean isCategoryListUpdated=listcategorypage.isAddingItemSuccefully();
		Assert.assertTrue(isCategoryListUpdated, "Category updation failed");

	}
}
