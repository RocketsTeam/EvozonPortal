package com;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.requirements.Application;
import com.steps.EndUserSteps;
import com.steps.VacationRequestsSteps;

@Story(Application.CommAssignReq.CommAssignToTest.class)
@RunWith(ThucydidesRunner.class)

public class CommAssignToTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl ="http://172.22.8.38:9090")
	public Pages pages;

	

	@Steps
	public EndUserSteps endUser;
	
	@Steps
	public VacationRequestsSteps vacationrequestSteps;




	@Test
	public void test_CommentAssignTo() {
		endUser.is_the_home_page();
		endUser.enter_user("iulia.drinda@evozon.com");
		endUser.enter_password("123");
		endUser.submit();
		endUser.should_be_on_department_page();
		endUser.should_be_on_department_page1();
		endUser.click_v();
		endUser.check_actionsbutton2();
		endUser.click_actionsbutton2();
	    endUser.check_assigntopt();
	    endUser.click_assigntopt();
	    vacationrequestSteps.select_a_person("Admin test");
	    vacationrequestSteps.enter_comm("test");
	    vacationrequestSteps.click_OK_button();
        

	}



}





