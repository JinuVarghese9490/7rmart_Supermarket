package utility;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	// Action
	public void clickOnElement(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.click(element).build().perform();
	}
	public void clickAndHoldOnElement(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.clickAndHold(element).build().perform();
	}

	public void mouseHoverActionClick(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
	}

	public void dragAndDropActionClick(WebElement element1, WebElement element2, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(element1, element2).build().perform();
	}

	public void doubleClickAndHoldOnElement(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).build().perform();
	}

	public void sendText(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).build().perform();
	}

	public void rightClickAndHoldOnElement(WebElement element, WebDriver driver, String text) {
		Actions actions = new Actions(driver);
		actions.sendKeys(element, text).perform();
	}

	public void sendTexttoUppercase(WebElement element, WebDriver driver, String text) {
		Actions actions = new Actions(driver);
		actions.keyDown(element, Keys.SHIFT).sendKeys(text).perform();
	}

	// Select
	public void selectClickByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void selectClickByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectClickByValue(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByValue(text);
	}

	// Scrolling
	public void javaScriptExecutorSimpleScrollfromTopToBottom(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");// scrolled from top to bottom
	}

	public void javaScriptExecutorUsingElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void javaScriptExecutorScrollFromBottomtoTop(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350)", "");// scrolled from bottom to top
	}

	public void javaScriptExecutorScrollIntoView(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void javaScriptExecutorScrollToTheEnd(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)"); // scrolled to the end
	}

	
	public void sendKeys(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	
	public String getElementText(WebElement element) {
		return element.getText();
	}

	
	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public void navigateToURL(WebDriver driver,String url) {
		driver.navigate().to(url);
	}
	public void navigationCommand(WebDriver driver)
	{
		driver.navigate().back();
		driver.navigate().forward();
	}

	public void clearField(WebElement element) {
		element.clear();
		
	}
	public List<String> tableSample(WebDriver driver,String element) {
		
		List <WebElement> tableHeadings=driver.findElements(By.xpath(element));
		List<String> tableHead=new ArrayList();
		for(WebElement headings:tableHeadings)
		{
			String table=headings.getText();
			tableHead.add(table);
		}
		return tableHead;
	}
	
	
	
	
	public boolean findElementfromTableSample2(List<String> productsNames, String searchTitle, By driver) {
		List<WebElement> findName=driver.findElements((SearchContext) By.xpath(searchTitle));
		
	List <String> nameList=new ArrayList();
           for(WebElement identifyName:findName)
	{
		String name=identifyName.getText();
		nameList.add(name);
	}
           boolean isPresent= nameList.contains("Organic Chilly Powder");
          return isPresent;
	}
}
