package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;
import constantPath.ConfigFilePath;
import exceptionHandling.ProductNotFoundException;
import util.PropertiesFileReader;

public class ProductCategoryPage extends PredefinedActions {

	private static ProductCategoryPage productCategoryPage;
	private PropertiesFileReader productCateoryPageProperties;

	private ProductCategoryPage() {
		productCateoryPageProperties = new PropertiesFileReader(ConfigFilePath.PRODUCT_CATEGORY_PAGE_PROPERTIES);
	}

	public static ProductCategoryPage getInstance() {
		if (productCategoryPage == null) {
			productCategoryPage = new ProductCategoryPage();
		}
		return productCategoryPage;
	}

	public List<WebElement> getProductList() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		List<WebElement> productList = getElements(productCateoryPageProperties.getValue("totalSearchList"), true);
		return productList;
	}

	public ProductDetailsPage selectFirstAvailableProduct(List<WebElement> productList) {
		if (productList.size() > 0) {
			productList.get(0).click();
		} else {
			throw new ProductNotFoundException("Product Not displayed");
		}
		System.out.println("STEP - First product selected");
		return ProductDetailsPage.getInstance();
	}

}
