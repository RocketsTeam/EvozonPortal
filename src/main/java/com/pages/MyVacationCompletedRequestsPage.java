package com.pages;

import ch.lambdaj.function.convert.Converter;
import net.thucydides.core.annotations.DefaultUrl;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import net.thucydides.core.pages.PageObject;

import java.util.List;

import static ch.lambdaj.Lambda.convert;

public class MyVacationCompletedRequestsPage extends PageObject {

   
	
	@FindBy(css = "a[href*=my-completed-requests]")
	private WebElement MyVacationCompletedLink;
	
	

	public MyVacationCompletedRequestsPage(WebDriver driver) {
		super(driver);
	}
	
	 
	 
	 public void click_MyVacationCompletedLink() {
		 MyVacationCompletedLink.click();
	    }
	 
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
		    waitABit(2000);
		   
		   }
		  }
		 }
	
	}



    