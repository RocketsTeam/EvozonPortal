package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.ControlPanelPage;
import com.pages.DepartmentPage;
import com.pages.DictionaryPage;
import com.pages.EvoCancelVacation;
import com.pages.EvoVacationHistoryPage;
import com.pages.NewVacationRequest;
import com.pages.SubmitVacationRequest;
import com.pages.SummaryPage;
import com.pages.VacationRequestsPage;
import com.pages.VacationRequestsPageMihai;

public class EvoHistorySteps extends ScenarioSteps {

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
	EvoVacationHistoryPage evovacationHistoryPage;

	public EvoHistorySteps(Pages pages) {
		super(pages);

	}

	@Step
	public void enterSearchImput(String keyword) {
		evovacationHistoryPage.enterSearchText(keyword);
	}
	
	@Step
	public void verifySearchResultsContainsItem(String... terms) {
		evovacationHistoryPage.verifySearchResultsContainsItem(terms);
	}

	@Step
	public void submitSearch() {
		evovacationHistoryPage.submitSearch();
	}

}
