package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.PageUtility;
import utility.RandomUtility;

public class AdminUsersPage {

	public WebDriver driver;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

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

	public AdminUsersPage clickonAdminUserMoreInfoIcon() {
		adminMoreInfoIcon.click();
		return this;
	}

	public AdminUsersPage clickonNewIcon() {
		newIconElement.click();
		return this;
	}

	public AdminUsersPage enterNewUserName() {
		RandomUtility randomutility = new RandomUtility();
		String randomUserName1 = randomutility.createaRandomName();
		newUserNameElement.sendKeys(randomUserName1);
		return this;
	}

	public AdminUsersPage enterNewPassword() {
		RandomUtility randomutility = new RandomUtility();
		String randomPassword1 = randomutility.createaRandomPassword();
		newPasswordElement.sendKeys(randomPassword1);
		return this;
	}

	public AdminUsersPage selectDropdown() {
		PageUtility pagautility = new PageUtility();
		pagautility.selectClickByVisibleText(dropDownElement, "Partner");
		return this;
	}

	public AdminUsersPage clickonSaveButton() {
		saveField.click();
		return this;
	}

	public String alertAvailable() {
		String text = alertSuccess.getText();
		String alertTextIs = text.substring(9);
		return alertTextIs;
	}

	public boolean alertSuccessDisplayed() {
		boolean isAlertSuccessDisplayed = alertSuccess.isDisplayed();
		return isAlertSuccessDisplayed;
	}

}
