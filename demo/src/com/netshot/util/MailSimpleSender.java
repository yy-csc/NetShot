package com.netshot.util;

import java.util.Date;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/***
 * Simple EMail Sender. Don't support the Attachment
 * 
 * @author
 * 
 */
public class MailSimpleSender {
	public static boolean sendMail(MailSenderInfo mailInfo,
			boolean sendHtmlFormat) {
		// Whether need identity authentication
		MailAuthenticator authenticator = null;
		Properties pro = mailInfo.getProperties();
		// if true, Create a password validator
		if (mailInfo.isValidate()) {
			authenticator = new MailAuthenticator(mailInfo.getUserName(),
					mailInfo.getPassword());
		}
		// Create session to send mail
		Session sendMailSession = Session
				.getDefaultInstance(pro, authenticator);
		mailInfo.setFromAddress("CSC_OSM_Admin@csc.com");
		try {
			// Create a mail message by session
			Message mailMessage = new MimeMessage(sendMailSession);
			// Set the sernder address
			Address from = new InternetAddress(mailInfo.getFromAddress());
			// Set the sender
			mailMessage.setFrom(from);

			// Set title of the mail
			mailMessage.setSubject(mailInfo.getSubject());
			// Set the send time
			mailMessage.setSentDate(new Date());

			if (sendHtmlFormat) {
				// MiniMultipart is a Containers, include MimeBodyPart
				Multipart mainPart = new MimeMultipart();
				// Create MimeBodyPart
				BodyPart html = new MimeBodyPart();
				// Setup HTML content
				html.setContent(mailInfo.getContent(),
						"text/html; charset=utf-8");
				mainPart.addBodyPart(html);
				// Set the MiniMultipart as mail content
				mailMessage.setContent(mainPart);

			} else {
				// Set the Body of the mail
				String mailContent = mailInfo.getContent();
				mailMessage.setText(mailContent);
			}

			// send mail
			Address[] to = new Address[mailInfo.getToAddress().length];
			for (int i = 0; i < mailInfo.getToAddress().length; i++) {
				to[i] = new InternetAddress(mailInfo.getToAddress()[i]);
			}
			mailMessage.setRecipients(Message.RecipientType.TO, to);
			Transport.send(mailMessage, to);

			return true;
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
		return false;
	}

}