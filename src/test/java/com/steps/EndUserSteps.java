package com.steps;

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

public class EndUserSteps extends ScenarioSteps {

	DictionaryPage dictionaryPage;
	DepartmentPage depPage;
	SubmitVacationRequest VacPage;
	NewVacationRequest newVac;
	VacationRequestsPageMihai vacReqPageMihai;
	VacationRequestsPage vacationRequestsPage;

	public EndUserSteps(Pages pages) {
		super(pages);
	}

	@Step
	public void myRoleListElementAction(String element, String action) {
		vacationRequestsPage.markListEntry(element, action);
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
		getDriver().manage().window().maximize();
	}

	@Step
	public void retrieveMyVacationCompletedRequests() {
		vacReqPageMihai.getMyVacationCompletedRequests();
	}

	@Step
	public void should_be_on_department_page() {
		Assert.assertTrue("Should be on department page",
				depPage.check_signout_link());
	}

	@Step
	public void should_show_processes_table() {
		Assert.assertTrue("Should be on department page",
				vacReqPageMihai.check_for_processes_table());
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
	public void clink_on_vacation_request_link() {
		vacReqPageMihai.click_vacationrequest();
	}

	@Step
	public void should_be_Summary_link() {
		// Assert.assertTrue("Should be a Vacation Request",
		// vacReqPageMihai.check_for_summary_link());
	}

	@Step
	public void should_be_a_Processes_link() {
		Assert.assertTrue("Should be a Vacation Request",
				vacReqPageMihai.check_for_processes_link());
	}

	/**
	 * @Step public void should_go_to_summary_section() { //
	 *       vacReqPageMihai.click_on_summary(); }
	 */

	@Step
	public void go_to_processes_section() {
		vacReqPageMihai.click_on_processes();
	}

	/*
	 * @Step public void should_be_a_Vacation_Request_link() { //
	 * Assert.assertTrue("Should be a Vacation Request", //
	 * vacReqPageMihai.check_vacationrequest()); }
	 */

	@Step
	public void go_to_vacation_reguest() {
		// vacReqPageMihai.click_vacationrequest();
	}

	/*
	 * @Step public void check_new_request() {
	 * Assert.assertTrue("A new vacation request sholud appear",
	 * NewVac.check_new_request()); }
	 */

	/*
	 * @Step public void click_concediuo() { VacPage.click_vacationrequest(); }
	 */

	// @Step
	// public void check_vacationre() {
	// ReqPage.check_vacationreq();
	// }

	// @Step
	// public void click_vacationre() {
	// ReqPage.click_vacationreq();
	// }

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
	public void should_go_to_summary_section() {
		vacReqPageMihai.click_on_summary();
	}

	@Step
	public void should_go_to_processes_section() {
		vacReqPageMihai.click_on_processes();
	}

	@Step
	public void should_be_a_Vacation_Request_link() {
		Assert.assertTrue("Should be a Vacation Request",
				vacReqPageMihai.check_vacationrequest());
	}

	@Step
	public void should_go_to_vacation_reguest() {
		vacReqPageMihai.click_vacationrequest();
	}

	@Step
	public void check_new_request() {
		Assert.assertTrue("A new vacation request sholud appear",
				newVac.check_new_request());
	}

	@Step
	public void click_concediuo() {
		VacPage.click_vacationrequest();
	}

	@Step
	public void check_vacationre() {
		vacationRequestsPage.check_vacationreq();
	}

	@Step
	public void click_vacationre() {
		vacationRequestsPage.click_vacationreq();
	}

	@Step
	public void check_actionsbutton1() {
		vacationRequestsPage.check_actions1();
	}

	@Step
	public void click_actionsbutton1() {
		vacationRequestsPage.click_actions1();
	}

	@Step
	public void check_approveoption() {
		vacationRequestsPage.check_approve();
	}

	@Step
	public void click_approveoption() {
		vacationRequestsPage.click_approve();
	}

	@Step
	public void check_actionsbutton2() {
		vacationRequestsPage.check_actions2();
	}

	@Step
	public void click_actionsbutton2() {
		vacationRequestsPage.click_actions2();
	}

	@Step
	public void check_rejectoption() {
		vacationRequestsPage.check_reject();
	}

	@Step
	public void click_rejectoption() {
		vacationRequestsPage.click_reject();
	}

	@Step
	public void check_assigntopt() {
		vacationRequestsPage.check_assignto();
	}

	@Step
	public void click_assigntopt() {
		vacationRequestsPage.click_assignto();
	}

	@Step
	public void check_updateduedateopt() {
		vacationRequestsPage.check_updateduedate();
	}

	@Step
	public void click_updateduedateopt() {
		vacationRequestsPage.click_updateduedate();
	}

	@Step
	public void check_actionsbutton() {
		vacationRequestsPage.check_actions();
	}

	@Step
	public void click_actionsbutton() {
		vacationRequestsPage.click_actions();
	}

	@Step
	public void click_month() {
		newVac.select_month();

	}

	// @Step
	// public void click_concediuo() {
	// newVac.click_concediufaraplata();
	// }

	@Step
	public void click_month1() {
		String monthName = "December";
		newVac.selectMonthDate(monthName);

	}

	@Step
	public void click_day() {
		newVac.select_day();

	}

	@Step
	public void selectTipConcediu(String concediu) {
		newVac.selectRadioButton(concediu);
	}
}
