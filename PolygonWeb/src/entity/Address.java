package entity;

/**
 * This class contains all information about address. Address is instiated in
 * the database layer and returned to presentation or vice versa.
 */
public class Address {

    private int addressID;
    private String addressline;
    private ZipCode zipCode;

    public Address() {
    }
    
    public Address(int addressID,  String addressline){
        this.addressID = addressID;
        this.addressline = addressline;
    }

    public Address(String addressline, ZipCode zipCode) {
        this.addressline = addressline;
        this.zipCode = zipCode;
    }

    public Address(int addressID, String addressline, ZipCode zipCode) {
        this.addressID = addressID;
        this.addressline = addressline;
        this.zipCode = zipCode;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public String getAddressline() {
        return addressline;
    }

    public void setAddressline(String addressline) {
        this.addressline = addressline;
    }

    public ZipCode getZipCode() {
        return zipCode;
    }

    public void setZipCode(ZipCode zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {//delete
        return "Address{" + "addressID=" + addressID + ", addressline=" + addressline + ", zipCode=" + zipCode + '}';
    }

}
