package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Number;

import utility.PageUtility;
import utility.RandomUtility;

public class AdminUsersPage {

	RandomUtility randomutility=new RandomUtility();
	public WebDriver driver;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@class='form-control' and @placeholder='Username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@class='form-control' and @placeholder='Password']")
	private WebElement passwordField;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	private WebElement signinButton;

	@FindBy(xpath = "(//i[@class='fas fa-arrow-circle-right'])[1]")
	private WebElement adminMoreInfoIcon;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newIconElement;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement newUserNameElement;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement newPasswordElement;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement dropDownElement;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement saveField;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertSuccess;

	public void enterUserNameOnUserNameField(String userName) {
		userNameField.sendKeys(userName);
	}

	public void enterPasswordOnPasswordField(String password) {
		passwordField.sendKeys(password);
	}

	public void clickonSigninButton() {
		signinButton.click();
	}
	
	
	public void clickonAdminUserMoreInfoIcon() {
		adminMoreInfoIcon.click();
	}

	public void clickonNewIcon() {
		newIconElement.click();
	}
	
	public void enterNewUserName() {
		String randomUserName1=randomutility.createaRandomName();
		newUserNameElement.sendKeys(randomUserName1);
	}

	public void enterNewPassword() {
		String randomPassword1=randomutility.createaRandomPassword();
		newPasswordElement.sendKeys(randomPassword1);
	}

	public void selectDropdown() {
		PageUtility pagautility = new PageUtility();
		pagautility.selectClickByVisibleText(dropDownElement, "Partner");
	}

	public void clickonSaveButton() {
		saveField.click();
	}

	public String alertAvailable() {
		String text = alertSuccess.getText();
		String alertTextIs = text.substring(9);
		return alertTextIs;
	}

	public boolean alertSuccessDisplayed() {
		boolean isAlertSuccessDisplayed=alertSuccess.isDisplayed();
		return isAlertSuccessDisplayed;
	}

	




}
