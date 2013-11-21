package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
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

	public void waitForOneOfTheTermsToAppear(By by, int waitSeconds,
			String... terms) {
		boolean foundTerm = false;
		int count = 0;
		while (!foundTerm && count < waitSeconds * 10) {
			count++;
			waitABit(100);
			WebElement container = getDriver().findElement(by);
			String content = container.getText();
			for (String term : terms) {
				if (content.contains(term)) {
					foundTerm = true;
					break;
				}
			}
		}
		Assert.assertTrue(
				String.format(
						"None of the given terms was found in the element after %d seconds!",
						waitSeconds), foundTerm);
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
			waitForOneOfTheTermsToAppear(
					By.cssSelector("div.page-links > span.aui-paginator-current-page-report.aui-paginator-total"),
					10, String.format("(%d of %d)", i, noOfPages));
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

}
