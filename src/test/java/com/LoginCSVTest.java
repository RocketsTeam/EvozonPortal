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

@Story(Application.Login.LoginCSVTest.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom("resources/loginDataNina.csv")
public class LoginCSVTest {

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
	public void loginTest() {

		submitNewVacationRequest.is_the_home_page();
		submitNewVacationRequest.enter_user(getUser());
		submitNewVacationRequest.enter_password(getPass());
		submitNewVacationRequest.submit();
		submitNewVacationRequest.should_be_on_department_page();
		submitNewVacationRequest.should_be_on_department_page1();
		submitNewVacationRequest.click_v();
		submitNewVacationRequest.check_new_request();
		submitNewVacationRequest.v_req();
		submitNewVacationRequest
				.selectTipConcediu("Concediu fara plata * (Required)");
		submitNewVacationRequest.click_month("December");
		submitNewVacationRequest.click_day("24");
		submitNewVacationRequest.click_year("2013");
		submitNewVacationRequest.click_monthEndDate("December");
		submitNewVacationRequest.sholud_appear_popup();

	}
}
