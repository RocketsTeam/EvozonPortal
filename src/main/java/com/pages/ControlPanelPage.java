package com.pages;

import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ControlPanelPage extends PageObject {

	 @FindBy(id = "_160_portlet_evocancelvacation_WAR_EvozonCancelVacationportlet")
	 private WebElement evoCancelVacationLink;
	 
	 @FindBy(id = "_160_portlet_evocontrolpanelvacationhistory_WAR_EvozonControlPanelVacationHistoryportlet")
	 private WebElement evoVacationHistoryLink;

	@FindBy(css = ".control-panel a")
	public WebElement controlPanelButton;
	
	

	@FindBy(css = "li.my-sites a.menu-button span")
	private WebElement goToButton;

	public ControlPanelPage(WebDriver driver) {
		super(driver);

	}
	public void clickOnEvoCancelVacationLink() {
		element(evoCancelVacationLink).waitUntilVisible();
		Actions actions = new Actions(getDriver());
		actions.moveToElement(evoCancelVacationLink).click().build().perform();
		evoCancelVacationLink.click();
	}
	
	public void clickOnEvoVacationhistory() {
		element(evoVacationHistoryLink).waitUntilVisible();
		Actions actions = new Actions(getDriver());
		actions.moveToElement(evoVacationHistoryLink).click().build().perform();
		evoVacationHistoryLink.click();
	}
	

	public void clickGoToButton() {
		element(goToButton).waitUntilVisible();
		Actions actions = new Actions(getDriver());
		actions.moveToElement(goToButton).click().build().perform();
		goToButton.click();
	}

	public void clickControlPanelButton() {
		element(controlPanelButton).waitUntilVisible();
		Actions actions = new Actions(getDriver());
		actions.moveToElement(controlPanelButton).click().build().perform();
		controlPanelButton.click();
	}

}
