package com;

import java.io.IOException;

import javax.mail.MessagingException;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.requirements.Application;
import com.requirements.Application.FolderFetchIMAP;
import com.steps.CheckEmailSteps;
import com.steps.FolderFetchIMAPStep;


@Story(Application.CheckEm.CheckEmail.class)
@RunWith(ThucydidesRunner.class)

public class CheckEmail {



	
	@Steps
	public CheckEmailSteps CheckEmail;

	@Test
	public void  testEmail() throws MessagingException, IOException {
		CheckEmail.setLogin("qadefaultuser", "1234567890Qa", "EvoPortal","Approved");
		
	}
}

	


