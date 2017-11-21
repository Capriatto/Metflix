package bean;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSenderService {

private static final EmailSenderService instancia = new EmailSenderService();
	
	public static EmailSenderService getInstancia() {
		return instancia;
	}

	public boolean enviarcorreo(String de, String clave, String para, String mensaje, String asunto) {
		boolean enviado = false;
		try {

			String host = "smtp.gmail.com";

			Properties prop = System.getProperties();

			prop.put("mail.smtp.starttls.enable", "true");
			prop.put("mail.smtp.host", host);
			prop.put("mail.smtp.user", de);
			prop.put("mail.smtp.password", clave);
			prop.put("mail.smtp.port", "587");
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.ssl.trust", "*");

			Session session = Session.getDefaultInstance(prop, null);
			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(de));

			message.setRecipient(Message.RecipientType.TO, new InternetAddress(para));
			message.setSubject(asunto);
			message.setText(mensaje);

			System.out.print(message);

			Transport transport = session.getTransport("smtp");
			transport.connect(host, de, clave);

			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			enviado = true;
			System.out.print(enviado);

		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.println("Correo no ha podido ser enviado");

		}
		return enviado;

	}
	
	
}
