package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ListCategoryPage;
import utility.ExcelUtility;

public class ListCategoryTest extends Base {
	@Test

	public void veryfyUserViewandEditListCategoryPage() {

		String userName =ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		ListCategoryPage listcategorypage = new ListCategoryPage(driver);
        listcategorypage.enterUserNameOnUserNameField(userName);
		listcategorypage.enterPasswordOnPasswordField(password);
		listcategorypage.clickonSigninButton();
		listcategorypage.clickonCategoryMoreInfoButton();
		listcategorypage.clickonActiveField();
		listcategorypage.clickonDeleteButton();
		String deleteAlert = listcategorypage.deleteAlertStatusAvailable();
		listcategorypage.clickonEditIcon();
		listcategorypage.scrollDown();
		listcategorypage.clickonChooseFile();
		listcategorypage.clickonUpdateIcon();
		String alertStatus = listcategorypage.alertStatusAvailable();
		boolean isCategoryListUpdated=listcategorypage.isAddingItemSuccefully();
		Assert.assertTrue(isCategoryListUpdated, "Category updation failed");

	}
}
