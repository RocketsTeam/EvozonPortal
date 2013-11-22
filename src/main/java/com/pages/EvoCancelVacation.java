package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import net.thucydides.core.pages.PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.opera.core.systems.scope.protos.ScopeProtos.MessageInfo;

public class EvoCancelVacation extends PageObject {

	@FindBy(css = ".concediu-label")
	private WebElement ddlTipConcediu;

	@FindBy(css = "ul.concediu-ul")
	private WebElement concediuListContainer;

	@FindBy(css = ".portlet-msg-info")
	private WebElement messageInfo;

	@FindBy(id = "_evocancelvacation_WAR_EvozonCancelVacationportlet_checkBetweenDatesCheckbox")
	private WebElement checkBox;

	@FindBy(id = "_1_WAR_EvozonKaleooFormsportlet_addVacationRequest")
	private WebElement vacationrequest;

	@FindBy(id = "_evocancelvacation_WAR_EvozonCancelVacationportlet_startMonth")
	private WebElement monthSubmit;

	@FindBy(id = "_evocancelvacation_WAR_EvozonCancelVacationportlet_startDay")
	private WebElement daySubmit;

	@FindBy(id = "_evocancelvacation_WAR_EvozonCancelVacationportlet_startYear")
	private WebElement yearSubmit;

	@FindBy(id = "_evocancelvacation_WAR_EvozonCancelVacationportlet_endMonth")
	private WebElement monthSubmitEnd;

	@FindBy(id = "_evocancelvacation_WAR_EvozonCancelVacationportlet_endDay")
	private WebElement daySubmitEnd;

	@FindBy(id = "_evocancelvacation_WAR_EvozonCancelVacationportlet_endYear")
	private WebElement yearSubmitEnd;

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

	public void selectCheckbox() {

		if (!element(checkBox).isSelected())
			element(checkBox).click();
	}

	public EvoCancelVacation(WebDriver driver) {
		super(driver);

	}

	public void click_ddlTipConcediu(String checkName) {
		element(ddlTipConcediu).waitUntilVisible();
		element(ddlTipConcediu).click();

		element(concediuListContainer).waitUntilVisible();
		List<WebElement> checkList = concediuListContainer.findElements(By
				.cssSelector("li span.aui-field-content"));

		for (WebElement elementNow : checkList) {
			String currentTerm = elementNow.getText();
			System.out.println("Current term: " + currentTerm);
			if (currentTerm.contains(checkName)) {
				WebElement checkBox = elementNow.findElement(By
						.cssSelector("input:last-child"));
				checkBox.click();
				try {
					Robot robot = new Robot();
					robot.mouseMove(200, 200);
				} catch (AWTException e) {

				}
				waitABit(2000);
				break;
			}
		}
	}

	public void verifySearchResults(String... terms) {
		String noOfPagesContainer = getDriver()
				.findElement(
						By.cssSelector("div.page-links > span.aui-paginator-current-page-report.aui-paginator-total"))
				.getText().trim();
		int noOfPages = SummaryPage.getAllIntegerNumbersFromString(
				noOfPagesContainer).get(1);
		System.out.println("noOfPages " + noOfPages);
		for (int i = 1; i <= noOfPages; i++) {
			waitABit(2000);

			List<WebElement> searchResults = getDriver()
					.findElements(
							By.cssSelector("table.taglib-search-iterator tr.results-row"));
			for (WebElement searchResult : searchResults) {
				if ($(searchResult).isCurrentlyVisible()) {
					for (String term : terms) {
						if (!searchResult.getText().toLowerCase()
								.contains(term.toLowerCase())) {
							Assert.fail(String
									.format("The '%s' search result item does not contain '%s'!",
											searchResult.getText(), term));
						}
					}
				}
			}
			if (i < noOfPages) {
				getDriver()
						.findElement(
								By.cssSelector("div.page-links > a.aui-paginator-link.aui-paginator-next-link"))
						.click();
			}
		}
	}

	public static void getListOfDatesBetweenDates(String str_date,
			String end_date) throws ParseException {
		List<Date> dates = new ArrayList<Date>();

		DateFormat formatter;

		formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date startDate = formatter.parse(str_date);
		Date endDate = formatter.parse(end_date);
		long interval = 24 * 1000 * 60 * 60; // 1 hour in millis
		long endTime = endDate.getTime(); // create your endtime here, possibly
											// using Calendar or Date
		long curTime = startDate.getTime();
		while (curTime <= endTime) {
			dates.add(new Date(curTime));
			curTime += interval;
		}
		for (int i = 0; i < dates.size(); i++) {
			Date lDate = dates.get(i);
			String ds = formatter.format(lDate);
			System.out.println(" Date is ..." + ds);
		}

	}

	public static void main(String[] args) throws ParseException {

		getListOfDatesBetweenDates("27/08/2010", "02/09/2010");
	}

}
