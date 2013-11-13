package com.steps;

import javax.servlet.http.HttpServletResponse;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import org.junit.Assert;

import com.pages.DepartmentPage;
import com.pages.DictionaryPage;
import com.pages.NewVacationRequest;
import com.pages.SubmitVacationRequest;
import com.pages.VacationRequestsPage;
import com.pages.VacationRequestsPageMihai;

public class VacationRequestsSteps extends ScenarioSteps {

	DictionaryPage dictionaryPage;
	DepartmentPage depPage;
	SubmitVacationRequest VacPage;
	NewVacationRequest NewVac;
	VacationRequestsPageMihai vacReqPageMihai;
	VacationRequestsPage vacationRequestsPage;
	NewVacationRequest newVac;
	VacationRequestsPageMihai vacReqPage;
	VacationRequestsPage ReqPage;

	public VacationRequestsSteps(Pages pages) {
		super(pages);
	}

	@Step
	public void myRoleListElementAction(String element, String action){
		ReqPage.markListEntry(element, action);
	}

	@Step
	public void enter_user(String keyword) {
		dictionaryPage.enter_user(keyword);
	}

	@Step
	public void enter_password(String keyword) {
		dictionaryPage.enter_password(keyword);
	}

	@Step
	public void submit() {
		dictionaryPage.click_submit();
	}

	@Step
	public void is_the_home_page() {
		dictionaryPage.open();
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

	@Step
	public void show_vacation_request_link() {
		Assert.assertTrue("Submit vacation request should appear",
				vacReqPageMihai.check_vacationrequest());
	}

	

	@Step
	public void should_be_Summary_link() {

	}

	

	
	@Step
	public void go_to_processes_section() {
		vacReqPageMihai.click_on_processes();
	}



	@Step
	public void go_to_vacation_reguest() {

	}


	@Step
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
	public void check_new_request(){
		Assert.assertTrue("A new vacation request sholud appear", NewVac.check_new_request());
	}

	@Step
	public void click_concediuo(){
		VacPage.click_vacationrequest();
	}

	@Step
	public void check_vacationre(){
		ReqPage.check_vacationreq();
	}

	@Step
	public void click_vacationre(){
		ReqPage.click_vacationreq();
	}

	@Step
	public void check_actionsbutton1(){
		ReqPage.check_actions1();
	}

	@Step
	public void click_actionsbutton1(){
		ReqPage.click_actions1();
	}

	@Step
	public void check_approveoption(){
		ReqPage.check_approve();
	}

	@Step
	public void click_approveoption(){
		ReqPage.click_approve();
	}

	@Step
	public void check_actionsbutton2(){
		ReqPage.check_actions2();
	}

	@Step
	public void click_actionsbutton2(){
		ReqPage.click_actions2();
	}

	@Step
	public void check_rejectoption(){
		ReqPage.check_reject();
	}

	@Step
	public void click_rejectoption(){
		ReqPage.click_reject();
	}

	@Step
	public void check_assigntopt(){
		ReqPage.check_assignto();
	}

	@Step
	public void click_assigntopt(){
		ReqPage.click_assignto();
	}
	
	@Step
	 public void click_AssignUser() {
	  vacationRequestsPage.click_AssignUser();
	 }
	
	@Step
	 public void select_a_person(String person) {
		vacationRequestsPage.click_to_a_person(person);
	 }
	
	@Step
	public void click_OK_button(){
		vacationRequestsPage.click_OK_button();
	}
	
	 @Step
	   	public void click_cancel_button(){
	   		vacationRequestsPage.click_cancel_button();
	   	}

	@Step
	public void check_updateduedateopt(){
		ReqPage.check_updateduedate();
	}

	@Step
	public void click_updateduedateopt(){
		ReqPage.click_updateduedate();
	}

	@Step
	public void check_actionsbutton() {
		vacationRequestsPage.check_actions();
	}

	@Step
	public void click_actionsbutton() {
		vacationRequestsPage.click_actions();
	}

	public void refresh_page() {
		vacationRequestsPage.refresh_page();
		
	}
	
    
	
   
}
