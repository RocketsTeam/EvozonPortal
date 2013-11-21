package com.pages;

import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AssignedToMePage extends PageObject {

	@FindBy(css = "a[href*=inbox]")
	private WebElement vacationrequests;
	
	@FindBy(id ="_1_WAR_EvozonKaleooFormsportlet_workflowTasksSearchContainer_1_menuButton")
	private WebElement actionsAssignedToMeSection;
	
	@FindBy(css =".taglib-icon.lfr-delegate-click.aui-focus")
	private WebElement resubmitBtn;
	
	@FindBy(id ="_1_WAR_EvozonKaleooFormsportlet_comment")
	private WebElement comment;
	
	@FindBy(id ="aui-buttonitem-content yui3-widget aui-component aui-buttonitem aui-state-default aui-buttonitem-label-only aui-toolbar-first aui-toolbar-item aui-buttonitem-focused")
	private WebElement OKBtn;
	
	@FindBy(id ="aui-buttonitem-content yui3-widget aui-component aui-buttonitem aui-state-default aui-buttonitem-label-only aui-toolbar-last aui-toolbar-item aui-buttonitem-focused aui-state-hover")
	private WebElement CancelBtn;
	
	
	
	
	
	
	public AssignedToMePage(WebDriver driver) {
		super(driver);
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
	
	public void enter_comment(String keyword) {
		element(comment).waitUntilVisible();
		element(comment).type(keyword);
	}

	public void click_OKBtn() {
		element(OKBtn).waitUntilVisible();
		element(OKBtn).click();
	}

	public void click_CancelDueDate() {
		element(CancelBtn).waitUntilVisible();
		element(CancelBtn).click();
	}

	
	

	
}
