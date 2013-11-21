package com.pages;

import java.util.List;

import net.thucydides.core.pages.PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
				elementNow.findElement(By.cssSelector("input:last-child"))
						.click();
				break;
			}
		}
	}

	/*
	 * public static boolean checkIfTextContainsTerms(String text, boolean
	 * ignoreCase, String... strTerms) { text =
	 * removeNewLinesMultipleSpacesAndTabs(text); if (ignoreCase) text =
	 * text.toLowerCase(); for (String term : strTerms) { if (ignoreCase) term =
	 * term.toLowerCase(); if (!text.contains(term)) return false; } return
	 * true; }
	 * 
	 * public static String removeNewLinesMultipleSpacesAndTabs(String body) {
	 * body = body.replaceAll("[\0\t\n\r]", " "); body =
	 * body.replaceAll("&nbsp;", " "); while (body.indexOf("  ") != -1) { body =
	 * body.replaceAll("  ", " "); } return body; }
	 */

	public void verifySearchResults(String... terms) {
		String noOfPagesContainer = getDriver()
				.findElement(
						By.cssSelector("div.page-links > span.aui-paginator-current-page-report.aui-paginator-total"))
				.getText().trim();
		
		String message = getDriver()
				.findElement(
						By.cssSelector(".portlet-msg-info"))
				.getText().trim();
		System.out.println(message);
		int noOfPages = SummaryPage.getAllIntegerNumbersFromString(
				noOfPagesContainer).get(1);
		for (int i = 0; i < noOfPages; i++) {
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
			if (i < noOfPages - 1) {
				getDriver()
						.findElement(
								By.cssSelector("div.page-links > a.aui-paginator-link.aui-paginator-next-link"))
						.click();
				waitABit(2000);
				// waitFor(ExpectedConditions
				// .textToBePresentInElement(
				// By.cssSelector("div.page-links > span.aui-paginator-current-page-report.aui-paginator-total"),
				// String.format("(%d of %d)", i + 2, noOfPages)));
			}
		}
	}
	
	
}
