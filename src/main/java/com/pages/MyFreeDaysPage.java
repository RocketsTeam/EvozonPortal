package com.pages;

import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MyFreeDaysPage extends PageObject {

	 @FindBy(css = ".lfr-panel-title")
	 private WebElement assignedToMeLabel;



	public MyFreeDaysPage(WebDriver driver) {
		super(driver);

	}

	
}
