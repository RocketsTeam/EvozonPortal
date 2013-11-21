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

		copyOfFolderFetchIMAPStep.CheckIfEmailContainsTerms(
				"qadefaultuser@gmail.com", "1234567890Qa", false, false, false,
				false, true, "Dear u1 u1Last");

	}
}
