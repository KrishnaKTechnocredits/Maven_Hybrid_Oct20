package pages;

import base.PredefinedActions;

public class OrderHistoryPage extends PredefinedActions {

	private static OrderHistoryPage orderHistoryPage;

	private OrderHistoryPage() {
	}

	public static OrderHistoryPage getInstance() {
		if (orderHistoryPage == null) {
			orderHistoryPage = new OrderHistoryPage();
		}
		return orderHistoryPage;
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

}
