package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utility.FileUploadUtility;
import utility.PageUtility;
import utility.RandomUtility;

public class SubCategoryPage {
	public WebDriver driver;

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//i[@class='fas fa-arrow-circle-right'])[4]")
	private WebElement moreInfoIcon;
	@FindBy(xpath = "//h1[text()='List Sub Categories']")
	private WebElement listSubCategoriesElement;
	@FindBy(xpath = "(//i[@class='fas fa-edit'])[2]")
	private WebElement editElement;
	@FindBy(id = "cat_id")
	private WebElement dropDownSub;
	@FindBy(xpath = "//input[@id='subcategory']")
	private WebElement subCategoryField;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement chooseFileElement;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement updateElement;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alerSuccess;

	public SubCategoryPage clickonMoreInfoButton() {
		moreInfoIcon.click();
		return this;
	}

	public SubCategoryPage clickonEditButton() {
		editElement.click();
		return this;
	}

	public SubCategoryPage dropDownSubCategory() {
		PageUtility pagautility = new PageUtility();
		pagautility.selectClickByIndex(dropDownSub, 4);
		return this;

	}

	public SubCategoryPage enterSubCategoryField() {
		subCategoryField.clear();
		RandomUtility randomutility = new RandomUtility();
		String foodName = randomutility.createFoodName();
		subCategoryField.sendKeys(foodName);
		return this;
	}

	public SubCategoryPage clickonChooseFile() {
		FileUploadUtility fileuploadutility = new FileUploadUtility();
		fileuploadutility.verifyFileUploadusingSendKeys(chooseFileElement, Constants.TESTDATAPIC);
		return this;
	}

	public SubCategoryPage scrollDown() {
		PageUtility pageutility = new PageUtility();
		pageutility.javaScriptExecutorSimpleScrollfromTopToBottom(driver);
		return this;

	}

	public SubCategoryPage clickonUpdateButton() {
		PageUtility pageutility = new PageUtility();
		pageutility.clickOnElement(updateElement, driver);
		return this;
	}

	public boolean isSuccessAlertAvailable() {
		boolean isAlerttDisplayed = alerSuccess.isDisplayed();
		return isAlerttDisplayed;
	}

}
