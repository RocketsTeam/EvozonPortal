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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.requirements.Application;
import com.steps.CheckEmailSteps;
import com.steps.EndUserSteps;
import com.steps.SubmitNewVacationRequestSteps;
import com.steps.VacationRequestsSteps;

@Story(Application.CheckEm2.CheckEmail2.class)
@RunWith(ThucydidesParameterizedRunner.class)
public class CheckEmail2 {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;


   // @ManagedPages(defaultUrl ="http://172.22.8.38:9090")
    //public Pages pages;
    
    //String user, pass;
    
   // @Qualifier
   // public String getUser() {
	///	return user;
	///}

	//public void setUser(String user) {
		//this.user = user;
	//}

	//public String getPass() {
		//return pass;
	//}

	//public void setPass(String pass) {
		//this.pass = pass;
	//}


    
    @Steps
	public CheckEmailSteps CheckEmail;
	

	@Test
	public void testEmail() throws MessagingException, IOException {
		
		CheckEmail.setLogin("imap.googlemail.com", "qadefaultuser", "1234567890Qa", "Approved", "EvoPortal");
	}
}

