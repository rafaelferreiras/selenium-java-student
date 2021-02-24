package com.rafaelferreira.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import com.rafaelferreira.base.BaseWeb;
import com.rafaelferreira.page.themepage.BootstrapThemePage;
import com.rafaelferreira.page.themepage.AddPage;

public class BookRoomWebTest extends BaseWeb {

	@Test(description = "Add Customer Test")
	public void addCustomer() {

		BootstrapThemePage pageTheme = new BootstrapThemePage();
		AddPage addPage = new AddPage();

		pageTheme.selectVersion("bootstrap_theme_v4");
		pageTheme.AddCustomer();
		addPage.name("RAFAEL");
		addPage.lastName("FERREIRA");
		addPage.contactFirstName("RAFAEL");
		addPage.phone("61982002393");
		addPage.addressLine1("TAGUATINGA");
		addPage.addressLine2("QUADRA 19");
		addPage.city("BRASÍLIA");
		addPage.state("DF");
		addPage.postalCode("720000");
		addPage.country("BRAZIL");
		addPage.fromEmployeer("bow");
		addPage.creditLimit("20000");
		addPage.buttonSave();

		assertThat(addPage.reportSuccess()).isEqualTo(
				"Your data has been successfully stored into the database. Edit Customer or Go back to list");

	}
}
