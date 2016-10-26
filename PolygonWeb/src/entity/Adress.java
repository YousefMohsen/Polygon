/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Yousinho
 */
public class Adress {
    
    private int adressID;
    private String adressline;
    private Zipcode zipCode;

    public Adress() {
    }

    public Adress(int adressID, String adressline, Zipcode zipCode) {
        this.adressID = adressID;
        this.adressline = adressline;
        this.zipCode = zipCode;
    }
        public Adress(String adressline, Zipcode zipCode) {
        this.adressline = adressline;
        this.zipCode = zipCode;
    }

    public int getAdressID() {
        return adressID;
    }

    public void setAdressID(int adressID) {
        this.adressID = adressID;
    }

    public String getAdressline() {
        return adressline;
    }

    public void setAdressline(String adressline) {
        this.adressline = adressline;
    }

    public Zipcode getZipCode() {
        return zipCode;
    }

    public void setZipCode(Zipcode zipCode) {
        this.zipCode = zipCode;
    }
    
    
}
