package com.pages;

import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ControlPanelPage extends PageObject {

	@FindBy(css = ".lfr-panel-title")
	private WebElement assignedToMeLabel;

	public ControlPanelPage(WebDriver driver) {
		super(driver);

	}

}
