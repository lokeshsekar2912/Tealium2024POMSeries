package org.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qa.constants.Constants;
import org.qa.utils.ElementUtil;

public class CheckOutConfirmPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By checkOutSuccessText = By.xpath("//span[@class='maintext' and text()=' Checkout Confirmation']");
	private By confirmOrderBtn = By.xpath("//button[@id='checkout_btn']");
	
	public CheckOutConfirmPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public String getCheckOutSuccessText() {
		return eleUtil.doGetText(checkOutSuccessText).trim();
		
	}
	
	public OrderPlacedPage clickOnConfirmOrder() {
		eleUtil.doActionsClick(confirmOrderBtn);
		return new OrderPlacedPage(driver);

	}	

}
