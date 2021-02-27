package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;
import constantPath.ConfigFilePath;
import util.PropertiesFileReader;

public class CheckoutPaymentPage extends PredefinedActions {

	private static CheckoutPaymentPage checkoutPaymentPage;
	private PropertiesFileReader paymentProperties;

	private CheckoutPaymentPage() {
		paymentProperties = new PropertiesFileReader(ConfigFilePath.CHECKOUT_PAYMNT_PAGE_PROPERTIES);
	}

	public static CheckoutPaymentPage getInstance() {
		if (checkoutPaymentPage == null) {
			checkoutPaymentPage = new CheckoutPaymentPage();
		}
		return checkoutPaymentPage;
	}

	public String getToalPrice() {
		return getElementText(paymentProperties.getValue("totalPrice"), true).substring(1);
	}

	public OrderSummaryPage paymentBy(String paymentType) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		switch (paymentType.toUpperCase()) {
		case "CHECK":
			clickOnElement(paymentProperties.getValue("paymentMethodCheck"), true);
			break;

		case "BANK WIRE":
			clickOnElement(paymentProperties.getValue("paymentMethodWire"), true);
			break;
		default:
			break;
		}
		return OrderSummaryPage.getInstance();
	}

}
