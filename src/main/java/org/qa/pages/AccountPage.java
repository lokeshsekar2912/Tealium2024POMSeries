package org.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.qa.constants.Constants;
import org.qa.utils.ElementUtil;

public class AccountPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private By header = By.xpath("//span[@class='maintext']");
	private By successMsg = By.xpath("//span[@class='maintext']/following-sibling::span");
	private By LogoutLink = By.xpath("(//ul[@class='side_account_list']/li)[10]/a");
	private By facBbookLink = By.linkText("Facebook");
	private By accSelectionList = By.xpath("//ul[@class='nav-pills categorymenu']/li/a");
	private By secMen = By.xpath("(//ul[@class='nav-pills categorymenu']/li)[6]/a");

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}

	public String getAccountPageTitle() {
		return eleUtil.waitForTitleContains(Constants.ACCOUNT_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);

	}

	public String getAccountPageUrl() {
		return eleUtil.waitForUrlContains(Constants.ACCOUNT_PAGE_URL_FRACTION, Constants.DEFAULT_TIMEOUT);
	}

	public boolean successMsgDisplayed() {
		return eleUtil.waitForElementPresence(successMsg, Constants.DEFAULT_TIMEOUT).isDisplayed();

	}

	public String getAccountPageHeader() {
		return eleUtil.doGetText(header);

	}

	public boolean logoutLinkExist() {
		return eleUtil.waitForElementPresence(LogoutLink, Constants.DEFAULT_TIMEOUT).isDisplayed();

	}

	public boolean faceBookLinkExist() {
		return eleUtil.waitForElementPresence(facBbookLink, Constants.DEFAULT_TIMEOUT).isDisplayed();

	}

	public List<String> accPageSelectionList() {
		List<WebElement> accPageSecElement = eleUtil.getElements(accSelectionList);
		List<String> accPageSecValueList = new ArrayList<String>();
		for (WebElement e : accPageSecElement) {
			String accPageSecValueText = e.getText().trim();
			accPageSecValueList.add(accPageSecValueText);
		}
		return accPageSecValueList;

	}
	
	public MenPage doClickOnMen() {
		eleUtil.doActionsClick(secMen);
		return new MenPage(driver);

	}

	public LoginPage doClickOnLogout() {
		if (logoutLinkExist()) {
			eleUtil.doClick(LogoutLink);
		}
		return new LoginPage(driver);

	}


}
