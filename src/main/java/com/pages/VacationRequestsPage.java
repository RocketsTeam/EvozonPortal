package com.pages;

import java.util.List;

import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VacationRequestsPage extends PageObject {

	@FindBy(css = "a[href*=inbox]")
	private WebElement vacationrequests;

	@FindBy(id = "_1_WAR_EvozonKaleooFormsportlet_workflowTasksSearchContainer_1_menuButton")
	private WebElement actions;

	@FindBy(id = "_1_WAR_EvozonKaleooFormsportlet_workflowTasksSearchContainer_1_2_menuButton")
	private WebElement actions1;

	@FindBy(css = ".aui-focus")
	private WebElement approve;

	@FindBy(id = "_1_WAR_EvozonKaleooFormsportlet_workflowTasksSearchContainer_1_1_menuButton")
	private WebElement actions2;

	@FindBy(css = ".taglib-icon")
	private WebElement reject;

	@FindBy(id = "workflowMyRolesTasksPanel")
	private WebElement myRolesContainer;

	@FindBy(css = ".taglib-icon lfr-delegate-click")
	private WebElement assignto;

	@FindBy(css = ".taglib-icon lfr-delegate-click aui-focus")
	private WebElement updateduedate;

	@FindBy(css = "ul.lfr-menu-list-overflow")
	private WebElement actionsContainer;

	public VacationRequestsPage(WebDriver driver) {
		super(driver);
	}

	public void markListEntry(String itemName, String action) {
		element(myRolesContainer).waitUntilVisible();
		List<WebElement> itemsList = myRolesContainer.findElements(By
				.cssSelector("tr.results-row"));

		theFor: for (WebElement elementNow : itemsList) {
			String identifier = elementNow.findElement(
					By.cssSelector("td:nth-child(2)")).getText();

			if (identifier.contains(itemName)) {
				elementNow.findElement(By.cssSelector("td:last-child a"))
						.click();
				selectAction(action);
				break theFor;
			}
		}

	}

	private void selectAction(String action) {
		element(actionsContainer).waitUntilVisible();
		List<WebElement> itemsList = actionsContainer.findElements(By
				.tagName("a"));
		for (WebElement elementNow : itemsList) {
			String identifier = elementNow.getText();

			if (identifier.contains(action)) {
				elementNow.click();
				break;
			}
		}

	}

	public boolean check_vacationreq() {

		return element(vacationrequests).isPresent();
	}

	public void click_vacationreq() {
		vacationrequests.click();
	}

	public boolean check_actions1() {

		return element(actions1).isPresent();
	}

	public void click_actions1() {
		actions1.click();
	}

	public boolean check_actions2() {

		return element(actions2).isPresent();
	}

	public void click_actions2() {
		actions2.click();
	}

	public boolean check_approve() {

		return element(approve).isPresent();
	}

	public void click_approve() {
		approve.click();
	}

	public boolean check_reject() {

		return element(reject).isPresent();
	}

	public void click_reject() {
		reject.click();
	}

	public boolean check_assignto() {

		return element(assignto).isPresent();
	}

	public void click_assignto() {
		assignto.click();
	}

	public boolean check_updateduedate() {

		return element(updateduedate).isPresent();
	}

	public void click_updateduedate() {
		updateduedate.click();
	}

	public boolean check_actions() {

		return element(actions).isPresent();
	}

	public void click_actions() {
		actions.click();
	}

}
