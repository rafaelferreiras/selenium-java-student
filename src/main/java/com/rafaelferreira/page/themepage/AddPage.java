package com.rafaelferreira.page.themepage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rafaelferreira.page.AbstractPageObject;

import io.qameta.allure.Step;

public class AddPage extends AbstractPageObject {

	
	
	@FindBy(id = "field-customerName")
	private WebElement name;

	@FindBy(id = "field-contactLastName")
	private WebElement lastname;

	@FindBy(id = "field-contactFirstName")
	private WebElement contactFirstName;

	@FindBy(id = "field-phone")
	private WebElement phone;

	@FindBy(id = "field-addressLine1")
	private WebElement addressLine1;

	@FindBy(id = "field-addressLine2")
	private WebElement addressLine2;

	@FindBy(id = "field-city")
	private WebElement city;

	@FindBy(id = "field-state")
	private WebElement state;

	@FindBy(id = "field-postalCode")
	private WebElement postalCode;

	@FindBy(id = "field-country")
	private WebElement country;

	@FindBy(id = "field_salesRepEmployeeNumber_chosen")
	private WebElement fromEmployeer;

	@FindBy(className = "active-result")
	private List<WebElement> dropDowns;
	
	@FindBy(id = "field-creditLimit")
	private WebElement creditLimit;

	@FindBy(id = "form-button-save")
	private WebElement buttonSave;

	@FindBy(id = "report-success")
	private WebElement reportSuccess;

	@Step
	public void name(String customerName) {

		sendKeys(this.name, customerName);
	}
	
	@Step
	public void lastName(String lastName) {

		sendKeys(this.lastname, lastName);
	}
	
	@Step
	public void contactFirstName(String contactFirstName) {

		sendKeys(this.contactFirstName, contactFirstName);
	}
	
	@Step
	public void phone(String phone) {

		sendKeys(this.phone, phone);
	}
	
	@Step
	public void addressLine1(String addressLine1) {

		sendKeys(this.addressLine1, addressLine1);
	}
	
	@Step
	public void addressLine2(String addressLine2) {

		sendKeys(this.addressLine2, addressLine2);
	}
	
	@Step
	public void city(String city) {

		sendKeys(this.city, city);
	}
	@Step
	public void state(String state) {

		sendKeys(this.state, state);
	}
	@Step
	public void postalCode(String postalCode) {

		sendKeys(this.postalCode, postalCode);
	}
	
	@Step
	public void country(String country) {

		sendKeys(this.country, country);
	}
	
	@Step
	public void fromEmployeer(String fromEmployeer) {

		click(this.fromEmployeer);
		isElementVisible(dropDowns);
		click(dropDowns.stream().filter(s -> s.getText().equalsIgnoreCase(fromEmployeer)).findFirst().get());	
	}
	
	@Step
	public void creditLimit(String creditLimit) {

		sendKeys(this.creditLimit, creditLimit);
	}
	
	@Step
	public void buttonSave() {

		click(buttonSave);
	}
	
	@Step
	public String reportSuccess() {
		
		return getText(this.reportSuccess);		
	}
}