package org.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qa.utils.ElementUtil;

public class OrderPlacedPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;

	private By orderSuccessText = By.xpath("//span[@class='maintext' and text()=' Your Order Has Been Processed!']");

	public OrderPlacedPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public String getOrderPlacedSuccessText() {
		return eleUtil.doGetText(orderSuccessText).trim();

	}

}
