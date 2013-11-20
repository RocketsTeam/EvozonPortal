package com.pages;

import ch.lambdaj.function.convert.Converter;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import net.thucydides.core.pages.PageObject;

import java.util.List;

import static ch.lambdaj.Lambda.convert;

public class SubmitVacRequestPage extends PageObject {

   
	@FindBy(id="_1_WAR_EvozonKaleooFormsportlet_addVacationRequest")
	private WebElement vacationrequest;
	
	@FindBy(id="_1_WAR_EvozonKaleooFormsportlet_dateStart-dateMonth")
	private WebElement monthSubmit;
	
	@FindBy(id = "_1_WAR_EvozonKaleooFormsportlet_dateStart-dateDay")
	private WebElement daySubmit;
	
	@FindBy(id = "._1_WAR_EvozonKaleooFormsportlet_dateStart-dateYear")
	private WebElement yearSubmit;
	
	@FindBy(id="_1_WAR_EvozonKaleooFormsportlet_dateEnd-dateMonth")
	private WebElement monthSubmitEnd;
	
	@FindBy(id="_1_WAR_EvozonKaleooFormsportlet_dateEnd-dateDay")
	private WebElement daySubmitEnd;
	
	@FindBy(id="_1_WAR_EvozonKaleooFormsportlet_dateEnd-dateYear")
	private WebElement yearSubmitEnd;
	

	
	public SubmitVacRequestPage(WebDriver driver) {
		super(driver);
	}
	
	 public boolean check_vacationrequest() {
	    	
	    	return element(vacationrequest).isPresent();
}
	 
	 public void click_vacationrequest() {
	    	vacationrequest.click();
	    }
	 
	 public void selectMonthSubmit(String monthName) {
		  element(monthSubmit).waitUntilVisible();
		  monthSubmit.click();
		  monthSubmit.click();
		  element(monthSubmit).selectByVisibleText(monthName);
	}
	 
	 public void selectDaySubmit(String dayName) {
		  element(daySubmit).waitUntilVisible();
		  daySubmit.click();
		  daySubmit.click();
		  element(daySubmit).selectByVisibleText(dayName);
	}
	
	 public void selectYearSubmit(String yearName) {
		  element(yearSubmit).waitUntilVisible();
		  yearSubmit.click();
		  yearSubmit.click();
		  element(yearSubmit).selectByVisibleText(yearName);
	}
	 
	 public void selectMonthEndSubmit(String monthEndName) {
		  element(monthSubmitEnd).waitUntilVisible();
		  monthSubmitEnd.click();
		  monthSubmitEnd.click();
		  element(monthSubmitEnd).selectByVisibleText(monthEndName);
	}
	 
	 public void selectDayEndSubmit(String dayEndName) {
		  element(daySubmitEnd).waitUntilVisible();
		  daySubmitEnd.click();
		  daySubmitEnd.click();
		  element(daySubmitEnd).selectByVisibleText(dayEndName);
	}
	
	 public void selectYearEndSubmit(String yearEndName) {
		  element(yearSubmitEnd).waitUntilVisible();
		  yearSubmitEnd.click();
		  yearSubmitEnd.click();
		  element(yearSubmitEnd).selectByVisibleText(yearEndName);
	}
	

	
	}



    