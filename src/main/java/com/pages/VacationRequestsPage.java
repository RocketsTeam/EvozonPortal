package com.pages;

import java.util.List;

import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

	@FindBy(css = ".taglib-icon.lfr-delegate-click")
	private WebElement assignto;
	
	@FindBy(css = ".aui-field-input-menu")
	 private WebElement AssignUser;
	
	
	@FindBy(css = ".aui-dialog-ft .aui-toolbar-first")
	private WebElement OK_button;
	
	@FindBy(css = "div.aui-dialog-ft button:last-child")
	private WebElement cancel_button;
	
	//@FindBy(css=".aui-field-input")
	 //private WebElement assignToSomeone;

	@FindBy(css=".aui-field-input-menu")
	 private WebElement assignToList;

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
	
	public void click_action_button_my_roles(int index) {
		  element(myRolesContainer).waitUntilVisible();
		  List<WebElement> actionButtons = myRolesContainer.findElements(By.cssSelector(".taglib-text"));
		  actionButtons.get(index).click();
		 }
	
	public void selectAssignto(String person){
		
		element(assignto).waitUntilVisible();
		assignto.click();
		element(assignto).selectByVisibleText(person);
	}
	
	public void click_AssignUser() {
		  element(AssignUser).waitUntilVisible();
		  element(AssignUser).click();
		 }
		
	public void click_to_a_person(String person) {
	
	  
	  element(AssignUser).waitUntilVisible();
	  AssignUser.click();
	  AssignUser.click();
	  element(AssignUser).selectByVisibleText(person);
	 }
	
	 public void click_OK_button(){
		  element(OK_button).waitUntilVisible();
		  element(OK_button).click();
		 }
	 
	 public void click_cancel_button(){
		  element(cancel_button).waitUntilVisible();
		  element(cancel_button).click();
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

	public void refresh_page(){
		
		Actions actionObject = new Actions(getDriver());
		actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.F5).perform();
	}

}
