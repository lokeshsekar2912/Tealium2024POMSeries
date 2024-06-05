package org.qa.tests;

import org.qa.base.BaseTest;
import org.qa.constants.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CartPageTest extends BaseTest {

	@BeforeClass
	private void cartSetUp() {
		accPage = loginpage.doLogin(prop.getProperty("Username"), prop.getProperty("Password"));
		secMenPage = accPage.doClickOnMen();
		prodtPage = secMenPage.selectProduct(Constants.PRODUCT_MEN_CARE_CLEAN_COMFORT_DEODORANT);
		shopCartPage = prodtPage.clickonAddToCart();

	}

	@Test(priority = 1)
	public void clickOnCheckOutTest() {
		checkOutPage = shopCartPage.clickOnCheckOutBtn();
		String checkOutSuccessText = checkOutPage.getCheckOutSuccessText();
		Assert.assertEquals(checkOutSuccessText, Constants.CHECK_OUT_SUCCESS_TEXT);

	}

	@Test(priority = 2)
	public void clickOnConfirmOrderTest() {
		checkOutPage = shopCartPage.clickOnCheckOutBtn();
		ordPlacePage = checkOutPage.clickOnConfirmOrder();
		String orderPlacedSuccessText = ordPlacePage.getOrderPlacedSuccessText();
		Assert.assertEquals(orderPlacedSuccessText, Constants.ORDER_SUCCESS_TEXT);

	}

}
