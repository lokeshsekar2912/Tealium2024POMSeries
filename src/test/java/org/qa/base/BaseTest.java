package org.qa.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.qa.factory.DriverFactory;
import org.qa.pages.AccountPage;
import org.qa.pages.CheckOutConfirmPage;
import org.qa.pages.LoginPage;
import org.qa.pages.MenPage;
import org.qa.pages.OrderPlacedPage;
import org.qa.pages.ProductPage;
import org.qa.pages.ShoppingCartPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	public WebDriver driver;
	public DriverFactory df;
	public LoginPage loginpage;
	public AccountPage accPage;
	public MenPage secMenPage;
	public Properties prop;
	public ProductPage prodtPage;
	public ShoppingCartPage shopCartPage;
	public CheckOutConfirmPage checkOutPage;
	public OrderPlacedPage ordPlacePage;

	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_Driver(prop);
		loginpage = new LoginPage(driver);
		accPage = new AccountPage(driver);
		secMenPage = new MenPage(driver);
		prodtPage = new ProductPage(driver);
		shopCartPage = new ShoppingCartPage(driver);
		checkOutPage = new CheckOutConfirmPage(driver);
		ordPlacePage = new OrderPlacedPage(driver);
	}

	@AfterTest
	public void tearDown() {
//		driver.quit();
	}

}
