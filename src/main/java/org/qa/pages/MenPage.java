package org.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.qa.constants.Constants;
import org.qa.utils.ElementUtil;

public class MenPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private By menPageSuccessText = By.xpath("//span[@class='maintext']");
	private By twitterLink = By.xpath("(//div[@class='social_icons']/a)[2]");
	private By shaveLink = By.xpath("(//ul[@class='thumbnails row']/li/a)[3]");
	private By productList = By.xpath("//div[@class='thumbnails grid row list-inline']//div[@class='fixed_wrapper']");

	public MenPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getMenPageTitle() {
		return eleUtil.waitForTitleContains(Constants.MEN_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);

	}

	public String getMenPageUrl() {
		return eleUtil.waitForTitleContains(Constants.MEN_PAGE_URL_FRACTION, Constants.DEFAULT_TIMEOUT);

	}

	public String getMenPageSuccessText() {
		return eleUtil.doGetText(menPageSuccessText);

	}

	public boolean twitterLinkExist() {
		return eleUtil.waitForElementPresence(twitterLink, Constants.DEFAULT_TIMEOUT).isDisplayed();

	}

	public boolean shaveLinkExist() {
		return eleUtil.waitForElementPresence(shaveLink, Constants.DEFAULT_TIMEOUT).isDisplayed();

	}

	public ProductPage selectProduct(String productName) {
		List<WebElement> productElements = eleUtil.getElements(productList);
		for (WebElement e : productElements) {
			String productTextList = e.getText();
			System.out.println(productTextList);
			if (productTextList.contains(productName)) {
				e.click();
			}
			return new ProductPage(driver);
		}
		return null;

	}

}
