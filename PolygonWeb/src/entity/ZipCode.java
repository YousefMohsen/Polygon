package entity;

public class ZipCode {

    private int addressId;//delete this
    private int zip;
    private String city;

    public ZipCode() {
    }

    public ZipCode(int zip, String city) {
        this.zip = zip;
        this.city = city;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
