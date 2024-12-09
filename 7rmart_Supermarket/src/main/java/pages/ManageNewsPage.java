package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.RandomUtility;

public class ManageNewsPage {

	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//p[text()='Manage News'])[1]")
	private WebElement manageNewsButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement clickOnNewButton;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement enternewsElement;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertDisplayed;


	public ManageNewsPage clickOnManageNewsButton() {
		manageNewsButton.click();
		return this;

	}

	public ManageNewsPage clickNewButton() {
		clickOnNewButton.click();
		return this;
	}

	public ManageNewsPage enterTheNews() {
		RandomUtility randomutility = new RandomUtility();
		String news = randomutility.createRandomNews();
		enternewsElement.sendKeys(news);
		return this;
	}

	public ManageNewsPage clickOnSave() {
		saveButton.click();
		return this;

	}

	public boolean isalertAvailable() {
		boolean isSuccessAlerDisplayed = alertDisplayed.isDisplayed();
		return isSuccessAlerDisplayed;

	}

}
