package com.rafaelferreira.driver;

import org.openqa.selenium.WebDriver;

import com.rafaelferreira.config.Configuration;
import com.rafaelferreira.config.ConfigurationManager;
import com.rafaelferreira.enums.Target;
import com.rafaelferreira.exceptions.TargetNotValidException;

public class DriverFactory {

	public WebDriver createInstance(String browser) {
		Configuration configuration = ConfigurationManager.getConfiguration();
		Target type = Target.valueOf(configuration.target().toUpperCase());

		WebDriver webdriver = null;

		switch (type) {

		case LOCAL:
			// override the browser value from @Optional on BaseWeb
			webdriver = new LocalDriverManager().createInstance(configuration.browser());
			break;
		case GRID:
			// getting the browser from the suite file or @Optional on BaseWeb
			// webdriver = new RemoteDriverManager().createInstance(browser);
			break;
		default:
			throw new TargetNotValidException(type.toString());
		}

		return webdriver;
	}
}
