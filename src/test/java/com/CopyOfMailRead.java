
package com;

import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.search.*;

import java.util.*;

import com.sun.mail.imap.*;

import java.io.*;





public class CopyOfMailRead {



public static void main(String[] args) throws IOException {
          try {
          Properties props = new Properties();
          props.put("mail.store.protocol","imaps");

          Session session;
          session = Session.getDefaultInstance(props, null);
          Store store = session.getStore("imaps");
          store.connect("imap.gmail.com","QaDepartment123", "1234567Qa");

          IMAPFolder folder = (IMAPFolder) store.getFolder("inbox");
          folder.open(Folder.READ_ONLY);
        //  Message[] arrayMessages = folder.getMessages();
          

          Flags seen = new Flags(Flags.Flag.SEEN);
          FlagTerm unseenFlagTerm = new FlagTerm(seen,false);
          Message message[] = folder.search(unseenFlagTerm); 
          String content;

          int x = message.length-1;
          for (int i=x;i>=0;i--) {
              System.out.println("Message " + (i + 1));
              System.out.println("From : " + message[i].getFrom()[0]);
              System.out.println("Subject : " + message[i].getSubject());
              Multipart multipart = (Multipart) message[i].getContent();
              for (int j = 0; j < multipart.getCount(); j++) {
               BodyPart bodyPart = multipart.getBodyPart(j);
               String disposition = bodyPart.getDisposition();
               if (disposition != null && (disposition.equalsIgnoreCase("ATTACHMENT"))) { // BodyPart.ATTACHMENT doesn't work for gmail
                      System.out.println("Mail have some attachment");

                      DataHandler handler = bodyPart.getDataHandler();
                      System.out.println("file name : " + handler.getName());                                 
                    }
                  else { 
                      System.out.println("Body: "+bodyPart.getContent());
                      content= bodyPart.getContent().toString();
                    //  System.out.println(content);
                    }
              }
//              
//              try {
//                  System.out.println("Body: " + message[j].getContent());
//                  System.out.println();
//              } catch (IOException ex) {
//                  System.out.println(ex);
//              }
         }    
         

          folder.close(false);
          store.close();
          }
          catch (MessagingException e) {
              System.out.println("Error: " + e);
          }
      }
}
