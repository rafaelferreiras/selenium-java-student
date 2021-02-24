package com.rafaelferreira.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.rafaelferreira.config.Configuration;
import com.rafaelferreira.config.ConfigurationManager;
import com.rafaelferreira.driver.DriverFactory;
import com.rafaelferreira.driver.DriverManager;

@Listeners({ TestListener.class })
public abstract class BaseWeb {

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void beforeMethod(@Optional("chrome") String browser) {
		Configuration configuration = ConfigurationManager.getConfiguration();

		DriverFactory driverFactory = new DriverFactory();
		WebDriver driver = driverFactory.createInstance(browser);
		DriverManager.setDriver(driver);

		DriverManager.getDriver().get(configuration.url());
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		DriverManager.quit();
	}
}
