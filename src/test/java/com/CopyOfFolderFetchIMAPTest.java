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
import com.steps.FolderFetchIMAPStep;

@Story(Application.CopyOfFolderFetchIMAP.CopyOfFolderFetchIMAPTest.class)
@RunWith(ThucydidesRunner.class)
public class CopyOfFolderFetchIMAPTest {

	@Steps
	public CopyOfFolderFetchIMAPStep copyOfFolderFetchIMAPStep;

	@Test
	public void testIfEmailContainsTerms() throws MessagingException,
			IOException {

		copyOfFolderFetchIMAPStep
				.CheckIfEmailContainsTerms(
						"QaDepartment123",
						"1234567Qa",
						false,
						false,
						false,
						false,
						true,
						"Dear QADep Manager, <br/> <br/>A Vacation Request was submitted by <strong>QADep Manager</strong>. <br/>The Vacation interval is: <strong>16/01/2014</strong> - <strong>17/01/2014</strong>.<br/> <br/> Sincerely, <br /> EvoPortal Team");
	
	}
}
