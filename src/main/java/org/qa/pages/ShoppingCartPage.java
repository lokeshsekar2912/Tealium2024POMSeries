package org.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qa.constants.Constants;
import org.qa.utils.ElementUtil;

public class ShoppingCartPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private By addToCartSuccessText = By.xpath("//span[@class='maintext' and text()=' Shopping Cart']");
	private By checkOutBtn = By.xpath("//div[@class='pull-right mb20']/a");

	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getAddToCartSuccessText() {
		return eleUtil.doGetText(addToCartSuccessText);

	}

	public CheckOutConfirmPage clickOnCheckOutBtn() {
		eleUtil.clickElementWhenReady(checkOutBtn, Constants.DEFAULT_TIMEOUT);
		return new CheckOutConfirmPage(driver);

	}

}
