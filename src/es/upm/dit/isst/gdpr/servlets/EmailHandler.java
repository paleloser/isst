package es.upm.dit.isst.gdpr.servlets;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailHandler {
	
	private final String user = "isst.grupo22.gdpr@gmail.com";
	private final String password = "ISSTGRUPO22";
	
	private Properties props = new Properties();
	private javax.mail.Authenticator auth;
	private static EmailHandler instance;
	private EmailHandler() {
		props.put("mail.smtp.host", "smtp.gmail.com");    
		props.put("mail.smtp.socketFactory.port", "465");    
		props.put("mail.smtp.socketFactory.class",    
				"javax.net.ssl.SSLSocketFactory");    
		props.put("mail.smtp.auth", "true");    
		props.put("mail.smtp.port", "465");  
		auth = new javax.mail.Authenticator() {    
			protected PasswordAuthentication getPasswordAuthentication() {    
				return new PasswordAuthentication(user,password);  
			}  
		};
		
		
	}
	public static EmailHandler getInstance() {
		if(null == instance)
			instance = new EmailHandler();
		return instance;
	}
	public void sendEmail(String to, String subject, String body) {
		Session session = Session.getDefaultInstance(props,auth);
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
			message.setSubject(subject);
			message.setText(body);
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
