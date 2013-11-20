package com;

import java.io.IOException;

import javax.mail.MessagingException;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.requirements.Application;
import com.steps.CopyOfFolderFetchIMAPStep;

@Story(Application.CopyOfFolderFetchIMAP.CopyOfFolderFetchIMAPTest.class)
@RunWith(ThucydidesRunner.class)
public class CheckEmailTest {

	@Steps
	public CopyOfFolderFetchIMAPStep copyOfFolderFetchIMAPStep;

	@Test
	public void testIfEmailContainsTerms() throws MessagingException,
			IOException {
		// copyOfFolderFetchIMAPStep.CheckIfEmailContainsTerms(user, password,
		// checkInText, checkInSubject, checkInFrom, checkInDate, checkInBody,
		// terms);
		copyOfFolderFetchIMAPStep
				.CheckIfEmailContainsTerms(
				"qadefaultuser@gmail.com",
					"1234567890Qa",
					false,
					false,
					false,
					false,
					true,
						"Dear u1 u1Last");
		//copyOfFolderFetchIMAPStep.CheckIfEmailContainsTerms("qadefaultuser@gmail.com", "1234567890Qa",false, false, false, true, false, "Fri Nov 15 12:17:05 EET 2013");

	}
}
