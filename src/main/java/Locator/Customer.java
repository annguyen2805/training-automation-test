package Locator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Customer {
    private String cusName;
    private String cusLastName;
    private String gender;
    private String address;
    private String city;
    private String state;
    private String pin;
    private String mobileNumber;
    private String cusEmail;
    private String cusPassword;
    private String dateOfBirth;

    public String getCusLastName() {
        return cusLastName;
    }

    public void setCusLastName(String cusLastName) {
        this.cusLastName = cusLastName;
    }

    public Customer() {
        this.cusEmail="";
        this.address="";
        this.city="";
        this.cusPassword="";
        this.cusName="";
        this.cusLastName="";
        this.state="";
        this.pin="";
        this.mobileNumber="";
        this.gender="";
        this.dateOfBirth= "";
    }

    public Customer(String cusName,String cusLastName, String gender, String address, String city, String state, String pin, String mobileNumber, String cusEmail, String cusPassword, String dateOfBirth) {
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
        this.cusLastName=cusLastName;
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

    private static String Random_String(int length, String listCharacter) {
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int) (listCharacter.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(listCharacter
                    .charAt(index));
        }
        return sb.toString();
    }
    public static Customer Random_Info_Customer() {
        String listCharacter = "zxcvbnmlkjhgfdsaqwertyuiop";
        String listNumber = "123456789";
        String listGender = "01";
        String cusName = Random_String(4, listCharacter) + " " + Random_String(4, listCharacter);
        String cusLastName = Random_String(4, listCharacter) + " " + Random_String(4, listCharacter);
        String gender = Random_String(1, listGender);
        String address = "123 Cầu giấy";
        String city = "HN";
        String state = "single";
        String pin = Random_String(6, listNumber);
        String mobileNumber = "0" + Random_String(9, listNumber);
        String cusemail = Random_String(9, listCharacter) + "@gmail.com";
        String cuspassword = Random_String(3, listCharacter) + Random_String(3, listNumber);
        System.out.println(cusName + "," + gender + "," + address + "," + city + "," + state + "," + pin + "," + mobileNumber + "," + cusemail + "," + cuspassword);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Integer yearMin = 1980;
        Integer yearMax = 2010;
        Integer monthMin = 1;
        Integer monthMax = 12;
        Integer dayMin = 1;
        Integer dayMax = 12;
        //random year
        Integer year = (int) (Math.random() * (yearMax - yearMin + 1) + yearMin);
        Integer month = (int) (Math.random() * (monthMax - monthMin + 1) + monthMin);
        Integer day = (int) (Math.random() * (dayMax - dayMin + 1) + dayMin);
        LocalDateTime myDateObj = LocalDateTime.of(year, month, day, 0, 0, 0);
        String cusDateOfBirth = myDateObj.format(dtf);
        Customer cus = new Customer(cusName,cusLastName, gender, address, city, state, pin, mobileNumber, cusemail, cuspassword, cusDateOfBirth);
        return cus;
    }
}
