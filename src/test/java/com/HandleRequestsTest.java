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

@Story(Application.HandleRequests.HandleRequestsTest.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom("resources/loginData.csv")
public class HandleRequestsTest {

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

    @Test
    public void test_csv_login() {
        endUser.is_the_home_page();
        endUser.enter_user(getUser());
        endUser.enter_password(getPass());
        endUser.submit();
       
    }
}



    
