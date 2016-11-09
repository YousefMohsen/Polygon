package entity;

public class Building {

    private int id;
    private int hidden;
    private Address address;
    private String report;
    private int user;

    public Building() {
    }

    public Building(int id, int hidden, Address address, String report, int user) {
        this.id = id;
        this.hidden = hidden;
        this.address = address;
        this.report = report;
        this.user = user;
    }

    public Building(Address address, String report, int user) {
        this.address = address;
        this.report = report;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

}
