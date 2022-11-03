package Locator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

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
    private String subject;
    private String picture;
    private String hobbies;

    public String getCusLastName() {
        return cusLastName;
    }

    public void setCusLastName(String cusLastName) {
        this.cusLastName = cusLastName;
    }

    public Customer() {
        this.subject = "";
        this.cusEmail = "";
        this.address = "";
        this.city = "";
        this.cusPassword = "";
        this.cusName = "";
        this.cusLastName = "";
        this.state = "";
        this.pin = "";
        this.mobileNumber = "";
        this.gender = "";
        this.dateOfBirth = "";
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public Customer(String cusName, String cusLastName, String gender, String address, String city, String state, String pin, String mobileNumber, String cusEmail, String cusPassword, String dateOfBirth, String subject, String picture, String hobbies) {
        this.cusName = cusName;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.state = state;
        this.pin = pin;
        this.mobileNumber = mobileNumber;
        this.cusEmail = cusEmail;
        this.cusPassword = cusPassword;
        this.dateOfBirth = dateOfBirth;
        this.cusLastName = cusLastName;
        this.subject = subject;
        this.picture = picture;
        this.hobbies = hobbies;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getYearOfBirth() {
        String year = this.dateOfBirth.substring(6, 10);
        return year;
    }

    public String getMonthOfBirth() {
        String month = this.dateOfBirth.substring(3, 5);
        return month;
    }

    public String getDayOfBirth() {
        String day = this.dateOfBirth.substring(0, 2);
        return day;
    }

    public String getDateOfBirthFormat(String format) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        Integer year = Integer.parseInt(this.dateOfBirth.substring(6, 10));
        Integer month = Integer.parseInt(this.dateOfBirth.substring(3, 5));
        Integer day = Integer.parseInt(this.dateOfBirth.substring(0, 2));
        LocalDateTime myDateObj = LocalDateTime.of(year, month, day, 0, 0, 0);
        String cusDateOfBirth = myDateObj.format(dtf);
        return cusDateOfBirth;
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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Integer yearMin = 1950;
        Integer yearMax = 2010;
        Integer monthMin = 1;
        Integer monthMax = 12;
        Integer dayMin = 1;
        Integer dayMax = 12;
        //random year
        Random random = new Random();
        Integer year = random.nextInt(yearMax - yearMin + 1) + yearMin;
        System.out.println("year = " + year);
        Integer month = random.nextInt(monthMax - monthMin + 1) + monthMin;
        Integer day = random.nextInt(dayMax - dayMin + 1) + dayMin;
        LocalDateTime myDateObj = LocalDateTime.of(year, month, day, 0, 0, 0);
        String cusDateOfBirth = myDateObj.format(dtf);
        Customer cus = new Customer(cusName, cusLastName, gender, address, city, state, pin, mobileNumber, cusemail, cuspassword, cusDateOfBirth, "", "", "");
        System.out.println(cusName + "," + gender + "," + address + "," + city + "," + state + "," + pin + "," + mobileNumber + "," + cusemail + "," + cuspassword + "," + cusDateOfBirth);
        return cus;
    }

}
