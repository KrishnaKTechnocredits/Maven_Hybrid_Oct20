package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;
import constantPath.ConfigFilePath;
import pojo.CreateAccountDetailsPojo;
import util.PropertiesFileReader;

public class CreateAccountPage extends PredefinedActions {
	WebDriverWait wait;

	private static CreateAccountPage createAccountPage;
	private PropertiesFileReader createAccProperties;

	private CreateAccountPage() {
		createAccProperties = new PropertiesFileReader(ConfigFilePath.CREATE_ACCOUNT_PAGE_PROPERTIES);
	}

	public static CreateAccountPage getInstance() {
		if (createAccountPage == null) {
			createAccountPage = new CreateAccountPage();
		}
		return createAccountPage;
	}

	public boolean isPageHeadingTextDisplayed() {
		wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.textToBe(By.cssSelector(createAccProperties.getValue("createAccHeaders")),
				"CREATE AN ACCOUNT"));
	}

	// TODO : remove static wait
	private void selectGender(boolean isMale) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement titleElement;
		System.out.println("STEP - Select title");
		// titleElement = isMale ?
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#id_gender1")))
		// :
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#id_gender2")));
		// wait.until(ExpectedConditions.elementToBeClickable(titleElement));
		if (isMale)
			titleElement = getElement(createAccProperties.getValue("genedermale"), true);
		else
			titleElement = getElement(createAccProperties.getValue("genderFemale"), true);
		titleElement.click();
	}

	private void enterFirstName(String firtName) {
		System.out.println("STEP - Enter First Name");
		if (firtName != null) {
			enterText(firtName, createAccProperties.getValue("customerFirstName"), true);
		} else
			System.out.println("FirstName field is blank");
	}

	private void enterLastName(String lastName) {
		System.out.println("STEP - Enter Last Name");
		if (lastName != null) {
			enterText(lastName, createAccProperties.getValue("customerLastName"), true);
		} else {
			System.out.println("Last Name field is blank");
		}
	}

	private void enterPassword(String password) {
		System.out.println("STEP - Enter Password");
		if (password != null)
			enterText(password, createAccProperties.getValue("passwordField"), true);
		else
			System.out.println("Password field is blank");
	}

	private void selectDays(String day) {
		System.out.println("STEP - Select Birthdate from drop down");
		if (day != null) {
			clickOnElement(createAccProperties.getValue("daysDropDown"), true);
			Select s = new Select(getElement(createAccProperties.getValue("days"), true));
			s.selectByValue(day);
		} else
			System.out.println("Day is not given");
	}

	private void selectMonth(String month) {
		System.out.println("STEP - Select Birth month");
		if (month != null) {
			clickOnElement(createAccProperties.getValue("monthDropDown"), true);
			Select s = new Select(getElement(createAccProperties.getValue("months"), true));
			s.selectByValue(month);
		} else {
			System.out.println("Birth month is not given");
		}
	}

	private void selectYear(String year) {
		System.out.println("STEP - Select Birth year");
		if (year != null) {
			clickOnElement(createAccProperties.getValue("yearDropDown"), true);
			Select s = new Select(getElement(createAccProperties.getValue("years"), true));
			s.selectByValue(year);
		} else
			System.out.println("Year is not given");
	}

	private void selectCompany(String company) {
		System.out.println("STEP - Enter Company Name");
		if (company != null)
			enterText(company, createAccProperties.getValue("companyName"), true);
		else
			System.out.println("Company field is blank");
	}

	private void enterAddress(String address) {
		System.out.println("STEP - Enter Address Name");
		if (address != null)
			enterText(address, createAccProperties.getValue("address"), true);
		else
			System.out.println("address field is blank");
	}

	private void enterCity(String city) {
		System.out.println("STEP - Enter city Name");
		if (city != null)
			enterText(city, createAccProperties.getValue("city"), true);
		else
			System.out.println("city field is blank");
	}

	private void selectState(String state) {
		System.out.println("STEP - Select State");
		if (state != null) {
			clickOnElement(createAccProperties.getValue("state"), true);
			Select s = new Select(driver.findElement(By.id("id_state")));
			s.selectByVisibleText(state);

		} else
			System.out.println("state is not given");
	}

	private void enterPostCode(String postCode) {
		System.out.println("STEP - Enter Postcode");
		if (postCode != null)
			enterText(postCode, createAccProperties.getValue("postcode"), true);
		else
			System.out.println("PostCode field is blank");
	}

	private void enterAdditionalInformation(String additionalInfo) {
		System.out.println("STEP - Enter Additional information");
		if (additionalInfo != null)
			enterText(additionalInfo, createAccProperties.getValue("other"), true);
		else
			System.out.println("additionalInfo field is blank");
	}

	private void enterHomePhone(String homePhone) {
		System.out.println("STEP - Enter Home mobile number");
		if (homePhone != null)
			enterText(homePhone, createAccProperties.getValue("phone"), true);
		else
			System.out.println("Homephone field is blank");
	}

	private void enterMobile(String mobileNo) {
		System.out.println("STEP - Enter Mobile number");
		if (mobileNo != null) {
			enterText(mobileNo, createAccProperties.getValue("mobileNumber"), true);
		} else {
			System.out.println("MobileNumber field is blank");
		}

	}

	public void enterCreateAccountDetails(CreateAccountDetailsPojo createAccountDetailsPojo) {
		selectGender(createAccountDetailsPojo.isMale());
		enterFirstName(createAccountDetailsPojo.getFirstName());
		enterLastName(createAccountDetailsPojo.getLastName());
		enterPassword(createAccountDetailsPojo.getPassword());
		selectDays(createAccountDetailsPojo.getDays());
		selectMonth(createAccountDetailsPojo.getMonth());
		selectYear(createAccountDetailsPojo.getYear());
		selectCompany(createAccountDetailsPojo.getCompany());
		enterAddress(createAccountDetailsPojo.getAddress1());
		enterCity(createAccountDetailsPojo.getCity());
		selectState(createAccountDetailsPojo.getState());
		enterPostCode(createAccountDetailsPojo.getPostCode());
		enterAdditionalInformation(createAccountDetailsPojo.getAdditionalInfo());
		enterHomePhone(createAccountDetailsPojo.gethPhone());
		enterMobile(createAccountDetailsPojo.getmNumber());
	}

	public MyProfilePage clickOnRegistration() {
		clickOnElement(createAccProperties.getValue("registerAcc"), true);
		System.out.println("Details Registered in Application");
		return MyProfilePage.getInstance();
	}

	public List<String> getErrorMessage() {
		List<WebElement> listOfErrorElements = driver.findElements(By.cssSelector("ol>li"));
		List<String> listOfErrorText = new ArrayList<String>();
		String totalErrorCount = getElementText(createAccProperties.getValue("errorMessageList"), true);
		listOfErrorText.add(totalErrorCount);
		for (WebElement element : listOfErrorElements) {
			listOfErrorText.add(element.getText());
		}
		return listOfErrorText;
	}
}
