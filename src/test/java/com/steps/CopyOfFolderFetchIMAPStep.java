package com.steps;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import org.junit.Assert;

import com.sun.mail.imap.IMAPFolder;

public class CopyOfFolderFetchIMAPStep extends ScenarioSteps {

	public CopyOfFolderFetchIMAPStep(Pages pages) {
		super(pages);

	}

	@Step
	public void CheckIfEmailContainsTerms(String user, String password,
			boolean checkInText, boolean checkInSubject, boolean checkInFrom,
			boolean checkInDate, boolean checkInBody, String... terms)
			throws MessagingException, IOException {

		IMAPFolder folder = null;
		Store store = null;
		String subject = null;
		String from = null;
		String date = null;
		
		try {
			Properties props = System.getProperties();
			props.setProperty("mail.store.protocol", "imaps");
			Session session = Session.getDefaultInstance(props, null);
			store = session.getStore("imaps");
			store.connect("imap.googlemail.com", user, password);

			folder = (IMAPFolder) store.getFolder("inbox");

			if (!folder.isOpen())
				folder.open(Folder.READ_WRITE);
			Message[] messages = folder.getMessages();
			System.out.println("No of Messages : " + folder.getMessageCount());
			System.out.println("No of Unread Messages : "
					+ folder.getUnreadMessageCount());
			System.out.println();
			boolean foundTerms = false;
			for (int i = 0; i < messages.length; i++) {

				Message msg = messages[i];
				subject = msg.getSubject().toString();
				from = msg.getFrom().toString();
				date = msg.getReceivedDate().toString();
				Object content = msg.getContent();
				String body = "";
				if (content instanceof String) {
					body = (String) content;

				}
				if (checkInSubject) {

					foundTerms = checkIfTextContainsTerms(subject, true, terms);
					if (foundTerms) {
						System.out.println("Subject: " + subject);
						System.out.println("From: " + from);
						System.out.println("Date: " + date);
						System.out.println("Body: " + body);
						break;
					}
				} else if (checkInFrom) {

					foundTerms = checkIfTextContainsTerms(from, true, terms);
					System.out.println("Subject: " + subject);
					System.out.println("From: " + from);
					System.out.println("Date: " + date);
					System.out.println("Body: " + body);
					if (foundTerms) {
						break;
					}
				} else if (checkInDate) {
					foundTerms = checkIfTextContainsTerms(date, true, terms);
					if (foundTerms) {
						System.out.println("Subject: " + subject);
						System.out.println("From: " + from);
						System.out.println("Date: " + date);
						System.out.println("Body: " + body);
						break;
					}
				} else if (checkInBody) {
					foundTerms = checkIfTextContainsTerms(body, true, terms);
					if (foundTerms) {
						System.out.println("Subject: " + subject);
						System.out.println("From: " + from);
						System.out.println("Date: " + date);
						System.out.println("Body: " + body);
						break;
					}
				} else if (checkInText) {
					String text = subject + from + date + body;
					foundTerms = checkIfTextContainsTerms(text, true, terms);
					if (foundTerms) {
						System.out.println("All text is: " + text);
						break;
					}
				}

				String contentType = msg.getContentType();

				if (contentType.contains("text/plain")
						|| contentType.contains("text/html")) {

				} else if (contentType.contains("multipart")) {

					Multipart multiPart = (Multipart) msg.getContent();
					int numberOfParts = multiPart.getCount();
					for (int partCount = 0; partCount < numberOfParts; partCount++) {
						BodyPart part = multiPart.getBodyPart(partCount);
						if (Part.ATTACHMENT.equalsIgnoreCase(part
								.getDisposition())) {

							storeAttachment(part);

						}
					}

				}

			}
			Assert.assertTrue(
					"No email containing the searched terms was found!",
					foundTerms);
		} finally {
			if (folder != null && folder.isOpen()) {
				folder.close(true);
			}
			if (store != null) {
				store.close();
			}
		}

	}

	private static void storeAttachment(BodyPart part)
			throws MessagingException, IOException {
		String destFilePath = "D:/Attachment/" + part.getFileName();

		FileOutputStream output = new FileOutputStream(destFilePath);

		InputStream input = part.getInputStream();

		byte[] buffer = new byte[4096];

		int byteRead;

		while ((byteRead = input.read(buffer)) != -1) {
			output.write(buffer, 0, byteRead);
		}
		output.close();
	}

	public static boolean checkIfTextContainsTerms(String text,
			boolean ignoreCase, String... strTerms) {
		text = removeNewLinesMultipleSpacesAndTabs(text);
		if (ignoreCase)
			text = text.toLowerCase();
		for (String term : strTerms) {
			if (ignoreCase)
				term = term.toLowerCase();
			if (!text.contains(term))
				return false;
		}
		return true;
	}

	public static String removeNewLinesMultipleSpacesAndTabs(String body) {
		body = body.replaceAll("[\0\t\n\r]", " ");
		body = body.replaceAll("&nbsp;", " ");
		while (body.indexOf("  ") != -1) {
			body = body.replaceAll("  ", " ");
		}
		return body;
	}

}
