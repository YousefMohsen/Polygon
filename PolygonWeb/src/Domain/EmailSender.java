/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author Yousinho
 */

import entity.Building;
import entity.User;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;




/**
 *
 * @author Yousinho
 */
public class EmailSender {
    
     public static void sendEmail(int buildingID){
Building building = DomainFacade.getBuilding(buildingID);
User user = DomainFacade.getUser(buildingID);
String fromEmail = "polygonrequests@gmail.com"; //requires valid gmail id
String password = "Polygon16sundbygning!"; // correct password for gmail id

String subject = "Anmodning om et sunhedstjek";
String emailMessage =createMessege(user,building) ;
       
String toEmail = "polygonrequests@gmail.com"; //receiver
System.out.println(emailMessage);


        try{
             System.out.println("TLSEmail Start");
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
            props.put("mail.smtp.port", "587"); //TLS Port
            props.put("mail.smtp.auth", "true"); //enable authentication
            props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

                //create Authenticator object to pass in Session.getInstance argument
            Authenticator auth = new Authenticator() {
                //override the getPasswordAuthentication method
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            };
            Session session = Session.getInstance(props, auth);

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            System.out.println("Mail Check 2");

            message.setSubject(subject);
            message.setText(emailMessage);

            System.out.println("Mail Check 3");

            Transport.send(message);
            System.out.println("Mail Sent");
        }catch(Exception ex){
            System.out.println("Mail fail");
            System.out.println(ex);
        }
    }
     
     
     private static String createMessege(User u,Building b){
     String s =  u.getFirstname()+" "+u.getLastname()+ " ønsker et sunhedstjek af følgende bygning:\n"
        + "\nAdresse: "+b.getAddress().getAddressline()+" "+b.getAddress().getZipCode().getZip()+" "+b.getAddress().getZipCode().getCity()
   
                + "\n \nKontaktinfo: "
             + "\nTelefon: "+u.getPhone()
             + "\nMail: "+u.getEmail()
             + "\nAdresse: "+u.getAddress().getAddressline()+" "+u.getAddress().getZipCode().getZip()+" "+u.getAddress().getZipCode().getCity()
             + ""
             + "";
        
     
     
     
     return s;
     }
}
