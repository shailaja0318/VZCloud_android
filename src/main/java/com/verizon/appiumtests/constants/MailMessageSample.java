package com.verizon.appiumtests.constants;


import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import javax.mail.Session;

/*import com.sncr.verizon.appiumtests.fileInfo.BodyPart;
import com.sncr.verizon.appiumtests.fileInfo.DataSource;
import com.sncr.verizon.appiumtests.fileInfo.FileDataSource;
import com.sncr.verizon.appiumtests.fileInfo.Message;
import com.sncr.verizon.appiumtests.fileInfo.MessagingException;
import com.sncr.verizon.appiumtests.fileInfo.MimeBodyPart;
import com.sncr.verizon.appiumtests.fileInfo.MimeMessage;
import com.sncr.verizon.appiumtests.fileInfo.MimeMultipart;
import com.sncr.verizon.appiumtests.fileInfo.Multipart;*/

/**
 *  <dependency>
        <groupId>javax.mail</groupId>
        <artifactId>mail</artifactId>
        <version>1.5.0-b01</version>
    </dependency>
 * @author user
 *
 */
public class MailMessageSample {
    private String from;
    private List<String> to;
    private List<String> cc;
    private List<String> bcc;
    private String subject;
    private Date sendDate;
    private String flags;
    private String content;
    private List<File> attachments;

    public MailMessageSample() {
    }


    public MailMessageSample(String from, String to, String subject, String content) {
        List<String> listTo = new ArrayList<>();
        List<String> listCC = new ArrayList<>();
        List<String> listBCC = new ArrayList<>();
        listTo.add(to);
        new MailMessageSample(from, listTo, listCC, listBCC, subject, content);
    }

    public MailMessageSample(String from, String to, String cc, String subject, String content) {
        List<String> listTo = new ArrayList<>();
        List<String> listCC = new ArrayList<>();
        List<String> listBCC = new ArrayList<>();
        listTo.add(to);
        listCC.add(cc);
        new MailMessageSample(from, listTo, listCC, listBCC, subject, content);

    }

    public MailMessageSample(String from, List<String> to, List<String> cc, List<String> bcc, String subject, String content) {
        setFrom(from);
        setTo(to);
        setCc(cc);
        setBcc(bcc);
        setSubject(subject);
        setContent(content);
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public List<String> getTo() {
        return to;
    }

    public void setTo(List<String> to) {
        this.to = to;
    }

    public List<String> getCc() {
        return cc;
    }

    public void setCc(List<String> cc) {
        this.cc = cc;
    }

    public List<String> getBcc() {
        return bcc;
    }

    public void setBcc(List<String> bcc) {
        this.bcc = bcc;
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getFlags() {
        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String fieldMessage) {
        this.content = fieldMessage;
    }

    public List<File> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<File> attachments) {
        this.attachments = attachments;
    }

    public String toString() {
        String sb = "-------------------------------------\n" +
                "FROM: " + getFrom() + "\n" +
                "TO: " + getTo() + "\n" +
                "Subject: " + getSubject() + "\n" +
                "Send Date: " + getSendDate() + "\n" +
                "Flags: " + getFlags() + "\n" +
                "Messages: " + getContent() + "\n" +
                "-------------------------------------\n";
        return sb;
    }
}

/*2. STEP (create message, populate model)

protected MailMessage createMessage(String to, String subject, String content) {
    List<String> listTo = new ArrayList<>();
    List<String> listCC = new ArrayList<>();
    List<String> listBCC = new ArrayList<>();
    listTo.add(to);
    return createMessage(listTo, listCC, listBCC, subject, content);
}

protected MailMessage createMessage(List<String> to, List<String> cc, List<String> bcc, String subject, String content) {
    MailMessage mailMessage = new MailMessage();
    mailMessage.setFrom(getUsername());
    mailMessage.setTo(to);
    mailMessage.setCc(cc);
    mailMessage.setBcc(bcc);
    mailMessage.setSubject(subject);
    mailMessage.setContent(content);
    return mailMessage;
}*/
/*
3. STEP method for sending message via model (MailMessage):
public boolean sendMessage(MailMessage mailMessage) {

    try {
        // Create a default MimeMessage object.
        MimeMessage message = new MimeMessage(getSession());

        // Set From: header field of the header.
        message.setFrom(new InternetAddress(mailMessage.getFrom()));

        // Set To: header field of the header.
        for (String fieldTo : mailMessage.getTo()) {
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(fieldTo));
        }

        for (String fieldCc : mailMessage.getCc()) {
            message.addRecipient(Message.RecipientType.CC, new InternetAddress(fieldCc));
        }

        for (String fieldBcc : mailMessage.getBcc()) {
            message.addRecipient(Message.RecipientType.BCC, new InternetAddress(fieldBcc));
        }

        // Set Subject: header field
        message.setSubject(mailMessage.getSubject());

        // Now set the actual message
        message.setText(mailMessage.getContent());


        // creates message part
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(mailMessage.getContent(), "text/html");

        // creates multi-part
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        // adds attachments
        if (mailMessage.getAttachments() != null && mailMessage.getAttachments().size() > 0) {
            for (File filePath : mailMessage.getAttachments()) {
                MimeBodyPart attachPart = new MimeBodyPart();

                try {
                    attachPart.attachFile(filePath.getAbsolutePath());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                multipart.addBodyPart(attachPart);
            }
        }

        // sets the multi-part as e-mail's content
        message.setContent(multipart);


        // Send message
        Transport.send(message);
        return true;

    } catch (MessagingException mex) {
        mex.printStackTrace();
        return false;
    }
}*/

// Following is a another  approach to send email
/*mport javax.mail.Session;

public class Avhjvwd {
	final String username = "YourEmail";
	final String password = "YourPassword";

	Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", "mail.example.com");
	props.put("mail.smtp.port", "25");
	props.put("java.net.preferIPv4Stack", "true");
	props.setProperty("mail.smtp.host", "smtp.gmail.com");
    props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
    props.setProperty("mail.smtp.socketFactory.fallback", "false");
    props.setProperty("mail.smtp.port", "465");
    props.setProperty("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.auth", "true");
    props.put("mail.debug", "true");
    props.put("mail.store.protocol", "pop3");
    props.put("mail.transport.protocol", "smtp");
	Session session = Session.getInstance(props,
	  new javax.mail.Authenticator() {
	  protected PasswordAuthentication getPasswordAuthentication() {
	    return new PasswordAuthentication(username, password);
	}
	});
	
	try {

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("YourEmail"));
		message.setRecipients(Message.RecipientType.TO,
		    InternetAddress.parse("Emailid to which you want to send Report"));
		message.setSubject("Email Subject");



		BodyPart messageBodyPart1 = new MimeBodyPart();  
		messageBodyPart1.setText("Body text);  

		//4) create new MimeBodyPart object and set DataHandler object to this object      
		MimeBodyPart messageBodyPart2 = new MimeBodyPart();  

		String filename = "File path if you want to attach in mail";//change accordingly  
		DataSource source = new FileDataSource(filename);  
		messageBodyPart2.setDataHandler(new DataHandler(source));  
		messageBodyPart2.setFileName(filename);  


		//5) create Multipart object and add MimeBodyPart objects to this object      
		Multipart multipart = new MimeMultipart();  
		multipart.addBodyPart(messageBodyPart1);  
		multipart.addBodyPart(messageBodyPart2);  

		//6) set the multiplart object to the message object  
		message.setContent(multipart );  
		Transport.send(message);

		System.out.println("Mail Sent Successfully");

		 } catch (MessagingException e) {
		throw new RuntimeException(e);
		}
//Note : Please change Host, Email details and port as per your Email system configuration.
	*//**
	 * Following code will allow you to send mail using JAVA. Create one function and call it after scenario of Pass/Fail in selenium webdriver code.
	 *//*
}*/


