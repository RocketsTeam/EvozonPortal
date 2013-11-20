package com.steps;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;

import net.thucydides.core.annotations.Step;

import com.sun.mail.imap.IMAPFolder;

public class CheckEmailSteps {
	
@Step
	public void setLogin( String username, String password,String... terms) throws MessagingException,
			IOException {
		IMAPFolder folder = null;
		Store store = null;
		//String subject = null;
		
		
		
		
	
		try {
			Properties props = System.getProperties();
			props.setProperty("mail.store.protocol", "imaps");

			Session session = Session.getDefaultInstance(props, null);

			store = session.getStore("imaps");

			store.connect("imap.googlemail.com", "qadefaultuser", "1234567890Qa");

			// folder = (IMAPFolder) store.getFolder("[Gmail]/Spam"); // This
			// doesn't work for other email account
			folder = (IMAPFolder) store.getFolder("inbox");// This works for
															// both email
															// account

			if (!folder.isOpen())
				folder.open(Folder.READ_WRITE);
			Message[] messages = folder.getMessages();
			System.out.println("No of Messages : " + folder.getMessageCount());
			System.out.println("No of Unread Messages : "
					+ folder.getUnreadMessageCount());
			System.out.println();
			for (int i = 0; i < messages.length; i++) {
				
				Message msg = messages[i];
				String subject = msg.getSubject().toString();
				
				//String subjecteTempl=subjectVar;
				String from= msg.getFrom()[0].toString();
				//String fromTempl=fromVar;
				String date = msg.getReceivedDate().toString();
				
				
				 String text=subject+from+date;
				
				if (checkIfTextContainsTerms(text,true,terms)){
					
					System.out
					.println("*****************************************************************************");
					System.out.println("MESSAGE " + (i + 1) + ":");
					
					System.out.println("This is it!!! MATCH !!!");
					
					
					System.out.println("Subject: " + msg.getSubject());
					System.out.println("From: " + msg.getFrom()[0]);
					System.out.println("To: " + msg.getAllRecipients()[0]);
					System.out.println("Date: " + msg.getReceivedDate());
					Object content = msg.getContent();
					if (content instanceof String) {
						String	body = (String) content;
					System.out.println("Body: "+body);	
						
					}
					
					
				}

				// new code

				String contentType = msg.getContentType();

				if (contentType.contains("text/plain")
						|| contentType.contains("text/html")) {
					// plain text or HTML only email

				} else if (contentType.contains("multipart")) {

					// email contains attachments
					Multipart multiPart = (Multipart) msg.getContent();
					int numberOfParts = multiPart.getCount();
					for (int partCount = 0; partCount < numberOfParts; partCount++) {
						BodyPart part = multiPart.getBodyPart(partCount);
						if (Part.ATTACHMENT.equalsIgnoreCase(part
								.getDisposition())) {

							// part is attachment
							// store attachment to disk
							storeAttachment(part);

						}
					}

				}
				// new code

			}
		} finally {
			if (folder != null && folder.isOpen()) {
				folder.close(true);
			}
			if (store != null) {
				store.close();
			}
		}

	}

	private boolean checkIfTextEqualsTo(String text, boolean b, String[] terms) {
	// TODO Auto-generated method stub
	return false;
}

	// new code
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

	// new code
