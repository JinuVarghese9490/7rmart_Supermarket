package testscript;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ManageNewsPage;
import utility.ExcelUtility;

public class ManageNewsTest {
	
	@Test(groups="smoke")
	
	public void verifyUsercanEnterNewNewsInformations(WebDriver driver)
	{
		String text="how old are you";
		String userName = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		ManageNewsPage managenewspage=new ManageNewsPage(driver);
		managenewspage.enterUserNameOnUserNameField(userName);
		managenewspage.enterPasswordOnPasswordField(password);
		managenewspage.clickonSigninButton();
		//managenewspage.clickonmanageNewsButton();
		managenewspage.manageNewsButton();
		managenewspage.clickNewButton();
		managenewspage.enterTheNews(text);
		managenewspage.clickOnSave();
		boolean isNavigatedToAlert=managenewspage.alerIstDisplayed();
		Assert.assertTrue(isNavigatedToAlert, "New news cannot be added");
		
		
		}

		
		
	}


