package com;

import java.text.ParseException;
import java.util.Date;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.requirements.Application;
import com.steps.ControlPanelSteps;
import com.steps.EndUserSteps;
import com.steps.EvoCancelStep;
import com.steps.SubmitNewVacRequestSteps;
import com.steps.UserStepsForVacation;
import com.tools.DateUtils;

@Story(Application.EvoCancel.EvoCancelVacationTest.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom("resources/DataHandleRequest.csv")
public class EvoCancelVacationTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://172.22.8.38:9090")
	public Pages pages;

	String user, pass;

	@Qualifier
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Steps
	public EndUserSteps endUser;

	@Steps
	public UserStepsForVacation userStepsForVacation;

	@Steps
	public ControlPanelSteps controlPanelSteps;

	@Steps
	public EvoCancelStep evoCancelStep;

	@Test
	public void evoCancelVacationTest() throws ParseException {
		endUser.is_the_home_page();
		endUser.enter_user(getUser());
		endUser.enter_password(getPass());
		endUser.submit();
		endUser.should_be_on_department_page();
		controlPanelSteps.clickGoToButton();
		controlPanelSteps.clickControlpanelButton();
		controlPanelSteps.clickEvoVacationLink();
		evoCancelStep.selectTheCheckBox();
		evoCancelStep.click_dayStartName("20");
		evoCancelStep.click_monthStartName("May");
		evoCancelStep.click_yearStartName("2013");
		evoCancelStep.click_dayEndName("20");
		evoCancelStep.click_monthEndName("August");
		evoCancelStep.click_yearEndName("2013");
		evoCancelStep.select_tip_concediu("Concediu de odihna");
		evoCancelStep.verifySearchResultsContainsItems("Concediu de odihna");
		evoCancelStep.verifyStartDateResults("20 May 2013");
		evoCancelStep.verifyEndDateResults("20 August 2013");

	}
}
