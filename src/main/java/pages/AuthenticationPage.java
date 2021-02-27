package pages;

import base.PredefinedActions;
import constantPath.ConfigFilePath;
import util.PropertiesFileReader;

public class AuthenticationPage extends PredefinedActions {

	private PropertiesFileReader authProperties;
	private static AuthenticationPage authenticationPage;

	private AuthenticationPage() {
		authProperties = new PropertiesFileReader(ConfigFilePath.AUTHENTICATION_PAGE_PROPERTIES);
	}

	public static AuthenticationPage getInstance() {
		if (authenticationPage == null) {
			authenticationPage = new AuthenticationPage();
		}
		return authenticationPage;
	}

	public void enterEmailAdress(String emailId) {
		System.out.println("STEP - Enter email addressfor the create user name");
		enterText(emailId, authProperties.getValue("createAccountEmail"), true);
	}

	public CreateAccountPage clickOnCreateAccount() {
		System.out.println("Clicked on the submit button to fill the other details");
		clickOnElement(authProperties.getValue("createAccountBtn"), true);
		return CreateAccountPage.getInstance();
	}

	public boolean isAuthenticationHeaderVisible() {
		return isElementDisplayed(authProperties.getValue("authenticationHeaders"),true);
	}

	public MyProfilePage doLogin(String emailAddress, String pwd) {
		enterEmailAddressInLogin(emailAddress);
		enterPasswordInLogin(pwd);
		clickOnSignInButton();
		return MyProfilePage.getInstance();
	}

	public void clickOnSignInButton() {
		System.out.println("STEP - Click on sign button");
		clickOnElement(authProperties.getValue("loginbtn"),false);
	}

	public void enterPasswordInLogin(String pwd) {
		System.out.println("STEP - Enter Password on login section");
		enterText(pwd, authProperties.getValue("loginPasswordField"), false);
	}

	public void enterEmailAddressInLogin(String emailAddress) {
		enterText(emailAddress, authProperties.getValue("loginEmailField"), true);
		System.out.println("STEP - Enter email address on login section");
	}

	public String verifyErrorMessage() {	
		return getElementText(authProperties.getValue("loginErrorMessage"), true);
	}

}
