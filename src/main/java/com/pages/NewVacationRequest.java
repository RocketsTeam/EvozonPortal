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

	@FindBy(css = "select#_1_WAR_EvozonKaleooFormsportlet_dateStart-dateMonth")
	private WebElement MonthSelect;

	@FindBy(id = "_1_WAR_EvozonKaleooFormsportlet_dateStart-dateDay")
	private WebElement day;

	@FindBy(css = "fieldset.aui-fieldset")
	private WebElement radioButtonContainer;
	
	@FindBy(id="_1_WAR_EvozonKaleooFormsportlet_dateStart-dateYear")
	private WebElement year;
	
	@FindBy(id="_1_WAR_EvozonKaleooFormsportlet_dateEnd-dateMonth")
	private WebElement MonthSelectEnddate;
	
	@FindBy(css=".popupMessageBox")
	private WebElement popupMessage;
	
	@FindBy(css=".popupClose")
	private WebElement closepopup;
	
	@FindBy(id="_1_WAR_EvozonKaleooFormsportlet_domeniul_text")
	private WebElement inputDomeniu;
	
	@FindBy(id="_1_WAR_EvozonKaleooFormsportlet_saveButton")
	private WebElement saveButton;
	
	@FindBy(css=".popupMessageBox")
	private WebElement showpopup;
	
	@FindBy(id="buttonTest")
	private WebElement calendarButton;
	
	@FindBy(css="a[href*=next]")
	private WebElement nextMonth;
	
	@FindBy(css=".yui3-widget-bd")
	private WebElement dayCalendar;
	

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
		MonthSelect.click();
		MonthSelect.click();
		element(MonthSelect).selectByVisibleText(monthName);
	}

	public void select_day(String dayNumber) {
		day.click();
		day.click();
		element(day).selectByVisibleText(dayNumber);
	}
	
	
	public void select_year(String yearNumber){
		year.click();
		year.click();
		element(year).selectByVisibleText(yearNumber);
	}

	
	public void selectMonthEnd(String monthNameEnd) {
		element(MonthSelectEnddate).waitUntilVisible();
		MonthSelectEnddate.click();
		MonthSelectEnddate.click();
		element(MonthSelectEnddate).selectByVisibleText(monthNameEnd);
	}
	
	public boolean check_popupMessage() {
		return element(popupMessage).isPresent();
	}
	
	public void close_popUp(){
		closepopup.click();
	}
	
	public void enter_domeniu(String key){
			element(inputDomeniu).waitUntilVisible();
	        element(inputDomeniu).type(key);
	}
	

	public void click_save(){
		saveButton.click();
	}
	
	public boolean check_secondpopup(){
			return element(popupMessage).isPresent();
	}
	
	
	public void click_calendarButton() {
		calendarButton.click();
	}
	
	
	public void select_nextMonth(){
		element(nextMonth).waitUntilVisible();
		nextMonth.click();
	
	}
	
	public void selectdayCalendar(String dayC) {
		element(dayCalendar).waitUntilVisible();
		dayCalendar.click();
		dayCalendar.click();
		element(dayCalendar).selectByVisibleText(dayC);
	}
	
	
	
	
	public void selectRadioButton(String nameRadio) {
		element(radioButtonContainer).waitUntilVisible();

		List<WebElement> radioButtonsList = radioButtonContainer
				.findElements(By.cssSelector("span.aui-field-choice"));

		theFor: for (WebElement elementNow : radioButtonsList) {
			String currentText = elementNow.getText();
			if (currentText.contains(nameRadio)) {
				elementNow.findElement(By.tagName("input")).click();
				break theFor;
			}

		}

	}
}
