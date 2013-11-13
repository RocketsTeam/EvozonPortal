package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.DepartmentPage;
import com.pages.DictionaryPage;
import com.pages.NewVacationRequest;
import com.pages.SubmitVacationRequest;
import com.pages.SummaryPage;
import com.pages.VacationRequestsPage;
import com.pages.VacationRequestsPageMihai;

public class UserStepsForVacation extends ScenarioSteps {

	DictionaryPage dictionaryPage;
	DepartmentPage depPage;
	SubmitVacationRequest VacPage;
	NewVacationRequest NewVac;
	VacationRequestsPageMihai vacReqPageMihai;
	VacationRequestsPage vacationRequestsPage;
	NewVacationRequest newVac;
	SummaryPage summaryPage;

	public UserStepsForVacation(Pages pages) {
		super(pages);

	}

	@Step
	public void clickOnActionOptionForSpecifiedVacation(String tableLabel,
			String buttonLabel, String... terms) {
		summaryPage.clickOnActionOptionForSpecifiedVacation(tableLabel,
				buttonLabel, terms);
	}

}
