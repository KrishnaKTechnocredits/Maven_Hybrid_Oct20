package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;
import constantPath.ConfigFilePath;
import pojo.ProductDetailsPojo;
import util.PropertiesFileReader;

public class ShoppingSummaryPage extends PredefinedActions {

	private static ShoppingSummaryPage shoppingSummaryPage;
	private PropertiesFileReader shoppingProperties;

	private ShoppingSummaryPage() {
		shoppingProperties = new PropertiesFileReader(ConfigFilePath.SHOPPING_SUMMARY_PAGE_PROPERTIES);
	}

	public static ShoppingSummaryPage getInstance() {
		if (shoppingSummaryPage == null) {
			shoppingSummaryPage = new ShoppingSummaryPage();
		}
		return shoppingSummaryPage;
	}

	public String getProductName() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return getElementText(shoppingProperties.getValue("productName"), true);
	}

	public String getColorAndSize() {
		return getElementText(shoppingProperties.getValue("colourAndSize"), true);
	}

	public String getProductPrice() {
		return getElementText(shoppingProperties.getValue("colourAndSize"), true).substring(1);
	}

	public String getTotalPrice() {
		return getElementText(shoppingProperties.getValue("productTotalPrice"), true).substring(1);
	}

	public CheckoutAddressPage clickOnProceedToCheckout() {
		clickOnElement(shoppingProperties.getValue("proceedToCheckout"), true);
		System.out.println("STEP - Click Proceed to checkout on Shopping Summary page");
		return CheckoutAddressPage.getInstance();
	}

	public ProductDetailsPojo capatureShippingCharges(ProductDetailsPojo productDetailsPojo) {
		String shippingCharge = getElementText(shoppingProperties.getValue("shippingPrice"), true).substring(1);
		productDetailsPojo.setTotalShipping(shippingCharge);
		return productDetailsPojo;
	}

	public ProductDetailsPojo capatureFinalPrice(ProductDetailsPojo productDetailsPojo) {
		String finalPrice = getElementText(shoppingProperties.getValue("totalPrice"), true).substring(1);
		productDetailsPojo.setTotalPrice(finalPrice);
		return productDetailsPojo;
	}
}
