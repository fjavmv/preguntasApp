package com.fjavmvazquez.preyres.mail;

import java.security.Security;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

public class GMailSender extends javax.mail.Authenticator {
    private String mailHost = "smtp.gmail.com";
    private String user;
    private String password;
    private Session session;

    static {
        Security.addProvider(new com.fjavmvazquez.preyres.mail.JSSEProvider());
    }

    public GMailSender(String user, String password){
        this.user = user;
        this.password = password;

        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.host", mailHost);
        properties.setProperty("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");
        properties.setProperty("mail.smtp.quitwait", "false");

        session = javax.mail.Session.getDefaultInstance(properties,this);
    }

    protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(user,password);
    }

    public synchronized  void senMail(String subject, String body, String sender, String recipients)
            throws  Exception{
        MimeMessage message = new MimeMessage(session);
        DataHandler handler = new DataHandler(new ByteArrayDataSource(body.getBytes(),"text/plain"));
        message.setSender(new InternetAddress(sender));
        message.setSubject(subject);
        message.setDataHandler(handler);

        if (recipients.indexOf(',') > 0)
        {
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));
        }else{
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(recipients));
            Transport.send(message);
        }
    }



}
