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
import com.steps.VacationRequestsSteps;

@Story(Application.OKDateReq.OKDueDateTest.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom("resources/loginIulia.csv")
public class OKDueDateTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl ="http://172.22.8.38:9090")
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
	public VacationRequestsSteps vacationrequestSteps;




	@Test
	public void test_csv_login() {
		endUser.is_the_home_page();
		endUser.enter_user(getUser());
		endUser.enter_password(getPass());
		endUser.submit();
		endUser.should_be_on_department_page();
		endUser.should_be_on_department_page1();
		endUser.click_v();
		endUser.check_actionsbutton2();
		endUser.click_actionsbutton2();
	    endUser.check_updateduedateopt();
	    endUser.click_updateduedateopt();
	    vacationrequestSteps.click_OKduedateopt();
	    

	}



}





