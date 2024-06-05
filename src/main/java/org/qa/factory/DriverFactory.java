package org.qa.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	public WebDriver driver;
	public Properties prop;

	public WebDriver init_Driver(Properties prop) {
		
		String Browser = prop.getProperty("Browser");
		
		System.out.println("Running on..." +Browser);

		if (Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (Browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("Enter correct browser name" + Browser);
		}
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("Url"));

		return driver;

	}
	public Properties init_prop() {
		File configFile = new File("./src/test/resources/config/config.properties");
		try {
			FileInputStream ip = new FileInputStream(configFile);
			prop = new Properties();
			prop.load(ip);			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
