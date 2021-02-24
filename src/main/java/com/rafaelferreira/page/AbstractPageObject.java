package com.rafaelferreira.page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.rafaelferreira.config.Configuration;
import com.rafaelferreira.config.ConfigurationManager;
import com.rafaelferreira.driver.DriverManager;

public class AbstractPageObject {

	protected AbstractPageObject() {
		Configuration configuration = ConfigurationManager.getConfiguration();
		int timeout = configuration.timeout();

		PageFactory.initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(), timeout), this);
	}

	public void sendKeys(WebElement element, String value) {
		
		isElementvisibilityOf(element).sendKeys(value);
	}

	public void click(WebElement element) {
		
		isElementClickable(element).click();
	}

	public void selectByValue(WebElement element, String value) {
		
		isElementClickable(element);
		Select valueCombo = new Select(element);
		valueCombo.selectByValue(value);
	}
	
	public String getText(WebElement element) {
		
		return isElementvisibilityOf(element).getText();
	}

	public WebElement isElementClickable(WebElement element) {
		return DriverManager.waitDriver()
				.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
	}

	public WebElement isElementvisibilityOf(WebElement element) {
		return DriverManager.waitDriver().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
	}
	
	public List<WebElement> isElementVisible(List<WebElement> element) {
		return DriverManager.waitDriver()
				.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(element)));
	}

}
