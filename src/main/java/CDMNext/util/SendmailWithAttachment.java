/*package CDMNext.util;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

import CDMNext.StepDefinations.login;

import java.util.*;

public class SendmailWithAttachment {

	public static void report() {

		// Create object of Property file
		Properties props = new Properties();

		// this will set host of server- you can change based on your requirement
		props.put("mail.smtp.host", "smtp.gmail.com");

		// set the port of socket factory
		props.put("mail.smtp.socketFactory.port", "465");

		// set socket factory
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		// set the authentication to true
		props.put("mail.smtp.auth", "true");

		// set the port of SMTP server
		props.put("mail.smtp.port", "465");

		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(props,

				new javax.mail.Authenticator() {

					protected PasswordAuthentication getPasswordAuthentication() {

						return new PasswordAuthentication("info@shravas.com", "Shravas@info");

					}

				});
		try {

			// Create object of MimeMessage class
			Message message = new MimeMessage(session);

			// Set the from address
			message.setFrom(new InternetAddress("info@shravas.com"));

			// Set the recipient address
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("nmaduru@shravas.com"));

			// Add the subject link
			message.setSubject("CDMNext_Automation TestReport");

			// Create object to add multimedia type content
			BodyPart messageBodyPart1 = new MimeBodyPart();

			// Set the body of email
			messageBodyPart1.setText("Hi Guru&Sudhee,\n\nLastExecution summary report is attached. Please find the attached Extent Report.\nThanks\n\nRegards,\nNadiya");

			// Create another object to add another content
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();

			// Mention the file which you want to send
			String filename=System.getProperty("user.dir")+ "\\target\\surefire-reports\\html\\report.html";
						
			// Create data source and pass the filename
			DataSource source = new FileDataSource(filename);
			
			// set the handler
			messageBodyPart2.setDataHandler(new DataHandler(source));
			
			// set the file
			messageBodyPart2.setFileName(filename);
			
			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();

			// add body part 1
			multipart.addBodyPart(messageBodyPart2);

			// add body part 2
			multipart.addBodyPart(messageBodyPart1);

			// set the content
			message.setContent(multipart);

			// finally send the email
			Transport.send(message);

			login.Log4j.info("=====Email Sent=====");

		} catch (MessagingException e) {
			login.Log4j.error("Sorry,Message has not been sent\n" + e.getMessage());
			

		}

	}

	public static void main(String[] args) {
		SendmailWithAttachment.report();
	}
}*/