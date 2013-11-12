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

import javax.swing.text.html.CSS;

import static ch.lambdaj.Lambda.convert;

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