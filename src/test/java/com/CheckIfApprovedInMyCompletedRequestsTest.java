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
import com.steps.EndUserSteps;
import com.steps.SubmitNewVacationRequestSteps;
import com.steps.VacationRequestsSteps;

@Story(Application.CheckForApproved.CheckIfApprovedInMyCompletedRequestsTest.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom("resources/loginDataNina.csv")
public class CheckIfApprovedInMyCompletedRequestsTest {

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
	public SubmitNewVacationRequestSteps submitNewVacationRequest;
	@Steps
	public EndUserSteps endUser;
	@Steps
	public VacationRequestsSteps vacReqSteps;

	@Test
	public void checkIfApprovedInMyCompletedRequestsTest() {

		submitNewVacationRequest.is_the_home_page();
		submitNewVacationRequest.enter_user(getUser());
		submitNewVacationRequest.enter_password(getPass());
		submitNewVacationRequest.submit();
		submitNewVacationRequest.should_be_on_department_page();
		submitNewVacationRequest.should_be_on_department_page1();
		submitNewVacationRequest.click_v();
		submitNewVacationRequest.Click_MyVacationCompletedLink();
		submitNewVacationRequest.verifySearchResultsContainsItem("Approved");

	}
}
