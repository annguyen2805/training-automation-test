package Locator;

import java.util.Date;

public class Customer {
    private String cusName;
    private String gender;
    private String address;
    private String city;
    private String state;
    private String pin;
    private String mobileNumber;
    private String cusEmail;
    private String cusPassword;
    private String dateOfBirth;

    public Customer() {
        this.cusEmail="";
        this.address="";
        this.city="";
        this.cusPassword="";
        this.cusName="";
        this.state="";
        this.pin="";
        this.mobileNumber="";
        this.gender="";
        this.dateOfBirth= "";
    }

    public Customer(String cusName, String gender, String address, String city, String state, String pin, String mobileNumber, String cusEmail, String cusPassword, String dateOfBirth) {
        this.cusName = cusName;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.state = state;
        this.pin = pin;
        this.mobileNumber = mobileNumber;
        this.cusEmail = cusEmail;
        this.cusPassword = cusPassword;
        this.dateOfBirth=dateOfBirth;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getYearOfBirth()
    {
        String year=this.dateOfBirth.substring(7,10);
        return year;
    }
    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    public String getCusPassword() {
        return cusPassword;
    }

    public void setCusPassword(String cusPassword) {
        this.cusPassword = cusPassword;
    }
}
