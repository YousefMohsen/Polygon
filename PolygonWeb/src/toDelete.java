
import Domain.DomainFacade;
import Domain.EmailSender;
import data.BuildingMapper;
import data.DocumentMapper;
import data.RequestMapper;
import entity.Building;
import java.net.Authenticator;
import java.sql.SQLException;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yousinho
 */
public class toDelete {
 public static void main(String [] args) {
  
     EmailSender mail = new EmailSender();
     

     DomainFacade.sendMail(9);
     
     }
    
}
