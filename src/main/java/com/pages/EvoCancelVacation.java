package com.pages;

import java.util.List;

import net.thucydides.core.pages.PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EvoCancelVacation extends PageObject {

	@FindBy(css = ".concediu-label")
	private WebElement ddlTipConcediu;

	@FindBy(css = "ul.concediu-ul")
	private WebElement concediuListContainer;

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

/*	public String getTheDropdownListItemsName(String checkName) {

		List<WebElement> checkList = concediuListContainer.findElements(By
				.cssSelector("li span.aui-field-content"));
		 for (WebElement elementNow : checkList) {
			String currentTerm = elementNow.getText();
			//System.out.println("Current term: " + currentTerm);
			if (currentTerm.contains(checkName)) {
				elementNow.findElement(By.cssSelector("input:last-child"));
				return currentTerm;
				
		
			}
		 }
		
		return "";
	}*/

	public void verifySearchResults(String... terms) {
		String noOfPagesContainer = getDriver()
				.findElement(
						By.cssSelector("div.page-links > span.aui-paginator-current-page-report.aui-paginator-total"))
				.getText().trim();
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
			}
		}
	}
}
