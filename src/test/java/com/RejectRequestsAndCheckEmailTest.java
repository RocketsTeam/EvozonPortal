package com;

import java.io.IOException;

import javax.mail.MessagingException;

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
import com.steps.CopyOfFolderFetchIMAPStep;
import com.steps.EndUserSteps;
import com.steps.UserStepsForVacation;

@Story(Application.RejectReqAndCheckEmail.RejectRequestsAndCheckEmailTest.class)
@RunWith(ThucydidesRunner.class)
//@UseTestDataFrom("resources/DataHandleRequest.csv")
public class RejectRequestsAndCheckEmailTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://172.22.8.38:9090")
	public Pages pages;

	/*String user, pass;

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
*/
	@Steps
	public EndUserSteps endUser;

	@Steps
	public UserStepsForVacation userStepsForVacation;
	
	@Steps
	public CopyOfFolderFetchIMAPStep copyOfFolderFetchIMAPStep;
	

	@Test
	public void test_csv_login() throws MessagingException,
	IOException {
		endUser.is_the_home_page();
		endUser.enter_user("QaDepartment123@gmail.com");
		endUser.enter_password("1234");
		endUser.submit();
		endUser.should_be_on_department_page();
		endUser.should_be_on_department_page1();
		endUser.click_v();
		userStepsForVacation.clickOnActionOptionForSpecifiedVacation(
				"Assigned to me", "Reject","");
		endUser.waitABit(5000);
		userStepsForVacation.clickConfirmingOK();
		userStepsForVacation.shouldShowConfirmingMessage();
		copyOfFolderFetchIMAPStep.CheckIfEmailContainsTerms("QaDepartment123", "1234567Qa", false, false, false, false, true, "dear","evoportal team");
	}
	
}
	

