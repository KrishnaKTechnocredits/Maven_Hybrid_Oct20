package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;
import constantPath.ConfigFilePath;
import util.PropertiesFileReader;

public class OrderSummaryPage extends PredefinedActions {

	private static OrderSummaryPage orderSummaryPage;
	private PropertiesFileReader orderSummaryPageProperties;

	private OrderSummaryPage() {
		orderSummaryPageProperties = new PropertiesFileReader(ConfigFilePath.ORDER_SUMMARY_PAGE_PROPERTIES);
	}

	public static OrderSummaryPage getInstance() {
		if (orderSummaryPage == null) {
			orderSummaryPage = new OrderSummaryPage();
		}
		return orderSummaryPage;
	}

	public String captureAmount() {
		return getElementText(orderSummaryPageProperties.getValue("amount"), true).substring(1);
	}

	public OrderConfirmationPage clickOnConfirmOrder() {
		clickOnElement(orderSummaryPageProperties.getValue("orderConfirmation"), true);
		System.out.println("STEP - Click Proceed to checkout on Order confirmation page");
		return OrderConfirmationPage.getInstance();
	}

}
