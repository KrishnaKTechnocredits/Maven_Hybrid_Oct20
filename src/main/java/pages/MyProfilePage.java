package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;
import constantPath.ConfigFilePath;
import util.PropertiesFileReader;

public class MyProfilePage extends PredefinedActions {

	private static MyProfilePage myProfilePage;
	private PropertiesFileReader myProfileProperties;

	private MyProfilePage() {
		myProfileProperties = new PropertiesFileReader(ConfigFilePath.MY_PROFILE_PAGE_PROPERTIES);
	}

	public static MyProfilePage getInstance() {
		if (myProfilePage == null) {
			myProfilePage = new MyProfilePage();
		}
		return myProfilePage;
	}

	public String getHeaderText() {
		String headerText = getElementText(myProfileProperties.getValue("headerText"), true);
		return headerText;
	}

	public String getUserFullName() {
		String fullName = getElementText(myProfileProperties.getValue("fullUserName"), true);
		return fullName;
	}

	public ProductCategoryPage selectSection(String sectionName) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement ele = null;
		switch (sectionName.toUpperCase()) {
		case "WOMEN":
			ele = getElement(myProfileProperties.getValue("womenSection"), true);
			break;
		case "DRESSES":
			ele = getElement(myProfileProperties.getValue("dressSection"), true);
			break;

		case "T-SHIRTS":
			ele = getElement(myProfileProperties.getValue("tShirtSection"), true);
			break;
		default:
			break;
		}
		ele.click();
		return ProductCategoryPage.getInstance();
	}

}
