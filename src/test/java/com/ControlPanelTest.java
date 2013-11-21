package com;

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
import com.steps.UserStepsForVacation;

@Story(Application.ControlPanel.ControlPanelTest.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom("resources/DataHandleRequest.csv")
public class ControlPanelTest {

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
	public void selectATipConcediuFromTheDropdownList() {
		endUser.is_the_home_page();
		endUser.enter_user(getUser());
		endUser.enter_password(getPass());
		endUser.submit();
		endUser.should_be_on_department_page();
		controlPanelSteps.clickGoToButton();
		controlPanelSteps.clickControlpanelButton();
		controlPanelSteps.clickEvoVacationLink();
		evoCancelStep.select_tip_concediu("Concediu de odihna");

	}
}
