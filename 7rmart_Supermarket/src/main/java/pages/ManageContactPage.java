package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.PageUtility;
import utility.RandomUtility;
import utility.WaitUtility;

public class ManageContactPage {
	
	
	WaitUtility waitutility=new WaitUtility();
	PageUtility pageutility=new PageUtility();
	RandomUtility randomutility=new RandomUtility();
	
	public WebDriver driver;
	
	public ManageContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

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
	
	
    public ManageContactPage clickonManageContactMoreInfoButton() {
    	waitutility.waitForElementToBeClickable(driver, manageContactMoreInfo);
    	manageContactMoreInfo.click();
    	return this;
	}
    public ManageContactPage clickonActionIcon() {
    	waitutility.waitForElementToBeClickable(driver, actionIcon);
    	actionIcon.click();
    	return this;
	}
    public ManageContactPage phoneField() {
    	pageutility.clearField(phone);
    	String phoneNumber=randomutility.createRandomPnoneNumber();
    	phone.sendKeys(phoneNumber);
    	return this;
    }
    public ManageContactPage emailField() {
    	pageutility.clearField(email);
    	String emailId=randomutility.createRandomEmailAddress();
    	email.sendKeys(emailId);
    	return this;
    }
    public ManageContactPage addressField() {
    	pageutility.clearField(adress);
    	String adresses=randomutility.createRandomAddress();
    	adress.sendKeys(adresses);
    	return this;
    }
    public ManageContactPage deliveryTimeField() {
    	pageutility.clearField(deliveryTime);
    	int deliveryTimes=randomutility.createRandomTimeAdjust();
    	String time=Integer.toString(deliveryTimes);
    	deliveryTime.sendKeys(time);
    	return this;
    }
    public ManageContactPage deliveryChargeLimitField() {
    	pageutility.clearField(deliveryChargeLimit);
    	int deliveryChargeTaken=randomutility.createRandomAmount();
    	String charge=Integer.toString(deliveryChargeTaken);
    	deliveryChargeLimit.sendKeys(charge);
    	return this;
    }
    public ManageContactPage scrollDown() {
    	waitutility.waitForPresenceOfElementLocated(driver, "//a[@class='btn btn-default btn-fix']");
    	pageutility.javaScriptExecutorSimpleScrollfromTopToBottom(driver);
    	return this;
    }
    public ManageContactPage clickonUpdateIcon()
    {
    	waitutility.waitForElementToBeClickable(driver,update);
    	update.click();
		return this;
    }
    public boolean isAlertAvailable()
    {
    	boolean isAlertSuccessMessageDisplayed=alert.isDisplayed();
    	return isAlertSuccessMessageDisplayed;
    }
	
}
