package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.ControlPanelPage;
import com.pages.DepartmentPage;
import com.pages.DictionaryPage;
import com.pages.NewVacationRequest;
import com.pages.SubmitVacationRequest;
import com.pages.SummaryPage;
import com.pages.VacationRequestsPage;
import com.pages.VacationRequestsPageMihai;

public class ControlPanelSteps extends ScenarioSteps {

	DictionaryPage dictionaryPage;
	DepartmentPage depPage;
	SubmitVacationRequest VacPage;
	NewVacationRequest NewVac;
	VacationRequestsPageMihai vacReqPageMihai;
	VacationRequestsPage vacationRequestsPage;
	NewVacationRequest newVac;
	SummaryPage summaryPage;
	ControlPanelPage controlPanelPage;
	

	public ControlPanelSteps(Pages pages) {
		super(pages);

	}
	

	
	
	@Step
	public void clickGoToButton() {
		controlPanelPage.clickGoToButton();
	}
	
	
	@Step
	public void clickControlpanelButton() {
		controlPanelPage.clickControlPanelButton();
	}
	
	@Step
	public void clickEvoVacationLink() {
		controlPanelPage.clickOnEvoCancelVacationLink();
	}

}
