package com;

import java.io.IOException;

import javax.mail.MessagingException;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.requirements.Application;
import com.steps.FolderFetchIMAPStep;

@Story(Application.FolderFetchIMAP.FolderFetchIMAPTest.class)
@RunWith(ThucydidesRunner.class)
public class FolderFetchIMAPTest {

	@Steps
	public FolderFetchIMAPStep folderFetchIMAPStep;

	@Test
	public void testIfEmailContainsTerms() throws MessagingException,
			IOException {
		folderFetchIMAPStep.CheckIfEmailContainsTerms("QaDEpartment123",
				"1234567Qa","team");

	}
}
