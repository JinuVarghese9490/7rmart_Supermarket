package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ExcelUtility;
import utility.PageUtility;

public class AdminUsersSearchPage {
	
	public WebDriver driver;
	
	public AdminUsersSearchPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "(//i[@class='fas fa-arrow-circle-right'])[1]")
	private WebElement adminMoreInfoIcon;
	@FindBy(xpath = "(//a[@href='javascript:void(0)'])[2]")
	private WebElement searchField;
	@FindBy(xpath = "//input[@id='un']")
	private WebElement usernameField;
	@FindBy(xpath = "//select[@id='ut']")
	private WebElement userTypeField;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitSearch;
	@FindBy(xpath = "//span[@class='badge bg-success']")
	private WebElement statusCheck;
	
	
	public AdminUsersSearchPage clickonAdminUserMoreInfoIcon() {
		adminMoreInfoIcon.click();
		return this;
	}
	public AdminUsersSearchPage clickonSearchField() {
		searchField.click();
		return this;
	}

	public AdminUsersSearchPage enterUserNameField(String name) {
		usernameField.sendKeys(name);
		return this;
	}
	public AdminUsersSearchPage selectUserTypeField() {
		
		PageUtility pageutility=new PageUtility();
		pageutility.selectClickByValue(userTypeField,ExcelUtility.getString(9, 0, "LoginPage"));
		return this;
	}
    public AdminUsersSearchPage submitSearchButton() {
		
	submitSearch.click();
	return this;
	}
    
    public AdminUsersSearchPage scrollDown()
    {
    	PageUtility pageutility=new PageUtility();
    	pageutility.javaScriptExecutorSimpleScrollfromTopToBottom(driver);
    	return this;
    }
    
    public boolean activeStatusChecking()
    {
    	boolean isActiveIconDisplayed=statusCheck.isDisplayed();
    	return isActiveIconDisplayed;
    }
}
