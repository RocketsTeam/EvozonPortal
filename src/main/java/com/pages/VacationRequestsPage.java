package com.pages;

import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VacationRequestsPage extends PageObject {

    
	
	@FindBy(css="a[href*=inbox]")
	private WebElement vacationrequests;
	

	
	public VacationRequestsPage(WebDriver driver) {
		super(driver);
	}
	
	 public boolean check_vacationreq() {
	    	
	    	return element(vacationrequests).isPresent();
}
	 
	 public void click_vacationreq() {
	    	vacationrequests.click();
	    }
}