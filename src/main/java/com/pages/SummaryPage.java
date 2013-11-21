package com.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import net.thucydides.core.pages.PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SummaryPage extends PageObject {

	public SummaryPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(css = ".portlet-msg-success")
	private WebElement confirmmessagepanel;

	@FindBy(css = ".aui-dialog-ft .aui-toolbar-first")
	private WebElement ConfirmOKButton;

	@FindBy(css = "ul.lfr-menu-list-overflow")
	private WebElement actionsContainer;

	@FindBy(css = ".lfr-search-container>div.lfr-search-container")
	private WebElement panels;

	public boolean checkForMessage() {
		element(confirmmessagepanel).waitUntilVisible();
		return element(confirmmessagepanel).isPresent();
	}

	public void click_Ok() {
		element(ConfirmOKButton).waitUntilVisible();

		ConfirmOKButton.click();
	}

	public static boolean checkIfTextContainsTerms(String text,
			boolean ignoreCase, String... strTerms) {
		text = removeNewLinesMultipleSpacesAndTabs(text);
		if (ignoreCase)
			text = text.toLowerCase();
		for (String term : strTerms) {
			if (ignoreCase)
				term = term.toLowerCase();
			if (!text.contains(term))
				return false;
		}
		return true;
	}

	public static String removeNewLinesMultipleSpacesAndTabs(String body) {
		body = body.replaceAll("[\0\t\n\r]", " ");
		body = body.replaceAll("&nbsp;", " ");
		while (body.indexOf("  ") != -1) {
			body = body.replaceAll("  ", " ");
		}
		return body;
	}

	public static <T> String getConcatenatedStringRepresentationOfTheElementsOfAnArray(
			String separator, T... itemsList) {
		String resultString = "";
		for (T item : itemsList) {
			Assert.assertTrue("Item to be concatenated should not be null!",
					item != null);
			resultString += separator + item.toString();
		}
		resultString = resultString.substring(separator.length());
		return resultString;
	}

	public WebElement waitUntilElementExists(By by, int waitSeconds) {
		getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement element = null;
		for (int i = 0; i < waitSeconds; i++)
			try {
				element = getDriver().findElement(by);
				getDriver().manage().timeouts()
						.implicitlyWait(30, TimeUnit.SECONDS);
				break;
			} catch (Exception e) {

			}
		Assert.assertTrue("The searched element was not found after "
				+ waitSeconds + " seconds!", element != null);
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return element;
	}

	/**
	 * Retrieves the last sequence of digits from a string
	 * 
	 * @param text
	 * @return
	 */
	public static Integer getLastIntegerNumberFromString(String text) {
		String intNumber = "";
		char[] characters = text.toCharArray();
		boolean foundDigit = false;
		for (int i = characters.length - 1; i >= 0; i--) {
			char ch = characters[i];
			if (Character.isDigit(ch)) {
				foundDigit = true;
				intNumber += ch;
			} else {
				if (foundDigit) {
					break;
				}
			}
		}
		Assert.assertTrue(
				"No matching integer was found in the provided string!",
				intNumber != "");
		return Integer
				.valueOf(new StringBuffer(intNumber).reverse().toString());
	}

	public static List<Integer> getAllIntegerNumbersFromString(String text) {
		List<Integer> listOfIntegers = new ArrayList<Integer>();
		String intNumber = "";
		char[] characters = text.toCharArray();
		boolean foundAtLeastOneInteger = false;
		for (char ch : characters) {
			if (Character.isDigit(ch)) {
				intNumber += ch;
			} else {
				if (intNumber != "") {
					foundAtLeastOneInteger = true;
					listOfIntegers.add(Integer.parseInt(intNumber));
					intNumber = "";
				}
			}
		}
		Assert.assertTrue(
				"No matching integer was found in the provided string!",
				foundAtLeastOneInteger);
		return listOfIntegers;
	}

	public List<WebElement> getVisibleElementsFromList(
			List<WebElement> elementsList) {
		for (int i = 0; i < elementsList.size(); i++) {
			WebElement element = elementsList.get(i);
			if (!$(element).isCurrentlyVisible()) {
				elementsList.remove(i);
				i--;
			}
		}
		return elementsList;
	}

	public boolean checkIfElementWithSpecifiedTextExistsInList(By by,
			boolean ignoreCase, boolean equals, String... terms) {
		getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		List<WebElement> elementsList = getVisibleElementsFromList(getDriver()
				.findElements(by));
		for (WebElement element : elementsList) {
			String currentElementName = element.getText().trim();
			if (ignoreCase)
				currentElementName = currentElementName.toLowerCase();
			boolean matched = false;
			if (terms.length == 1) {
				if (ignoreCase)
					matched = equals ? currentElementName.equals(terms[0]
							.toLowerCase()) : currentElementName
							.contains(terms[0].toLowerCase());
				else
					matched = equals ? currentElementName.equals(terms[0])
							: currentElementName.contains(terms[0]);
			} else
				matched = checkIfTextContainsTerms(currentElementName,
						ignoreCase, terms);
			if (matched)
				return true;
		}
		return false;
	}

	public WebElement getElementWithSpecifiedTextIfExistsInListInsideElement(
			By listContainer, By by, boolean ignoreCase, boolean equals,
			String... terms) {
		getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		List<WebElement> elementsList = getVisibleElementsFromList(getDriver()
				.findElement(listContainer).findElements(by));
		for (WebElement element : elementsList) {
			String currentElementName = element.getText().trim();
			if (ignoreCase)
				currentElementName = currentElementName.toLowerCase();
			boolean matched = false;
			if (terms.length == 1) {
				if (ignoreCase)
					matched = equals ? currentElementName.equals(terms[0]
							.toLowerCase()) : currentElementName
							.contains(terms[0].toLowerCase());
				else
					matched = equals ? currentElementName.equals(terms[0])
							: currentElementName.contains(terms[0]);
			} else
				matched = checkIfTextContainsTerms(currentElementName,
						ignoreCase, terms);
			if (matched)
				return element;
		}
		return null;
	}

	public WebElement getElementWithSpecifiedTextIfExistsInListInsideElement(
			WebElement listContainer, By by, boolean ignoreCase,
			boolean equals, String... terms) {
		getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		List<WebElement> elementsList = getVisibleElementsFromList(listContainer
				.findElements(by));
		for (WebElement element : elementsList) {
			String currentElementName = element.getText().trim();
			if (ignoreCase)
				currentElementName = currentElementName.toLowerCase();
			boolean matched = false;
			if (terms.length == 1) {
				if (ignoreCase)
					matched = equals ? currentElementName.equals(terms[0]
							.toLowerCase()) : currentElementName
							.contains(terms[0].toLowerCase());
				else
					matched = equals ? currentElementName.equals(terms[0])
							: currentElementName.contains(terms[0]);
			} else
				matched = checkIfTextContainsTerms(currentElementName,
						ignoreCase, terms);
			if (matched)
				return element;
		}
		return null;
	}

	public void mouseOver(WebElement element) {
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(element).build().perform();
	}

	public WebElement getElementWithSpecifiedTextIfExistsInList(By by,
			boolean ignoreCase, boolean equals, String... terms) {
		getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		List<WebElement> elementsList = getVisibleElementsFromList(getDriver()
				.findElements(by));
		for (WebElement element : elementsList) {
			String currentElementName = element.getText().trim();
			if (ignoreCase)
				currentElementName = currentElementName.toLowerCase();
			boolean matched = false;
			if (terms.length == 1) {
				if (ignoreCase)
					matched = equals ? currentElementName.equals(terms[0]
							.toLowerCase()) : currentElementName
							.contains(terms[0].toLowerCase());
				else
					matched = equals ? currentElementName.equals(terms[0])
							: currentElementName.contains(terms[0]);
			} else
				matched = checkIfTextContainsTerms(currentElementName,
						ignoreCase, terms);
			if (matched)
				return element;
		}
		return null;
	}

	public WebElement getElementWithSpecifiedTextFromList(By by,
			boolean ignoreCase, boolean equals, String... terms) {
		waitUntilElementExists(by, 30);
		waitForRenderedElements(by);
		List<WebElement> elementsList = getVisibleElementsFromList(getDriver()
				.findElements(by));
		for (WebElement element : elementsList) {
			mouseOver(element);
			String currentElementName = element.getText().trim();
			System.out.println("currentElementName " + currentElementName);
			if (ignoreCase)
				currentElementName = currentElementName.toLowerCase();
			boolean matched = false;
			System.out.println("terms.length " + terms.length);
			System.out.println("************************ " + terms[0]);
			if (terms.length == 1) {
				if (ignoreCase)
					matched = equals ? currentElementName.equals(terms[0]
							.toLowerCase()) : currentElementName
							.contains(terms[0].toLowerCase());
				else
					matched = equals ? currentElementName.equals(terms[0])
							: currentElementName.contains(terms[0]);
			} else
				matched = checkIfTextContainsTerms(currentElementName,
						ignoreCase, terms);
			if (matched)
				return element;
		}
		Assert.fail("No element matching these terms: '"
				+ getConcatenatedStringRepresentationOfTheElementsOfAnArray(
						", ", terms) + "' was found in the table!");
		return null;
	}

	public WebElement getVacationRowFromTable(String tableLabel,
			By listElements, String... terms) {
		WebElement tableContainer = getElementWithSpecifiedTextFromList(
				By.cssSelector("div.lfr-panel.lfr-collapsible.lfr-panel-basic"),
				true, false, tableLabel);
		WebElement searchedRow = getElementWithSpecifiedTextIfExistsInListInsideElement(
				tableContainer, listElements, true, false, terms);
		boolean foundRow = false;
		if (searchedRow == null) {
			System.out
					.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! "
							+ tableContainer
									.findElement(
											By.cssSelector("div.taglib-search-iterator-page-iterator-bottom > div > div.search-pages > div.page-links > span.aui-paginator-current-page-report.aui-paginator-total:last-of-type"))
									.getText());
			int noOfPages = getAllIntegerNumbersFromString(
					tableContainer
							.findElement(
									By.cssSelector("div.taglib-search-iterator-page-iterator-bottom > div > div.search-pages > div.page-links > span.aui-paginator-current-page-report.aui-paginator-total:last-of-type"))
							.getText()).get(1);
			noOfPages--;
			while (noOfPages > 0 && !foundRow) {
				WebElement nextPageButton = tableContainer
						.findElement(By
								.cssSelector("div.taglib-search-iterator-page-iterator-bottom > div > div.search-pages > div.page-links > a.aui-paginator-link.aui-paginator-next-link"));
				nextPageButton.click();
				searchedRow = getElementWithSpecifiedTextIfExistsInListInsideElement(
						tableContainer, listElements, true, false, terms);
				if (searchedRow != null) {
					foundRow = true;
					break;
				}

				noOfPages--;
			}
		}
		return searchedRow;
	}

	public void clickOnActionOptionForSpecifiedVacation(String tableLabel,
			String buttonLabel, String... terms) {
		WebElement searchedRow = getVacationRowFromTable(
				tableLabel,
				By.cssSelector("div.lfr-panel-content > div.lfr-search-container > div:first-child table tr.results-row"),
				terms);
		searchedRow.findElement(By.cssSelector("td:last-child a > span"))
				.click();
		WebElement actionOption = getElementWithSpecifiedTextFromList(
				By.cssSelector("div.lfr-component.lfr-menu-list > ul.lfr-menu-list-overflow > li > a"),
				true, false, buttonLabel);
		System.out.println("################################################# "
				+ actionOption.getText());

		actionOption.click();
	}
}
