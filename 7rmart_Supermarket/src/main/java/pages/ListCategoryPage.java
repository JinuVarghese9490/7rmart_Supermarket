package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utility.FileUploadUtility;
import utility.PageUtility;

public class ListCategoryPage {
	
	PageUtility pageutility=new PageUtility();
	public WebDriver driver;

	public ListCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@class='form-control' and @placeholder='Username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@class='form-control' and @placeholder='Password']")
	private WebElement passwordField;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	private WebElement signinButton;
	@FindBy(xpath = "//p[text()='Dashboard']")
	private WebElement loginSuccess;

	@FindBy(xpath = "(//i[@class='fas fa-arrow-circle-right'])[3]")
	private WebElement categoryMoreInfoIcon;
	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	private WebElement listCategoriesElement;
	@FindBy(xpath = "(//span[@class='badge bg-success'])[1]")
	private WebElement activeField;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertSuccess;
	@FindBy(xpath = "(//i[@class='fas fa-trash-alt'])[4]")
	private WebElement deleteIcon;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement deleteAlertIcon;
	@FindBy(xpath = "(//i[@class='fas fa-edit'])[1]")
	private WebElement editIcon;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement chooseFile;
	@FindBy(xpath = "//button[@name='update']")
	private WebElement updateImg;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement additionSuccessAlert;

	public void enterUserNameOnUserNameField(String userName) {
		userNameField.sendKeys(userName);
	}

	public void enterPasswordOnPasswordField(String password) {
		passwordField.sendKeys(password);
	}

	public void clickonSigninButton() {
		signinButton.click();
	}

	public boolean isDashboardAvailable() {
		boolean isHomepageAvailable = loginSuccess.isDisplayed();
		return isHomepageAvailable;
	}

	public void clickonCategoryMoreInfoButton() {
		categoryMoreInfoIcon.click();
	}

	public boolean isListCategoriesAvailable() {
		boolean iscategoriesListAvailable = listCategoriesElement.isDisplayed();
		return iscategoriesListAvailable;
	}

	public void clickonActiveField() {
		activeField.click();
	}

	public String alertStatusAvailable() {
		String text = alertSuccess.getText();
		String alertTextIs = text.substring(9);
		return alertTextIs;
	}

	public void clickonDeleteButton() {
		deleteIcon.click();
		driver.switchTo().alert().accept();
	}

	public String deleteAlertStatusAvailable() {
		String deleteText = deleteAlertIcon.getText();
		String deleleteAlertTextIs = deleteText.substring(9);
		return deleleteAlertTextIs;
	}

	public void clickonEditIcon() {
		editIcon.click();

	}

	public void scrollDown() {
		
		pageutility.javaScriptExecutorSample1(driver);
	}

	public void clickonChooseFile() {
		FileUploadUtility fileuploading = new FileUploadUtility();
		try {
			fileuploading.verifyFileUploadUsingRobotclass(chooseFile,Constants.TESTDATAPIC);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public void clickonUpdateIcon() {
		updateImg.click();

	}
	public boolean isAddingItemSuccefully() {
		boolean isAddingSuccessAlertDisplayed = additionSuccessAlert.isDisplayed();
		return isAddingSuccessAlertDisplayed;
	}

}
