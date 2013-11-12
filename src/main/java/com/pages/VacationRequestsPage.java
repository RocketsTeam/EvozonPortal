package com.pages;

import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VacationRequestsPage extends PageObject {

    
	
	@FindBy(css="a[href*=inbox]")
	private WebElement vacationrequests;
	
	@FindBy(id="_1_WAR_EvozonKaleooFormsportlet_workflowTasksSearchContainer_1_menuButton")
	private WebElement actions;

	
	public VacationRequestsPage(WebDriver driver) {
		super(driver);
	}
	
	 public boolean check_vacationreq() {
	    	
	    	return element(vacationrequests).isPresent();
}
	 
	 public void click_vacationreq() {
	    	vacationrequests.click();
	    }
	 
	 public boolean check_actions() {
	    	
	    	return element(actions).isPresent();
      }
	 public void click_actions() {
	    	actions.click();
	    }
	 
}