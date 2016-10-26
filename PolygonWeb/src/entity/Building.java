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
public class Building {
    
    private int id;
    private int hidden;
    private int adressID;
    private String rapoort;
    private int user;

    public Building() {
    }

    public Building(int id, int hidden, int adressID, String rapoort, int user) {
        this.id = id;
        this.hidden = hidden;
        this.adressID = adressID;
        this.rapoort = rapoort;
        this.user = user;
    }

    public Building(int adressID, String rapoort, int user) {
        this.adressID = adressID;
        this.rapoort = rapoort;
        this.user = user;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHidden() {
        return hidden;
    }

    public void setHidden(int hidden) {
        this.hidden = hidden;
    }

    public int getAdressID() {
        return adressID;
    }

    public void setAdressID(int adressID) {
        this.adressID = adressID;
    }

    public String getRapoort() {
        return rapoort;
    }

    public void setRapoort(String rapoort) {
        this.rapoort = rapoort;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }
    
    
    
}
