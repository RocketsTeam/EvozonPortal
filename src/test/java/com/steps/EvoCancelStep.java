package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.ControlPanelPage;
import com.pages.DepartmentPage;
import com.pages.DictionaryPage;
import com.pages.EvoCancelVacation;
import com.pages.NewVacationRequest;
import com.pages.SubmitVacationRequest;
import com.pages.SummaryPage;
import com.pages.VacationRequestsPage;
import com.pages.VacationRequestsPageMihai;

public class EvoCancelStep extends ScenarioSteps {

	DictionaryPage dictionaryPage;
	DepartmentPage depPage;
	SubmitVacationRequest VacPage;
	NewVacationRequest NewVac;
	VacationRequestsPageMihai vacReqPageMihai;
	VacationRequestsPage vacationRequestsPage;
	NewVacationRequest newVac;
	SummaryPage summaryPage;
	ControlPanelPage controlPanelPage;
	EvoCancelVacation evoCancelVacation;

	public EvoCancelStep(Pages pages) {
		super(pages);

	}

	@Step
	public void select_tip_concediu(String tipConcediu) {
		evoCancelVacation.click_ddlTipConcediu(tipConcediu);
	}
	
	@Step
	public void selectTheCheckBox() {
		evoCancelVacation.selectCheckbox();
	}

	@Step
	public void verifySearchResultsContainsItems(String... terms) {
		evoCancelVacation.verifySearchResults(terms);
	}
	
	@Step
	public void click_monthStartName(String monthName) {
		evoCancelVacation.selectMonthSubmit(monthName);
	}

	@Step
	public void click_dayStartName(String dayName) {
		evoCancelVacation.selectDaySubmit(dayName);
	}

	@Step
	public void click_yearStartName(String yearName) {
		evoCancelVacation.selectYearSubmit(yearName);
	}

	@Step
	public void click_monthEndName(String monthEndName) {
		evoCancelVacation.selectMonthEndSubmit(monthEndName);
	}

	@Step
	public void click_dayEndName(String dayEndName) {
		evoCancelVacation.selectDayEndSubmit(dayEndName);
	}

	@Step
	public void click_yearEndName(String yearEndName) {
		evoCancelVacation.selectYearEndSubmit(yearEndName);
	}

}
