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
import com.steps.UserStepsForVacation;

@Story(Application.HandleRequests.HandleRequestsTest.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom("resources/loginData.csv")
public class HandleRequestsTest {

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

	@Test
	public void test_csv_login() {
		endUser.is_the_home_page();
		endUser.enter_user(getUser());
		endUser.enter_password(getPass());
		endUser.submit();
		endUser.should_be_on_department_page();
		endUser.should_be_on_department_page1();
		endUser.click_v();

//		endUser.check_vacationre();
//		endUser.click_vacationre();
		// endUser.check_vacationre();
		// endUser.click_vacationre();

		// endUser.should_be_a_Vacation_Request_link();
		// endUser.should_go_to_vacation_reguest();
		// endUser.should_be_a_Processes_link();
		// endUser.go_to_processes_section();
		// endUser.show_vacation_request_link();
		// endUser.clink_on_vacation_request_link();
		// endUser.should_show_processes_table();

		// endUser.getDriver().get("http://172.22.8.38:9090/web/qa-department/vacation?p_p_id=1_WAR_EvozonKaleooFormsportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_1_WAR_EvozonKaleooFormsportlet_tabs2=my-completed-requests");
		// endUser.retrieveMyVacationCompletedRequests();
		userStepsForVacation.clickOnActionOptionForSpecifiedVacation(
				"Assigned to Me", "Assigned to...", "update", "Admin test",
				"6/11/13 4:57 PM", "6/11/2013 - 6/11/2013");
	}
}
