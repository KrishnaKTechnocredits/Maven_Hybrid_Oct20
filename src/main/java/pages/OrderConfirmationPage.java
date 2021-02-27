package pages;

import base.PredefinedActions;
import constantPath.ConfigFilePath;
import util.PropertiesFileReader;

public class OrderConfirmationPage extends PredefinedActions {

	private static OrderConfirmationPage orderConfirmationPage;
	private PropertiesFileReader orderConfirmationProperties;

	private OrderConfirmationPage() {
		orderConfirmationProperties = new PropertiesFileReader(ConfigFilePath.ORDER_CONFIRMATION_PAGE_PROPERTIES);
	}

	public static OrderConfirmationPage getInstance() {
		if (orderConfirmationPage == null) {
			orderConfirmationPage = new OrderConfirmationPage();
		}
		return orderConfirmationPage;
	}

	public String capatureTotalAmount() {
		return getElementText(orderConfirmationProperties.getValue("totalAmount"), true).substring(1);
	}

	public OrderHistoryPage clickOnBackToOrder() {
		clickOnElement(orderConfirmationProperties.getValue("backOrderButton"), true);
		System.out.println("STEP - Click Proceed to checkout on Order History page");
		return OrderHistoryPage.getInstance();
	}

}
