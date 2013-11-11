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

public class DepartmentPage extends PageObject {

    /* @FindBy(name="search")
	private WebElement searchTerms;*/
	
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



