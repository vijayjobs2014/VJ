package secondGRP.SecondAFT;


import javax.mail.*;
import javax.mail.internet.*;

import com.sun.mail.smtp.SMTPTransport;

import java.util.*;

public class EmailTest {
 public static void main(String args[]){
    try{
   String host = "smtp.gmail.com";
   String from = "vijayjobs2014@gmail.com";
   String pass = "unlockit";

   Properties props = System.getProperties();
   props.setProperty("mail.smtps.ssl.enable", "true");
   props.put("mail.smtp.starttls.enable", "true");
   props.put("mail.smtp.host", host);
   props.setProperty("mail.smtp.user", from);
   props.setProperty("mail.smtp.password", pass);
   props.put("mail.smtp.port", "587");
   props.setProperty("mail.smtp.auth", "true");
   props.put("EnableSsl", "true");
   System.out.println("step 1");
   String[] to = {"vijay.buddi@gmail.com"};

   Session session = Session.getDefaultInstance(props, null);
   MimeMessage message = new MimeMessage(session);
   message.setFrom(new InternetAddress(from));
   InternetAddress[] toAddress = new InternetAddress[to.length];


   for( int i=0; i < to.length; i++ ) { 
       toAddress[i] = new InternetAddress(to[i]);
   }
   System.out.println(Message.RecipientType.TO);

   for( int i=0; i < toAddress.length; i++) {
       message.addRecipient(Message.RecipientType.TO, toAddress[i]);
       System.out.println(toAddress[i]);
   }
   message.setSubject("sending in a group");
   message.setText("Welcome to JavaMail");
   SMTPTransport transport = (SMTPTransport) session.getTransport("smtps");
   System.out.println("Step 2");
   transport.connect(host, 465, from, pass);
  
   System.out.println("Step 3");
   System.out.println("Step 3a"+ message.getFrom());
   try {
	transport.sendMessage(message, message.getAllRecipients());
	} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
   transport.close();
   System.out.println("Step 4");
    }
catch(Exception e){
   e.getMessage();
  }
  }
  }

