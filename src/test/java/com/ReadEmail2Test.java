package com;

import java.io.IOException;

import javax.mail.MessagingException;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.requirements.Application;
import com.steps.ReadEmailSteps;



@Story(Application.ReadEmailT2.ReadEmail2.class)
@RunWith(ThucydidesRunner.class)
public class ReadEmail2Test {
	
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://172.22.8.38:9090")
	public Pages pages;
	
	@Steps
	public ReadEmailSteps ReadEmail;

	@Test
	 public void ReadEmail() throws MessagingException, IOException {
	  
	  ReadEmail.setLog("imap.googlemail.com", "qadepartmentmanager", "Test123456", "Approved", "EvoPortal");
	 }
	
	}
	

