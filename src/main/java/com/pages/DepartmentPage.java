package com.pages;

import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DepartmentPage extends PageObject {
	
	@FindBy(css="span.sign-out a")
	private WebElement signOutLink;
	
	@FindBy(css ="a[href*=vacation]")
	private WebElement vacation;
	

	
	public DepartmentPage(WebDriver driver) {
		super(driver);
	}

    public boolean check_signout_link() {
    	
    	return element(signOutLink).isPresent();
    }
    
    public boolean check_vacation() {
    	return element(vacation).isPresent();
    }
    
    public void click_vacation() {
    	vacation.click();
    }
}



