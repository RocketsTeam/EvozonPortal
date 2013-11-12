 package com.steps;

import org.junit.Assert;

import com.pages.DepartmentPage;
import com.pages.DictionaryPage;
import com.pages.NewVacationRequest;
import com.pages.SubmitVacationRequest;
import com.pages.VacationRequestsPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import static ch.lambdaj.Lambda.join;
import static org.fest.assertions.Assertions.assertThat;

public class EndUserSteps extends ScenarioSteps {

    DictionaryPage dictionaryPage;
    DepartmentPage depPage;
    SubmitVacationRequest VacPage;
    NewVacationRequest NewVac;
    VacationRequestsPage ReqPage;

    public EndUserSteps(Pages pages) {
        super(pages);
    }

    @Step
    public void enter_user(String keyword) {
        dictionaryPage.enter_user(keyword);
    }

    
    @Step
    public void enter_password(String keyword) {
        dictionaryPage.enter_password(keyword);
    }
    
    @Step
    public void submit() {
        dictionaryPage.click_submit();
    }

    @Step
    public void is_the_home_page() {
        dictionaryPage.open();
    }
    
    @Step
    public void should_be_on_department_page() {
        Assert.assertTrue("Should be on department page", depPage.check_signout_link());
    }

    @Step
    public void should_be_on_department_page1(){
    	Assert.assertTrue("vacation sholud appear on department page", depPage.check_vacation());
    	
    }
    
    @Step
    public void click_v(){
    	depPage.click_vacation();
    }

	
    @Step
    public void vacation_request(){
    	Assert.assertTrue("Submit vacation request should appear", VacPage.check_vacationrequest());
    	
    }
    
    @Step
    public void v_req(){
   VacPage.click_vacationrequest();
	}
    
    
    @Step
    public void check_new_request(){
    	Assert.assertTrue("A new vacation request sholud appear", NewVac.check_new_request());
    }
    
    @Step
    public void click_concediuo(){
    	VacPage.click_vacationrequest();
    }
    
    @Step
    public void check_vacationre(){
    	ReqPage.check_vacationreq();
    }
    
    @Step
    public void click_vacationre(){
    	ReqPage.click_vacationreq();
    }
    
    
}








