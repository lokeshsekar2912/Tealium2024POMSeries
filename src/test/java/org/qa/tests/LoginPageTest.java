package org.qa.tests;

import org.qa.base.BaseTest;
import org.qa.constants.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

	@Test (priority = 2)
	private void pageTitleTest() {
		String actualtitle = loginpage.getLoginPageTitle();
		System.out.println("Page title is :" + actualtitle);
		Assert.assertEquals(actualtitle, Constants.LOGIN_PAGE_TITLE);

	}

	@Test (priority = 1)
	private void pageUrlTest() {
		String actualUrl = loginpage.getLoginPageUrl();
		System.out.println("Page Url is :" + actualUrl);
		Assert.assertTrue(actualUrl.contains(Constants.LOGIN_PAGE_URL_FRACTION));

	}

	@Test (priority = 3)
	private void isForgotPwdLinkExistsTest() {
		Assert.assertTrue(loginpage.isForgotPwdLinkExits());

	}

	@Test (priority = 4)
	private void doLogin() {
		loginpage.doLogin("LokeshSekar", "Lokesh@98");

	}

}
