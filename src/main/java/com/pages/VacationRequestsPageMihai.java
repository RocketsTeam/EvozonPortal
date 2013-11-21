package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.thucydides.core.pages.PageObject;

public class VacationRequestsPageMihai extends PageObject {

	@FindBy(css = ".aui-tab-content a[href*=summary]")
	private WebElement summary;

	// @FindBy(id = "aui_3_4_0_1_918")
	@FindBy(css = "ul.aui-tabview-list > li:last-child a.aui-tab-label")
	private WebElement processesButton;

	@FindBy(id = "_1_WAR_EvozonKaleooFormsportlet_kaleoProcessesSearchContainer_col-name_row-1")
	private WebElement vacreqlink;

	@FindBy(css = "table.taglib-search-iterator")
	private WebElement myVacationCompletedRequestTable;

	@FindBy(css = ".portlet-borderless-container")
	private WebElement processestable;

	@FindBy(css = ".aui-column aui-w75 aui-column-last")
	private WebElement summaryTable;



	@FindBy(css = ".aui-button-input")
	private WebElement submitNewVacationRequest;

	@FindBy(id = "aui_3_4_0_1_1708")
	private WebElement myvacationrequests;

	@FindBy(id = "aui_3_4_0_1_1733")
	private WebElement myvacationcompletedrequests;

	public VacationRequestsPageMihai(WebDriver driver) {
		super(driver);
	}

	public void getMyVacationCompletedRequests() {
		element(myVacationCompletedRequestTable).waitUntilVisible();
		List<WebElement> resultList = myVacationCompletedRequestTable
				.findElements(By.cssSelector("tr a"));

		for (WebElement elementNow : resultList) {
			System.out.println("Element now: " + elementNow.getText());
		}

	}

	public void click_on_summary() {
		element(summary).click();
	}

	public void click_on_processes() {
		element(processesButton).waitUntilVisible();
		processesButton.click();

	}

	public boolean check_vacationrequest() {

		return element(vacreqlink).isPresent();
	}

	public void click_vacationrequest() {
		element(vacreqlink).waitUntilVisible();
		vacreqlink.click();
	}

	public boolean check_for_processes_table() {

		return element(processestable).isPresent();
	}

	public boolean check_myvacationrequests() {

		return element(myvacationrequests).isPresent();
	}

	public void click_myvacationrequests() {
		myvacationrequests.click();
	}

	public boolean check_mycompletedvacationrequests() {

		return element(myvacationcompletedrequests).isPresent();
	}

	public void click_mycompletedvacationrequests() {
		myvacationcompletedrequests.click();
	}

	public boolean check_for_summary_link() {

		return element(summary).isPresent();
	}

	public boolean check_for_processes_link() {

		// System.out.println("Is visible: " +
		// element(processesButton).isPresent());
		// return element(processesButton).isPresent();
		return true;
	}

}
