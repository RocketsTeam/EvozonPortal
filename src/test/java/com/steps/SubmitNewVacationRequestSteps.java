package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.pages.DepartmentPage;
import com.pages.DictionaryPage;

import com.pages.MyVacationCompletedRequestsPage;
import com.pages.NewVacationRequest;
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

public class SubmitNewVacationRequestSteps extends ScenarioSteps {

	DictionaryPage dictionaryPage;
	DepartmentPage depPage;
	SubmitVacationRequest VacPage;
	NewVacationRequest NewVac;
	VacationRequestsPageMihai vacReqPageMihai;
	VacationRequestsPage vacationRequestsPage;
	NewVacationRequest newVac;
	VacationRequestsPageMihai vacReqPage;
	VacationRequestsPage ReqPage;
	MyVacationCompletedRequestsPage myVacationCompletedRequestPage;
	
	public SubmitNewVacationRequestSteps(Pages pages) {
		super(pages);
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
	public void click_month(String monthName) {
		newVac.selectMonthDate(monthName);
	}

	@Step
	public void selectTipConcediu(String concediu) {
		newVac.selectRadioButton(concediu);
	}

	@Step
	public void click_day(String day) {
		newVac.select_day(day);

	}

	@Step
	public void click_year(String year) {
		newVac.select_year(year);
	}

	@Step
	public void click_monthEndDate(String monthNameEnd) {
		newVac.selectMonthEnd(monthNameEnd);

	}

	@Step
	public void sholud_appear_popup() {
		Assert.assertTrue("A pop up message sholud appear",
				newVac.check_popupMessage());
	}

	@Step
	public void close_pop_up() {
		newVac.close_popUp();
	}

	@Step
	public void enterdomeniu(String key) {
		newVac.enter_domeniu(key);
	}

	@Step
	public void click_saveButton() {
		newVac.click_save();
	}

	@Step
	public void show_popup() {
		Assert.assertTrue("A pop up message sholud appear",
				newVac.check_secondpopup());

	}

	@Step
	public void click_on_calendarButton() {
		newVac.click_calendarButton();
	}

	@Step
	public void click_nextMonth() {
		newVac.select_nextMonth();
	}

	@Step
	public void click_dayCalendar(String dayC) {
		newVac.selectdayCalendar(dayC);
	}
	
	@Step
	public void Click_MyVacationCompletedLink(){
		myVacationCompletedRequestPage.click_MyVacationCompletedLink();
	
	}
	
	@Step
	 public void verifySearchResultsContainsItem(String... terms) {
	  myVacationCompletedRequestPage.verifySearchResults(terms);
	 }
}


