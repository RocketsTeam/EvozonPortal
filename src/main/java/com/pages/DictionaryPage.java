package com.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://172.22.8.38:9090/web/guest/login")
public class DictionaryPage extends PageObject {

	/*
	 * @FindBy(name="search") private WebElement searchTerms;
	 */

	@FindBy(id = "_58_login")
	private WebElement emailadress;

	@FindBy(id = "_58_password")
	private WebElement password;

	@FindBy(css = ".aui-button-input")
	private WebElement submitButton;

	public DictionaryPage(WebDriver driver) {
		super(driver);
	}

	public void enter_user(String keyword) {
		element(emailadress).waitUntilVisible();
		element(emailadress).type(keyword);
	}

	public void enter_password(String keywords) {
		element(password).type(keywords);
	}

	public void click_submit() {
		submitButton.click();
	}
}
