package base;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constantPath.ConfigFilePath;
import util.TimeUtil;

public class PredefinedActions {
	protected static WebDriver driver;
	private static WebDriverWait wait;

	public static void start() {
		System.setProperty("webdriver.chrome.driver", ConfigFilePath.WINDOWS_CHROME);
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
		driver.manage().window().maximize();
		// driver.get("http://automationpractice.com/index.php");
		driver.get("http://automationpractice.com/index.php");
		System.out.println("Navigate to Application");
	}

	private String getLocatorType(String locator) {
		return locator.split("]:-")[0].replace("[", "");
	}

	private String getLocatorValue(String locator) {
		return locator.split("]:-")[1];
	}

	protected WebElement getElement(String locator, boolean isWaitRequired) { // [css]:-.header_user_info>a
		String locatorType = getLocatorType(locator);
		String locatorValue = getLocatorValue(locator);
		WebElement element = null;
		switch (locatorType.toUpperCase()) {
		case "CSS":
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
			else
				element = driver.findElement(By.cssSelector(locatorValue));
			break;
		case "XPATH":
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
			else
				element = driver.findElement(By.xpath(locatorValue));
			break;
		case "ID":
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
			else
				element = driver.findElement(By.id(locatorValue));
			break;
		}
		return element;
	}

	protected List<WebElement> getElements(String locator, boolean isWaitRequired) { // [css]:-.header_user_info>a
		String locatorType = getLocatorType(locator);
		String locatorValue = getLocatorValue(locator);
		List<WebElement> element = null;
		switch (locatorType.toUpperCase()) {
		case "CSS":
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(locatorValue)));
			else
				element = driver.findElements(By.cssSelector(locatorValue));
			break;
		case "XPATH":
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locatorValue)));
			else
				element = driver.findElements(By.xpath(locatorValue));
			break;
		case "ID":
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(locatorValue)));
			else
				element = driver.findElements(By.id(locatorValue));
			break;
		}
		return element;
	}

	protected void clickOnElement(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	protected void scrollToElement(WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	protected boolean isElementDisplayed(String locator, boolean isWaitRequired) {
		WebElement element = getElement(locator, isWaitRequired);
		if (!element.isDisplayed())
			scrollToElement(element);
		return element.isDisplayed();
	}

	protected String getElementText(String locator, boolean isWaitRequired) {
		WebElement element = getElement(locator, isWaitRequired);
		if (!element.isDisplayed())
			scrollToElement(element);
		return element.getText();
	}

	protected void clickOnElement(String locator, boolean isWaitRequired) {
		WebElement element = getElement(locator, isWaitRequired);
		clickOnElement(element);
	}

	protected void clearText(WebElement element) {
		element.clear();
	}

	protected void enterText(String text, String locator, boolean isWaitRequired) {
		WebElement element = getElement(locator, isWaitRequired);
		if (element.isEnabled()) {
			clearText(element);
			element.sendKeys(text);
		} else
			throw new ElementNotInteractableException("Locator - " + locator + ", Element is not enabled");
	}

	public static void capatureScreenShot(String result) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("./takeScreenShot/" + result + "_" + TimeUtil.getTimeStamp() + ".png"));
			// Files.copy(file, new File("./takeScreenShot/" + result.getName() + "_" +
			// TimeUtil.getTimeStamp() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void close() {
		driver.close();
	}

}
