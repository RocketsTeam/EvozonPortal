package com.pages;

import java.util.List;

import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewVacationRequest extends PageObject {

	@FindBy(id = "_1_WAR_EvozonKaleooFormsportlet_addVacationRequest")
	private WebElement newrequest;

	

	@FindBy(id = "_1_WAR_EvozonKaleooFormsportlet_dateStart-dateMonth")
	private WebElement month;

	@FindBy(id = "_1_WAR_EvozonKaleooFormsportlet_dateStart-dateMonth")
	private WebElement MonthSelect;

	@FindBy(id = "_1_WAR_EvozonKaleooFormsportlet_dateStart-dateDay")
	private WebElement day;
	
	@FindBy(css = "fieldset.aui-fieldset")
	private WebElement radioButtonContainer;
	

	public NewVacationRequest(WebDriver driver) {
		super(driver);
	}

	public boolean check_new_request() {

		return element(newrequest).isPresent();

	}

	

	public void select_month() {
		month.click();
	}

	public void selectMonthDate(String monthName) {
		element(MonthSelect).waitUntilVisible();
		element(MonthSelect).selectByVisibleText(monthName).click();
		
		
		
	}

	
	
	
	public void select_day() {
		day.click();
	}
	
	
	public void selectRadioButton(String nameRadio){
		element(radioButtonContainer).waitUntilVisible();
		
		List<WebElement> radioButtonsList = radioButtonContainer.findElements(By.cssSelector("span.aui-field-choice"));

		theFor:
		for(WebElement elementNow:radioButtonsList){
			String currentText = elementNow.getText();
			if(currentText.contains(nameRadio)){
				elementNow.findElement(By.tagName("input")).click();
				break theFor;
			}
			
		}
		
		

		
		
	}

}
