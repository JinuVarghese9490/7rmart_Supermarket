package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.FileUploadUtility;
import utility.PageUtility;

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
	@FindBy(id="cat_id")private WebElement dropDownSub;
    @FindBy(xpath = "//input[@id='main_img']")
	private WebElement chooseFileElement;
    @FindBy(xpath = "//button[@name='update']")
   	private WebElement updateElement;
	
	
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	private WebElement searchButton;
	@FindBy(xpath = "//select[@id='un']")
	private WebElement categoryElement;
	@FindBy(id = "un")
	private WebElement dropElement;
	@FindBy(xpath = "//input[@name='ut']")
	private WebElement subCategoryElement;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	private WebElement SearchButtonElement;
	@FindBy(xpath = "//span[@class='badge bg-success']")
	private WebElement statusElement;

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
	public void dropDownSubCategory()
	   {
		PageUtility pagautility = new PageUtility();
		pagautility.selectClickByIndex(dropDownSub,1);
		   
	   }
	public void clickonChooseFile() {
		FileUploadUtility fileuploadutility=new FileUploadUtility();
		fileuploadutility.verifyFileUploadusingSendKeys(chooseFileElement,"C:\\Users\\vargh\\Downloads\\image.png");
	}
	public void clickonUpdateButton() {
		updateElement.click();
	}
	
	
	
	
	public void clickonSearchButton() {
		searchButton.click();
	}

	public boolean isSearchListAvailable() {
		boolean isSearchPageDisplayed = categoryElement.isDisplayed();
		return isSearchPageDisplayed;
	}

	public void selectDropdown() {
		PageUtility pagautility = new PageUtility();
		pagautility.selectClickByIndex(dropElement,1);
	}

	public void enterSubCategoryonSubCategoryField(String subCategoryName) {
		subCategoryElement.sendKeys(subCategoryName);
	}

	public void submitonSearchButton() {
		SearchButtonElement.click();
	}

	public boolean isResultAvailable() {
		boolean isSearchedResultDisplayed = statusElement.isDisplayed();
		return isSearchedResultDisplayed;
	}

	
	
}
