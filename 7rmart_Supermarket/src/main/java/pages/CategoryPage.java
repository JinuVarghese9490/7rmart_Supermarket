package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utility.FileUploadUtility;
import utility.PageUtility;
import utility.RandomUtility;

public class CategoryPage {

	public WebDriver driver;

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//i[@class='fas fa-arrow-circle-right'])[3]")
	private WebElement categoryMoreInfoIcon;
	@FindBy(xpath = "(//i[@class='fas fa-edit'])[1]")
	private WebElement editIcon;
	@FindBy(xpath = "//input[@id='category']")
	private WebElement categoryField;
	@FindBy(xpath = "//ul[@class='ms-list']")
	private WebElement selectGroups;
	@FindBy(xpath = "//input[@type='file']") //// input[@id='main_img']
	private WebElement chooseFile;
	@FindBy(xpath = "//button[@class='btn btn-danger']") // button[@type='submit']
	private WebElement updateImg;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement additionSuccessAlert;

	public CategoryPage clickonCategoryMoreInfoButton() {
		categoryMoreInfoIcon.click();
		return this;
	}

	public CategoryPage clickonEditIcon() {
		editIcon.click();
		return this;

	}

	public CategoryPage enterCategoryField() {
		RandomUtility randomutility = new RandomUtility();
		String foodName = randomutility.createFoodName();
		categoryField.sendKeys(foodName);
		return this;
	}

	public CategoryPage clickonSelectGroup() {
		selectGroups.click();
		return this;
	}

	public CategoryPage scrollDown() {
		PageUtility pageutility = new PageUtility();
		pageutility.javaScriptExecutorSimpleScrollfromTopToBottom(driver);
		return this;
	}

	public CategoryPage clickonChooseFile() {
		FileUploadUtility fileuploading = new FileUploadUtility();
		fileuploading.verifyFileUploadusingSendKeys(chooseFile, Constants.TESTDATAPIC);
		return this;
	}

	public CategoryPage clickonUpdateIcon() {
		PageUtility pageutility = new PageUtility();
		pageutility.clickOnElement(updateImg, driver);
		return this;

	}

	public boolean isAddingItemSuccefully() {
		boolean isAddingSuccessAlertDisplayed = additionSuccessAlert.isDisplayed();
		return isAddingSuccessAlertDisplayed;
	}

}
