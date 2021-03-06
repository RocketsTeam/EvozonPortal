package com;

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

import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

import org.junit.runner.RunWith;

import com.requirements.Application;
import com.sun.mail.imap.IMAPFolder;



@Story(Application.ReadEmailT.ReadEmail.class)
@RunWith(ThucydidesParameterizedRunner.class)
public class ReadEmail {

	public static void main(String[] args) throws MessagingException,
			IOException {
		IMAPFolder folder = null;
		Store store = null;
		String subject = null;
		String from;
		String date;
		
		
	
		try {
			Properties props = System.getProperties();
			props.setProperty("mail.store.protocol", "imaps");

			Session session = Session.getDefaultInstance(props, null);

			store = session.getStore("imaps");

			store.connect("imap.googlemail.com", "qadepartmentmanager", "Test123456");

			
			folder = (IMAPFolder) store.getFolder("inbox");

			if (!folder.isOpen())
				folder.open(Folder.READ_WRITE);
			Message[] messages = folder.getMessages();
			System.out.println("No of Messages : " + folder.getMessageCount());
			System.out.println("No of Unread Messages : "
					+ folder.getUnreadMessageCount());
			System.out.println();
			for (int i = 0; i < messages.length; i++) {
				
				Message msg = messages[i];
				subject = msg.getSubject().toString();
				from = msg.getFrom().toString();
				date=msg.getReceivedDate().toString();
				
				
				 String text=subject+from+date;
				if (checkIfTextContainsTerms(text,false,"submitted","have")){
					
					System.out
					.println("*****************************************************************************");
					System.out.println("MESSAGE " + (i + 1) + ":");
					
					System.out.println("This is it!!! MATCH !!!");
					
					
					System.out.println("Subject: " + subject);
					System.out.println("From: " + msg.getFrom()[0]);
					System.out.println("To: " + msg.getAllRecipients()[0]);
					System.out.println("Date: " + msg.getReceivedDate());
					Object content = msg.getContent();
					if (content instanceof String) {
						String	body = (String) content;
					System.out.println("Body: "+body);	
						
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
