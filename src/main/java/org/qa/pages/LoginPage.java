package org.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qa.constants.Constants;
import org.qa.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1. Locators
	private By userName = By.xpath("//input[@id='loginFrm_loginname']");
	private By password = By.xpath("//input[@id='loginFrm_password']");
	private By loginBtn = By.xpath("//button[@title='Login']");
	private By forgotPwdLink = By.linkText("Forgot your password?");
	private By logoutSuccessMsg = By.xpath("//span[@class='maintext']");

	// 2. Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. Page actions
	public String getLoginPageTitle() {
		return eleUtil.waitForTitleIs(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);

	}

	public String getLoginPageUrl() {
		return eleUtil.waitForUrlContains(Constants.LOGIN_PAGE_URL_FRACTION, Constants.DEFAULT_TIMEOUT);

	}

	public boolean isForgotPwdLinkExits() {
		return eleUtil.isElementDisplayed(forgotPwdLink);

	}

	public AccountPage doLogin(String un, String pwd) {
		eleUtil.doSendKeys(userName, un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.waitForElementPresence(loginBtn, Constants.DEFAULT_POLLINGTIME);
		eleUtil.doActionsClick(loginBtn);

		return new AccountPage(driver);

	}

	public String getLogoutSuccessMsg() {
		return eleUtil.doGetText(logoutSuccessMsg);

	}

}
