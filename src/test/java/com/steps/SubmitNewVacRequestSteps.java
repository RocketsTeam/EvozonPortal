package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.pages.DepartmentPage;
import com.pages.DictionaryPage;
import com.pages.NewVacationRequest;
import com.pages.SubmitVacRequestPage;
import com.pages.SubmitVacationRequest;
import com.pages.VacationRequestsPage;
import com.pages.VacationRequestsPageMihai;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import static ch.lambdaj.Lambda.join;
import static org.fest.assertions.Assertions.assertThat;
import com.pages.VacationRequestsPage;
import com.pages.VacationRequestsPageMihai;

public class SubmitNewVacRequestSteps extends ScenarioSteps {

	DictionaryPage dictionaryPage;
	DepartmentPage depPage;
	SubmitVacationRequest VacPage;
	NewVacationRequest NewVac;
	VacationRequestsPageMihai vacReqPageMihai;
	VacationRequestsPage vacationRequestsPage;
	NewVacationRequest newVac;
	VacationRequestsPageMihai vacReqPage;
	VacationRequestsPage ReqPage;
	SubmitVacRequestPage submitPage;
	

	public SubmitNewVacRequestSteps(Pages pages) {
		super(pages);
	}

	
	@Step
	public void submit() {
		dictionaryPage.click_submit();
	}

	@Step
	public void is_the_home_page() {
		dictionaryPage.open(); }
	
	@Step
	public void enter_user(String keyword) {
		dictionaryPage.enter_user(keyword);
	}

	@Step
	public void enter_password(String keyword) {
		dictionaryPage.enter_password(keyword);
	}
	
	@Step
	public void should_be_on_department_page() {
		Assert.assertTrue("Should be on department page",
				depPage.check_signout_link());
	}
	
	@Step
	public void should_be_on_department_page1() {
		Assert.assertTrue("vacation sholud appear on department page",
				depPage.check_vacation());

	}
	
	public void click_v() {
		depPage.click_vacation();
	}

	@Step
	public void vacation_request() {
		Assert.assertTrue("Submit vacation request should appear",
				VacPage.check_vacationrequest());

	}
	
	@Step
	public void v_req() {
		VacPage.click_vacationrequest();
	}
	
	
	@Step
	public void check_new_request() {
		Assert.assertTrue("A new vacation request sholud appear",
				NewVac.check_new_request());
	}
		
	@Step
	 public void click_monthStartName(String monthName) { 
		submitPage.selectMonthSubmit(monthName);
	}
	
	@Step
	 public void click_dayStartName(String dayName) { 
		submitPage.selectDaySubmit(dayName);  
	}
	
	@Step
	 public void click_yearStartName(String yearName) {  
		submitPage.selectYearSubmit(yearName);  
	}
	
	@Step
	 public void click_monthEndName(String monthEndName) { 
		submitPage.selectMonthSubmit(monthEndName);
	}
	
	@Step
	 public void click_dayEndName(String dayEndName) { 
		submitPage.selectDaySubmit(dayEndName);  
	}
	
	@Step
	 public void click_yearEndName(String yearEndName) {  
		submitPage.selectYearSubmit(yearEndName);  
	}


	
		
}


