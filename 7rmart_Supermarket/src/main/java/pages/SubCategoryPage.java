package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utility.FileUploadUtility;
import utility.PageUtility;
import utility.RandomUtility;
import utility.WaitUtility;

public class SubCategoryPage {
	public WebDriver driver;

	public SubCategoryPage(WebDriver driver) {
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

	@FindBy(xpath = "(//i[@class='fas fa-arrow-circle-right'])[4]")
	private WebElement moreInfoIcon;
	@FindBy(xpath = "//h1[text()='List Sub Categories']")
	private WebElement listSubCategoriesElement;
	@FindBy(xpath = "(//i[@class='fas fa-edit'])[2]")
	private WebElement editElement;
	@FindBy(id = "cat_id")
	private WebElement dropDownSub;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement chooseFileElement;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement updateElement;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alerSuccess;

	public void enterUserNameOnUserNameField(String userName) {
		userNameField.sendKeys(userName);
	}

	public void enterPasswordOnPasswordField(String password) {
		passwordField.sendKeys(password);
	}

	public void clickonSigninButton() {
		signinButton.click();
	}

	public void clickonMoreInfoButton() {
		moreInfoIcon.click();
	}

	public boolean islistSubCategoriesAvailable() {
		boolean isSubCategoryListAvailable = listSubCategoriesElement.isDisplayed();
		return isSubCategoryListAvailable;
	}

	public void clickonEditButton() {
		editElement.click();
	}

	public void dropDownSubCategory() {
		PageUtility pagautility = new PageUtility();
		pagautility.selectClickByIndex(dropDownSub, 1);

	}

	public void clickonChooseFile() {
		FileUploadUtility fileuploadutility = new FileUploadUtility();
		fileuploadutility.verifyFileUploadusingSendKeys(chooseFileElement, Constants.TESTDATAPIC);
	}

	public void scrollDown() {
		PageUtility pageutility = new PageUtility();
		pageutility.javaScriptExecutorSample1(driver);

	}

	public void clickonUpdateButton() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElement2(driver, updateElement);
		updateElement.click();
	}

	public boolean isSuccessAlertAvailable() {
		boolean isAlerttDisplayed = alerSuccess.isDisplayed();
		return isAlerttDisplayed;
	}

}
