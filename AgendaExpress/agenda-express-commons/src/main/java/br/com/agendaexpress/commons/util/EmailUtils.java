package br.com.agendaexpress.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.agendaexpress.commons.util.HashUtil;

public class EmailUtils {

	public void enviaEmailConfirmacao(String email, Integer id) {
		final String username = "clashgenka@gmail.com";
		final String password = "dbgt8457";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		System.out.println();
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("clashgenka@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(email));
			message.setSubject("Email de confirmação.");
			String hash = String.valueOf(HashUtil.hash32(id.toString()));
			message.setContent("<a href='http://localhost:8080/AgendaExpressServices/usuario/confirm?m=" + email + "&id=" + hash + "'>comfirmação</a>", "text/html; charset=utf-8");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		new EmailUtils().enviaEmailConfirmacao("xande.genka@gmail.com", 1);

	}

}
