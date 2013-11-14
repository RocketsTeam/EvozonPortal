package com.pages;

import java.util.List;

import net.thucydides.core.pages.PageObject;

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
}
