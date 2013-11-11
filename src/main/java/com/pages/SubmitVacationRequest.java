package com.pages;

import ch.lambdaj.function.convert.Converter;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

import static ch.lambdaj.Lambda.convert;

public class SubmitVacationRequest extends PageObject {

    /* @FindBy(name="search")
	private WebElement searchTerms;*/
	
	@FindBy(id="_1_WAR_EvozonKaleooFormsportlet_addVacationRequest")
	private WebElement vacationrequest;
	
	

	
	public SubmitVacationRequest(WebDriver driver) {
		super(driver);
	}
	
	 public boolean check_vacationrequest() {
	    	
	    	return element(vacationrequest).isPresent();
}
	 
	 public void click_vacationrequest() {
	    	vacationrequest.click();
	    }
}


    