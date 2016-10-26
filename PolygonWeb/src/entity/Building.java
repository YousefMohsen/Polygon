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
    private Adress adress;
    private String rapoort;
    private int user;

    public Building() {
    }

    public Building(int id, int hidden, Adress adress, String rapoort, int user) {
        this.id = id;
        this.hidden = hidden;
        this.adress = adress;
        this.rapoort = rapoort;
        this.user = user;
    }

    public Building(Adress adress, String rapoort, int user) {
        this.adress = adress;
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

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
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
