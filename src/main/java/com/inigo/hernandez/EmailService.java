package com.inigo.hernandez;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	private static final String EMAIL = "smtp.ssl.email";
	private static final String PASSWORD = "smpt.ssl.password";
	private static final String HOST = "smtp.ssl.host";
	private static final String PORT = "smtp.ssl.port";

	@Autowired
	Environment env;

	public void sendMail(String address, String subject, String message) {

		Properties props = new Properties();
		props.put("mail.smtp.host", env.getProperty(HOST));
		props.put("mail.smtp.socketFactory.port", env.getProperty(PORT));
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", env.getProperty(PORT));

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(env.getProperty(EMAIL), env.getProperty(PASSWORD));
			}
		});

		try {

			Message mail = new MimeMessage(session);
			mail.setFrom(new InternetAddress(env.getProperty(EMAIL)));

			mail.setRecipients(Message.RecipientType.TO, InternetAddress.parse(address));
			mail.setSubject(subject);
			mail.setText(message);

			Transport.send(mail);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}