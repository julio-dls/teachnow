package com.teachnow.com.teachnow.correo;

import android.content.Context;
import android.os.AsyncTask;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Created by JULIO on 18/12/2017.
 */

public class SendMail extends AsyncTask<Void, Void, Void> {

    private Context context;
    private Session session;

    private String email;
    private String subject;
    private String message;
    private String ruta;

    public SendMail(Context context, String email, String subject, String message, String ruta) {
        this.context = context;
        this.email = email;
        this.subject = subject;
        this.message = message;
        this.ruta = ruta;
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            Properties properties = new Properties();
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.setProperty("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.socketFactory.port", "465");
            properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            properties.setProperty("mail.smtp.user", Config.EMAIL);
            properties.put("mail.smtp.password", Config.PASSWORD);
            properties.setProperty("mail.smtp.auth", "true");

            Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(Config.EMAIL, Config.PASSWORD);
                }
            });

            if (session != null) {
                BodyPart texto = new MimeBodyPart();
                texto.setText(message);

                BodyPart adjunto = new MimeBodyPart();
                adjunto.setDataHandler(new DataHandler(new FileDataSource(ruta)));

                MimeMultipart multiParte = new MimeMultipart();
                multiParte.addBodyPart(texto);
                multiParte.addBodyPart(adjunto);

                MimeMessage mm = new MimeMessage(session);
                mm.setFrom(new InternetAddress(Config.EMAIL));
                mm.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
                mm.setSubject(subject);
                mm.setText(message);
                mm.setContent(multiParte);
                Transport.send(mm);
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
