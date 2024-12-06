package testscript;

import org.openqa.selenium.WebDriver;

import pages.NewsPage;
import utility.ExcelUtility;

public class NewsTest {

	
	

	public void updateNews(WebDriver driver) {
		
		String userName = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		NewsPage newspage=new NewsPage(driver);
		newspage.enterUserNameOnUserNameField(userName);
		newspage.enterPasswordOnPasswordField(password);
		newspage.clickonSigninButton();
		
		
	}
}
