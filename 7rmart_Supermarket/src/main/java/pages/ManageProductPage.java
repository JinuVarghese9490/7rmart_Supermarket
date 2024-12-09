package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ExcelUtility;
import utility.PageUtility;
import utility.WaitUtility;

public class ManageProductPage {

	private WebDriver driver;

	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//i[@class='fas fa-arrow-circle-right'])[8]")
	private WebElement moreInfo;
	@FindBy(xpath = "//thead[@style='background-color:#f9f9f9']//th")
	private WebElement tableHeads;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	private WebElement searchTitle;

	public ManageProductPage scrollDown() {
		PageUtility pageutility = new PageUtility();
		pageutility.javaScriptExecutorSimpleScrollfromTopToBottom(driver);
		return this;
	}

	public ManageProductPage clickonMoreInfoButton() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, moreInfo);
		moreInfo.click();
		return this;
	}

	public ManageProductPage getTableHeadings() {
		PageUtility pageutility = new PageUtility();
		List<String> head = pageutility.tableSample(driver, ExcelUtility.getString(6, 0, "LoginPage"));
		return this;

	}

	public boolean getElementFromTableColumn() {
		PageUtility pageutility = new PageUtility();
		List<String> productsNames = pageutility.tableSample(driver, ExcelUtility.getString(7, 0, "LoginPage"));
		List<String> nameList = new ArrayList();
		nameList.addAll(productsNames);
		boolean isAvailable = nameList.contains("Organic Turmeric Powder100g");
		return isAvailable;
	}
}
