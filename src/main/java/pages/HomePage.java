package pages;

import base.PredefinedActions;
import constantPath.ConfigFilePath;
import util.PropertiesFileReader;

public class HomePage extends PredefinedActions {

	private static HomePage homePage;
	private PropertiesFileReader homePageProperties;

	private HomePage() {
		homePageProperties = new PropertiesFileReader(ConfigFilePath.HOME_PAGE_PROPERTIES);
	}

	public static HomePage getInstance() {
		if (homePage == null) {
			homePage = new HomePage();
		}
		return homePage;
	}

	public AuthenticationPage clickOnSignIn() {
		/*WebElement signInElement = getElement(homePageProperties.getValue("signInButton"), true);
		clickOnElement(signInElement);*/
		System.out.println("STEP - Clicked on sign in");
		clickOnElement(homePageProperties.getValue("signInButton"), true);
		return AuthenticationPage.getInstance();
	}

}
