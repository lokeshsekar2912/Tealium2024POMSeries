package org.qa.tests;

import java.util.List;

import org.qa.base.BaseTest;
import org.qa.constants.Constants;
import org.qa.pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AccountPageTest extends BaseTest {

	@BeforeClass
	private void accSetUp() {
		accPage = loginpage.doLogin(prop.getProperty("Username"), prop.getProperty("Password"));

	}

	@Test
	public void accPageTitleTest() {
		String actualAccPageTitle = accPage.getAccountPageTitle();
		System.out.println("Account Page Title is :" + actualAccPageTitle);
		Assert.assertEquals(actualAccPageTitle, Constants.ACCOUNT_PAGE_TITLE);

	}

	@Test
	public void accPageUrlTest() {
		String actualAccPageUrl = accPage.getAccountPageUrl();
		System.out.println("Account Page Url is :" + actualAccPageUrl);
		Assert.assertTrue(actualAccPageUrl.contains(Constants.ACCOUNT_PAGE_URL_FRACTION));

	}

	@Test
	public void accPageHeaderTest() {
		String accountPageHeader = accPage.getAccountPageHeader();
		Assert.assertEquals(accountPageHeader, Constants.ACCOUNT_PAGE_HEADER);

	}

	@Test
	public void accPageLogoutLinkExistTest() {
		Assert.assertTrue(accPage.logoutLinkExist());

	}

	@Test
	public void accPageSectionListTest() {
		List<String> accPageSelectionList = accPage.accPageSelectionList();
		Assert.assertEquals(accPageSelectionList, Constants.ACCOUNT_PAGE_SELECTION_LIST);

	}

	@Test(priority = 1)
	public void logoutTest() {
		String logoutSuccessMsg = accPage.doClickOnLogout().getLogoutSuccessMsg();
		Assert.assertEquals(logoutSuccessMsg, Constants.LOGOUT_SUCCESS_MESSAGE);

	}

	@Test(priority = 2)
	public void doClickOnMenSecTest() {
		String menPageSuccessText = accPage.doClickOnMen().getMenPageSuccessText();
		Assert.assertEquals(menPageSuccessText, Constants.MEN_PAGE_SUCCESS_TEXT);

	}

	@Test(priority = 3)
	public void selectProduct() {
		secMenPage = accPage.doClickOnMen();
		prodtPage = secMenPage.selectProduct(Constants.PRODUCT_MEN_CARE_CLEAN_COMFORT_DEODORANT);
		String productUrl = prodtPage.getProductUrl();
		Assert.assertTrue(productUrl.contains(Constants.PRODUCT_PAGE_URL_FRACTION));

	}

	@Test (priority = 4)
	public void doClickOnAddToCartTest() {
		secMenPage = accPage.doClickOnMen();
		prodtPage = secMenPage.selectProduct(Constants.PRODUCT_MEN_CARE_CLEAN_COMFORT_DEODORANT);
		shopCartPage = prodtPage.clickonAddToCart();
		String addToCartSuccessText = shopCartPage.getAddToCartSuccessText().trim();
		System.out.println(addToCartSuccessText);
		Assert.assertEquals(addToCartSuccessText, Constants.ADD_TO_CART_SUCCESS_MESSAGE);

	}

}
