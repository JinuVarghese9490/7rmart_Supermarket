package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageContactPage {
	
	public WebDriver driver;
	
	public ManageContactPage(WebDriver driver)
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
	
	@FindBy(xpath = "(//a[@class='small-box-footer'])[5]")
	private WebElement manageContactMoreInfo;

	public void enterUserNameOnUserNameField(String userName) {
		userNameField.sendKeys(userName);
		}
	public void enterPasswordOnPasswordField(String password) {
		passwordField.sendKeys(password);
	}
    public void clickonSigninButton() {
		signinButton.click();
	}
    public void clickonManageContactMoreInfoButton() {
    	manageContactMoreInfo.click();
	}
}
