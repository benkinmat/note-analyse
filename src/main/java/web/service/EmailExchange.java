package web.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import web.utilities.ConfigurationInfo;

public class EmailExchange {

	private final static String gmailUsername = ConfigurationInfo.getHostGmailUser();
	private final static String gmailPassword = ConfigurationInfo.getHostGmailPassword();
	private final static String gmailSubject = ConfigurationInfo.getHostGmailSubject();
	
	private static Properties mailServerProperties;
	private static Session mailSession;
	private static MimeMessage mailGeneration;
	
	public static void sendEmail(String toEmail, String content) throws AddressException, MessagingException{
		
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		
		mailSession =  Session.getDefaultInstance(mailServerProperties, null);
		mailGeneration = new MimeMessage(mailSession);
		mailGeneration.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
		mailGeneration.setSubject(gmailSubject);
		mailGeneration.setContent(content, "text/html");
		
		Transport transport = mailSession.getTransport("smtp");
		 
		transport.connect("smtp.gmail.com", gmailUsername, gmailPassword);
		transport.sendMessage(mailGeneration, mailGeneration.getAllRecipients());
		transport.close();
		
	}
	
}
