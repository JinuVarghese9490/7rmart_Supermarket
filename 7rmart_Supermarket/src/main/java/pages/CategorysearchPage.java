package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.PageUtility;

public class CategorysearchPage {
	
	
	public WebDriver driver;

	public CategorysearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//i[@class='fas fa-arrow-circle-right'])[3]")
	private WebElement categoryMoreInfoIcon;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchField;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement categoryField;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitButton;
	@FindBy(xpath = "//td[text()='JEWELLERY']")
	private WebElement namePresent;
	
	
	public CategorysearchPage clickonCategoryMoreInfoButton() {
		categoryMoreInfoIcon.click();
		return this;
	}
	public CategorysearchPage clickonSearchField() {
		searchField.click();
		return this;
	}
	public CategorysearchPage enterCategoryNameOnCategoryField(String name) {
		categoryField.sendKeys(name);
		return this;
	}

	public CategorysearchPage clickonSubmitButton() {
		submitButton.click();
		return this;
	}
	public CategorysearchPage scrollDown() {
		PageUtility pageutility=new PageUtility();
		pageutility.javaScriptExecutorSimpleScrollfromTopToBottom(driver);
		return this;
	}
	
	public boolean isCategoryPresent() {
	boolean isTheSearchingElementDisplayed=	namePresent.isDisplayed();
	return isTheSearchingElementDisplayed;
		
	}
	
	
	
	}



