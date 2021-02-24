package com.rafaelferreira.driver;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class DriverManager {

	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	protected static Wait<WebDriver> driverWait;

	private DriverManager() {
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(WebDriver driver) {
		DriverManager.driver.set(driver);
	}

	public static Wait<WebDriver> waitDriver() {

		return driverWait = new FluentWait<WebDriver>(getDriver()).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

	}

	public static void quit() {
		DriverManager.driver.get().quit();
		driver.remove();
	}
}
