package com.pages;

import java.util.List;

import net.thucydides.core.pages.PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EvoVacationHistoryPage extends PageObject {

	@FindBy(id = "_evocontrolpanelvacationhistory_WAR_EvozonControlPanelVacationHistoryportlet_toggle_id_directory_history_searchkeywords")
	public WebElement searchInputBar;

	@FindBy(css = "span.aui-button.aui-button-submit input[value='Search']")
	public WebElement searchButton;

	public EvoVacationHistoryPage(WebDriver driver) {
		super(driver);

	}

	public void enterSearchText(String keyword) {
		element(searchInputBar).waitUntilVisible();
		element(searchInputBar).type(keyword);
	}

	public void submitSearch() {
		element(searchButton).click();

	}

	public void verifySearchResultsContainsItem(String... terms) {
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
				waitFor(ExpectedConditions
						.textToBePresentInElement(
								By.cssSelector("div.page-links > span.aui-paginator-current-page-report.aui-paginator-total"),
								String.format("(%d of %d)", i + 2,
										noOfPages)));
			}
		}
	}
}
