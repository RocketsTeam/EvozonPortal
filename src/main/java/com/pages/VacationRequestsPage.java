package com.pages;

import java.util.List;

import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class VacationRequestsPage extends PageObject {

	@FindBy(css = "a[href*=inbox]")
	private WebElement vacationrequests;

	@FindBy(css = ".aui-focus")
	private WebElement approveBtn;

	@FindBy(id = "_1_WAR_EvozonKaleooFormsportlet_workflowTasksSearchContainer_1_1_menuButton")
	private WebElement actions2;

	@FindBy(css = ".taglib-icon")
	private WebElement rejectBtn;

	@FindBy(id = "workflowMyRolesTasksPanel")
	private WebElement myRolesContainer;

	@FindBy(id = "workflowOthersTasksPanel")
	private WebElement assignedOthers;

	@FindBy(css = ".taglib-icon.lfr-delegate-click")
	private WebElement assignto;

	@FindBy(css = ".aui-field-input-menu")
	private WebElement AssignUser;

	@FindBy(css = ".aui-dialog-ft .aui-toolbar-first")
	private WebElement OK_button;

	@FindBy(css = "div.aui-dialog-ft button:last-child")
	private WebElement cancel_button;

	@FindBy(css = ".aui-field-input-menu")
	private WebElement assignToList;

	@FindBy(id = "_1_WAR_EvozonKaleooFormsportlet_comment")
	private WebElement commentsection;

	@FindBy(css = "a[href*= updateWorkflowTask]")
	private WebElement updateduedate;

	@FindBy(css = ".aui-dialog-ft .aui-toolbar-first")
	private WebElement updateduedate_OKbutton;

	@FindBy(css = ".aui-dialog-ft .aui-toolbar-last")
	private WebElement updateduedate_Cancelbutton;

	@FindBy(css = ".aui-field-content .aui-field-input-text")
	private WebElement commentsectionDueDate;

	@FindBy(how = How.CSS, using = "div[aria-hidden=\"false\"] #_1_WAR_EvozonKaleooFormsportlet_dueDateMonth")
	private WebElement monthDueDate;

	@FindBy(css = ".aui-datepicker-day")
	private WebElement dayDueDate;

	@FindBy(css = ".aui-datepicker-year")
	private WebElement yearDueDate;

	@FindBy(css = ".aui-dialog-focused select[name*=Hour]")
	private WebElement hourDueDate;

	@FindBy(css = ".aui-dialog-focused")
	private WebElement dialogFocused;

	@FindBy(css = ".aui-dialog-focused select[name*=Minute]")
	private WebElement minDueDate;

	@FindBy(css = ".aui-dialog-focused select[name*=AmPm]")
	private WebElement AMPMDueDate;

	@FindBy(css = "ul.lfr-menu-list-overflow")
	private WebElement actionsContainer;

	@FindBy(css = ".taglib-icon.lfr-delegate-click.aui-focus")
	private WebElement assignToMe;

	@FindBy(css = "span.aui-field-content > span.aui-field-element  > textarea.aui-field-input.aui-field-input-text")
	private WebElement commAssignToMe;

	@FindBy(css = ".portlet-msg-success")
	private WebElement messageSuccesfull;

	@FindBy(css="div.lfr-panel-content > div.lfr-search-container > div:first-child table tr.results-row")
	private WebElement actionsAssignedToMeSection;
	
	@FindBy(css =".taglib-icon lfr-delegate-click aui-focus")
	private WebElement resubmitBtn;

	
	public VacationRequestsPage(WebDriver driver) {
		super(driver);
	}

	public void assert_VacationRequestsActionBtn_should_be_visible() {
		element(actions2).shouldBeVisible();
	}

	public void click_VacationRequestsActionBtn() {
		element(actions2).waitUntilVisible();
		element(actions2).click();
	}

	public void click_ApproveBtn() {
		element(approveBtn).waitUntilVisible();
		element(approveBtn).click();
	}

	public void click_RejectBtn() {
		element(rejectBtn).waitUntilVisible();
		element(rejectBtn).click();
	}

	public void selectAssignto(String person) {

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

	public void click_OK_button() {
		element(OK_button).waitUntilVisible();
		element(OK_button).click();
	}

	public void click_cancel_button() {
		element(cancel_button).waitUntilVisible();
		element(cancel_button).click();
	}

	public boolean check_vacationreq() {

		return element(vacationrequests).isPresent();
	}

	public void click_vacationreq() {
		vacationrequests.click();
	}

	public boolean check_actions2() {

		return element(actions2).isPresent();
	}

	public void click_actions2() {
		actions2.click();
	}

	public boolean check_approve() {

		return element(approveBtn).isPresent();
	}

	public void click_approve() {
		approveBtn.click();
	}

	public boolean check_reject() {

		return element(rejectBtn).isPresent();
	}

	public void click_reject() {
		rejectBtn.click();
	}

	public boolean check_assignto() {

		return element(assignto).isPresent();
	}

	public void click_assignto() {
		assignto.click();
	}

	public void enter_comm(String keyword) {
		element(commentsection).waitUntilVisible();
		element(commentsection).type(keyword);
	}

	public boolean check_updateduedate() {

		return element(updateduedate).isPresent();
	}

	public void click_updateduedate() {
		updateduedate.click();
	}

	public void click_OKDueDate() {
		element(updateduedate_OKbutton).waitUntilVisible();
		element(updateduedate_OKbutton).click();
	}

	public void click_CancelDueDate() {
		element(updateduedate_Cancelbutton).waitUntilVisible();
		element(updateduedate_Cancelbutton).click();
	}

	public void enter_commDueDate(String keyword) {
		element(commentsectionDueDate).waitUntilVisible();
		element(commentsectionDueDate).type(keyword);
	}

	public void selectMonthDueDate(String monthNameDueDate) {
		element(monthDueDate).waitUntilVisible();
		monthDueDate.click();
		monthDueDate.click();
		element(monthDueDate).selectByVisibleText(monthNameDueDate);
	}

	public void selectDayDueDate(String dayNameDueDate) {
		element(dayDueDate).waitUntilVisible();
		dayDueDate.click();
		dayDueDate.click();
		element(dayDueDate).selectByVisibleText(dayNameDueDate);
	}

	public void selectYearDueDate(String yearNameDueDate) {
		element(yearDueDate).waitUntilVisible();
		yearDueDate.click();
		yearDueDate.click();
		element(yearDueDate).selectByVisibleText(yearNameDueDate);
	}

	public void selectHourDueDate(String hourNameDueDate) {
		element(hourDueDate).waitUntilVisible();
		hourDueDate.click();
		hourDueDate.click();
		element(hourDueDate).selectByVisibleText(hourNameDueDate);
	}

	public void selectMinDueDate(String minNameDueDate) {
		element(minDueDate).waitUntilVisible();
		minDueDate.click();
		minDueDate.click();
		element(minDueDate).selectByVisibleText(minNameDueDate);
	}

	public void selectAMPMDueDate(String AMPMNameDueDate) {
		element(AMPMDueDate).waitUntilVisible();
		AMPMDueDate.click();
		AMPMDueDate.click();
		element(AMPMDueDate).selectByVisibleText(AMPMNameDueDate);
	}

	public boolean check_actions() {

		return element(actions2).isPresent();
	}

	public void click_actions() {
		actions2.click();
	}

	public void refresh_page() {

		Actions actionObject = new Actions(getDriver());
		actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.F5).perform();
	}

	public void click_action_button_from_assignedOthers(int index) {
		element(assignedOthers).waitUntilVisible();
		List<WebElement> actionButtons = assignedOthers.findElements(By
				.cssSelector("strong a"));
		actionButtons.get(index).click();
	}

	public void click_AssignToMe() {
		element(assignToMe).waitUntilVisible();
		element(assignToMe).click();
	}

	public void enter_commAssignToMe(String keyword) {
		element(commAssignToMe).waitUntilVisible();
		element(commAssignToMe).type(keyword);
	}

	public boolean check_messageSuccesfully() {

		return element(messageSuccesfull).isPresent();
	}

	public void assert_ActionsAssignedToMeBtn() {
		element(actionsAssignedToMeSection).shouldBeVisible();
	}

	public void click_ActionsAssignedToMeBtn() {
		element(actionsAssignedToMeSection).waitUntilVisible();
		element(actionsAssignedToMeSection).click();
	}

	public void click_ResubmitBtn() {
		element(resubmitBtn).waitUntilVisible();
		element(resubmitBtn).click();
	}

}
