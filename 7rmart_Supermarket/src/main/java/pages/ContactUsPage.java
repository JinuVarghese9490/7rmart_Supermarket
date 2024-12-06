package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.PageUtility;
import utility.RandomUtility;
import utility.WaitUtility;

public class ContactUsPage {
	
	
	WaitUtility waitutility=new WaitUtility();
	PageUtility pageutility=new PageUtility();
	RandomUtility randomutility=new RandomUtility();
	
	public WebDriver driver;
	
	public ContactUsPage(WebDriver driver)
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
	@FindBy(className = "fa-edit") 
	private WebElement actionIcon;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phone;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement email;
	@FindBy(xpath = "//textarea[@name='address']")
	private WebElement adress;
	@FindBy(xpath = "//textarea[@name='del_time']")
	private WebElement deliveryTime;
	@FindBy(xpath = "//input[@id='del_limit']")
	private WebElement deliveryChargeLimit;
	@FindBy(xpath = "//a[@class='btn btn-default btn-fix']")
	private WebElement reset;
	@FindBy(xpath = "//i[@class='fa fa-save']")
	private WebElement update;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;
	

	public void enterUserNameOnUserNameField(String userName) {
		userNameField.sendKeys(userName);
		}
	public void enterPasswordOnPasswordField(String password) {
		passwordField.sendKeys(password);
	}
    public void clickonSigninButton() {
    	waitutility.waitForElement2(driver, signinButton);
		signinButton.click();
	}
    public void clickonManageContactMoreInfoButton() {
    	waitutility.waitForElement2(driver, manageContactMoreInfo);
    	manageContactMoreInfo.click();
	}
    public void clickonActionIcon() {
    	waitutility.waitForElement2(driver, actionIcon);
    	actionIcon.click();
	}
    public void phoneField() {
    	pageutility.clearField(phone);
    	String phoneNumber=randomutility.createRandomPnoneNumber();
    	phone.sendKeys(phoneNumber);
    }
    public void emailField() {
    	pageutility.clearField(email);
    	String emailId=randomutility.createRandomEmailAddress();
    	email.sendKeys(emailId);
    }
    public void addressField() {
    	pageutility.clearField(adress);
    	String adresses=randomutility.createRandomAddress();
    	adress.sendKeys(adresses);
    }
    public void deliveryTimeField() {
    	pageutility.clearField(deliveryTime);
    	int deliveryTimes=randomutility.createRandomTimeAdjust();
    	String time=Integer.toString(deliveryTimes);
    	deliveryTime.sendKeys(time);
    }
    public void deliveryChargeLimitField() {
    	pageutility.clearField(deliveryChargeLimit);
    	int deliveryChargeTaken=randomutility.createRandomAmount();
    	String charge=Integer.toString(deliveryChargeTaken);
    	deliveryChargeLimit.sendKeys(charge);
    }
    public void scrollDown() {
    	waitutility.waitForElement3(driver, "//a[@class='btn btn-default btn-fix']");
    	pageutility.javaScriptExecutorSample1(driver);
    }
    public void clickonUpdateIcon()
    {
    	waitutility.waitForElement5(driver, update);
    	waitutility.waitForElement2(driver,update);
    	update.click();
    }
    public boolean isAlertAvailable()
    {
    	boolean isAlertSuccessMessageDisplayed=alert.isDisplayed();
    	return isAlertSuccessMessageDisplayed;
    }
	
}
