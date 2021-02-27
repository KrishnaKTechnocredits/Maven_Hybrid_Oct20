package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;
import constantPath.ConfigFilePath;
import util.PropertiesFileReader;

public class CheckoutShippingPage extends PredefinedActions {

	private static CheckoutShippingPage checkoutShippingPage;
	private PropertiesFileReader checkOutShippingProperties;

	private CheckoutShippingPage() {
		checkOutShippingProperties = new PropertiesFileReader(ConfigFilePath.CHECKOUT_SHIPPING_PAGE_PROPERTIES);
	}

	public static CheckoutShippingPage getInstance() {
		if (checkoutShippingPage == null) {
			checkoutShippingPage = new CheckoutShippingPage();
		}
		return checkoutShippingPage;
	}

	public String capatureShippingCharges() {
		return getElementText(checkOutShippingProperties.getValue("shippingCharges"), true).substring(1);
	}

	public void clickOnTermAndCondition() {
		clickOnElement(checkOutShippingProperties.getValue("termAndCondition"), true);
	}

	public CheckoutPaymentPage clickOnProcessToCheckout() {
		clickOnElement(checkOutShippingProperties.getValue("checkoutButton"), true);
		System.out.println("STEP - Click Proceed to checkout on Payment page");
		return CheckoutPaymentPage.getInstance();
	}
}
