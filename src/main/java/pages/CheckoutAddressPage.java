package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;
import constantPath.ConfigFilePath;
import util.PropertiesFileReader;

public class CheckoutAddressPage extends PredefinedActions {

	private PropertiesFileReader checkoutPageProperties;
	private static CheckoutAddressPage checkoutAddressPage;

	private CheckoutAddressPage() {
		checkoutPageProperties = new PropertiesFileReader(ConfigFilePath.CHECKOUT_ADDRESS_PAGE_PROPERTIES);
	}

	public static CheckoutAddressPage getInstance() {
		if (checkoutAddressPage == null) {
			checkoutAddressPage = new CheckoutAddressPage();
		}
		return checkoutAddressPage;
	}

	public List<String> getDeliveryAddress() {
		List<WebElement> eleList = getElements(checkoutPageProperties.getValue("deliveryAddressTitle"), true);

		List<String> deliveryList = new ArrayList<>();
		for (WebElement ele : eleList) {
			deliveryList.add(ele.getText());
		}
		return deliveryList;

	}

	public List<String> getBilingAddress() {
		List<WebElement> eleList = getElements(checkoutPageProperties.getValue("billingAddressTitle"), true);
		List<String> billingList = new ArrayList<>();
		for (WebElement ele : eleList) {
			billingList.add(ele.getText());
		}
		return billingList;
	}

	public CheckoutShippingPage clickOnProcessToCheckout() {
		clickOnElement(checkoutPageProperties.getValue("processCheckOutButton"), true);
		System.out.println("STEP - Click Proceed to checkout on Address page");
		return CheckoutShippingPage.getInstance();
	}

}
