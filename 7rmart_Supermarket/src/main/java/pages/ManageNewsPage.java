package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
public WebDriver driver;
	
	public ManageNewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//input[@class='form-control' and @placeholder='Username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@class='form-control' and @placeholder='Password']")
	private WebElement passwordField;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	private WebElement signinButton;
	
    @FindBy(xpath = "(//p[text()='Manage News'])[1]")private WebElement manageNewsButton1;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")	private WebElement clickOnNewButton1;
	@FindBy(xpath="//textarea[@id='news']")private WebElement enternewsElement1;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton1;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertDisplayed1;
	
	
	public void enterUserNameOnUserNameField(String userName) {
		userNameField.sendKeys(userName);
	}

	public void enterPasswordOnPasswordField(String password) {
		passwordField.sendKeys(password);
	}

	public void clickonSigninButton() {
		signinButton.click();
	}
	
	public void manageNewsButton() {
       manageNewsButton1.click();

	}
	public void clickNewButton() {
		clickOnNewButton1.click();
	}
	public void enterTheNews(String text) {
		enternewsElement1.sendKeys(text);
	}
	public void clickOnSave() {
		saveButton1.click();
		
	}
	public boolean alerIstDisplayed() {
	boolean isAlertShown=alertDisplayed1.isDisplayed();
		return isAlertShown;
		
	}

}



