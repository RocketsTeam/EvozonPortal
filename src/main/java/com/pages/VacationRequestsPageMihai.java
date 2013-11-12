package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.thucydides.core.pages.PageObject;

public class VacationRequestsPageMihai extends PageObject {

	@FindBy(css = ".aui-tabview-list")
	private WebElement toplist;

	@FindBy(css = ".aui-tab-content a[href*=summary]")
	private WebElement summary;

	@FindBy(css = ".aui-tab-content a[href*=processes]")
	private WebElement processes;

	@FindBy(css = ".align-left col-1 col-name first valign-middle a[href*=Vacation Request]")
	private WebElement vacreqlink;

	public VacationRequestsPageMihai(WebDriver driver) {
		super(driver);

	}

	public void click_on_summary() {
		element(summary).click();
	}

	public void click_on_processes() {
		element(processes).click();
	}

	public boolean check_vacationrequest() {

		return element(vacreqlink).isPresent();
	}

	public void click_vacationrequest() {
		vacreqlink.click();
	}

}
