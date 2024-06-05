package org.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.qa.constants.Constants;
import org.qa.utils.ElementUtil;

public class ProductPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By addToCartBtn = By.xpath("//div[@class='mt20 ']/ul//li//a");

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getProductUrl() {
		return eleUtil.waitForUrlContains(Constants.PRODUCT_PAGE_URL_FRACTION, Constants.DEFAULT_TIMEOUT);

	}
	
	public ShoppingCartPage clickonAddToCart() {
		eleUtil.waitForElementToBeClickableWithPolling(addToCartBtn, Constants.DEFAULT_TIMEOUT, Constants.DEFAULT_POLLINGTIME);
		return new ShoppingCartPage(driver);

	}
	
	

}
