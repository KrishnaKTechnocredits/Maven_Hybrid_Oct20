package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;
import constantPath.ConfigFilePath;
import pojo.ProductDetailsPojo;
import util.PropertiesFileReader;

public class ProductDetailsPage extends PredefinedActions {

	private static ProductDetailsPage productDetailsPage;
	private PropertiesFileReader productPageProperties;

	private ProductDetailsPage() {
		productPageProperties = new PropertiesFileReader(ConfigFilePath.PRODUCT_DETAILED_PAGE_PROPERTIES);
	}

	public static ProductDetailsPage getInstance() {
		if (productDetailsPage == null) {
			productDetailsPage = new ProductDetailsPage();
		}
		return productDetailsPage;
	}

	public ProductDetailsPojo capatureProductDetails(ProductDetailsPojo productDetailsPojo) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		String productName = getElementText(productPageProperties.getValue("productName"), true);
		String unitPrice = getElementText(productPageProperties.getValue("unitRate"), true);
		unitPrice = unitPrice.substring(1);

		String quantity = getElement(productPageProperties.getValue("quantity"), true).getAttribute("value");

		String size = getElementText(productPageProperties.getValue("size"), true);

		String des = getElementText(productPageProperties.getValue("productDescription"), true);

		String color = getElement(productPageProperties.getValue("productColor"), true).getAttribute("title");

		productDetailsPojo.setProductName(productName);
		productDetailsPojo.setUnitRatePrice(unitPrice);
		productDetailsPojo.setQuantity(quantity);
		productDetailsPojo.setSize(size);
		productDetailsPojo.setProductDescription(des);
		productDetailsPojo.setColor(color);

		return productDetailsPojo;
	}

	public void setQuantity(String numOfQuantity) {
		enterText(numOfQuantity, productPageProperties.getValue("quantity"), true);
		System.out.println("STEP - Quantity is set");
	}

	public void setSize(String size) {
		Select select = new Select(getElement(productPageProperties.getValue("setSize"), true));
		select.selectByVisibleText(size);
		System.out.println("STEP - Size selected");
	}

	public void selectColour(String color) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		switch (color.toUpperCase()) {
		case "BLUE":
			clickOnElement(productPageProperties.getValue("blueColour"), true);
			break;
		case "ORANGE":
			clickOnElement(productPageProperties.getValue("orangeColour"), true);
			break;
		default:
			break;
		}
	}

	public void clickOnAddToCart() {
		clickOnElement(productPageProperties.getValue("addToCart"), true);
	}

	public String verifyProductName() {
		String productName = getElementText(productPageProperties.getValue("verifyProductName"), true);
		return productName;
	}

	public String verifyQuantity() {
		String quantity = getElementText(productPageProperties.getValue("verifyQuantity"), true);
		return quantity;
	}

	public String verifySizeAndColor() {
		String sizeAndColor = getElementText(productPageProperties.getValue("verifySizeAndColur"), true);
		return sizeAndColor;
	}

	public String verifyTotalPrice() {
		String totalPrice = getElementText(productPageProperties.getValue("totalPrice"), true).substring(1);
		return totalPrice;
	}

	public ShoppingSummaryPage clickOnProceedToCheckout() {
		clickOnElement(productPageProperties.getValue("proccedToCheckOut"), true);
		System.out.println("STEP - Click Proceed to checkout on Product detail page");
		return ShoppingSummaryPage.getInstance();
	}

}
