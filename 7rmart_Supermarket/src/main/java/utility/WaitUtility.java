package utility;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

	public static final long EXPLICIT_WAIT = 50;
	public static final long IMPLICIT_WAIT = 10;
	public static final long FLUENT_WAIT = 10;

	public void waitForVisibilityOfElement(WebDriver driver, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(target));
	}

	public  void waitForElementToBeClickable(WebDriver driver, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(target));
	}

	public void waitForVisibilityOfElementLocated(WebDriver driver, String target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(target)));
	}

	public void waitForPresenceOfElementLocated(WebDriver driver, String target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(target)));
	}

	public void waitForElementToBeSelected(WebDriver driver, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeSelected(target));

	}

	public void waitForAlertIsPresent(WebDriver driver, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
	}

	public void FluentWaitForElementToBeClickable(WebDriver driver, WebElement target) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementToBeClickable(target));
	}

	public void FluentWaitForAlertIsPresent(WebDriver driver, WebElement target) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.alertIsPresent());

	}

	public void FluentWaitForElementToBeSelected(WebDriver driver, String target) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementToBeSelected(By.xpath(target)));

	}

	public void FluentWaitForInvisibilityOfElement(WebDriver driver, WebElement target) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOf(target));

	}

	public void FluentWaitForinvisibilityOfElementLocated(WebDriver driver, String target) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(target)));

	}
}
