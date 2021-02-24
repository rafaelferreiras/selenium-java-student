package com.rafaelferreira.page.themepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rafaelferreira.page.AbstractPageObject;

import io.qameta.allure.Step;

public class BootstrapThemePage extends AbstractPageObject {

	

	@FindBy(id = "switch-version-select")
	private WebElement version;

	@FindBy(css = ".t5 > .btn")
	private WebElement addCustomer;

	@FindBy(css = "input[name='customerName']")
	private WebElement customerName;

	@FindBy(css = ".select-all-none")
	private WebElement allNone;

	@FindBy(css = ".btn > .text-danger:nth-child(2)")
	private WebElement btnDelete;

	@FindBy(css = "btn btn-danger delete-multiple-confirmation-button")
	private WebElement btnDeleteModal;

	@Step
	public void selectVersion(String value) {

		selectByValue(version, value);
	}

	@Step
	public void AddCustomer() {

		click(addCustomer);
	}

	@Step
	public void writeCustomerName(String customerName) {

		sendKeys(this.customerName, customerName);
	}

	@Step
	public void selectallNone() {

		click(allNone);
	}

	@Step
	public void deleteRegister() {

		click(btnDelete);
	}

}
