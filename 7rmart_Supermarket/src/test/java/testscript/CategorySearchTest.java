package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CategorysearchPage;
import pages.LoginPage;
import utility.ExcelUtility;

public class CategorySearchTest extends Base {
	
	@Test(description="This is for searching a cateogory in List Categories and give matching results",
			retryAnalyzer=retry.Retry.class)
	
	
	public void veryfyUsercanSearchACategoryinListCategoryPage()
	{
		
		String userName =ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
	    String name=ExcelUtility.getString(10, 0, "LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password).clickonSigninButton();
		
		CategorysearchPage categorysearchpage=new CategorysearchPage(driver);
		categorysearchpage.clickonCategoryMoreInfoButton().clickonSearchField()
		.enterCategoryNameOnCategoryField(name)
		.clickonSubmitButton().scrollDown();
	    boolean isMatchinDataFound=	categorysearchpage.isCategoryPresent();
		Assert.assertTrue(isMatchinDataFound, "No Matchingdata Found");
		
	}

}
