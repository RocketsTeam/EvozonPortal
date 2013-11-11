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

public class NewVacationRequest extends PageObject {

    
	
	@FindBy(id="_1_WAR_EvozonKaleooFormsportlet_addVacationRequest")
	private WebElement newrequest;

	@FindBy(id="_1_WAR_EvozonKaleooFormsportlet_oshv")
			private WebElement concediuodihna;
	
	

	
	public NewVacationRequest(WebDriver driver) {
		super(driver);
	}
	
	public boolean check_new_request() {
    	
    	return element(newrequest).isPresent();
    	

}
	public boolean check_concediuodihna() {
	
		return element(concediuodihna).isPresent();
	

}
}

