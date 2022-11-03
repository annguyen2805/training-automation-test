package Locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListElementToolQA {
    protected WebElement Nopcommerce_Register_Link(WebDriver driver) {
        return driver.findElement(By.xpath("//a[@class='ico-register']"));
    }

    protected WebElement Alert_Click_Me_Button(WebDriver driver) {
        return driver.findElement(By.id("confirmButton"));
    }

    protected WebElement Alert_Confirm_Result(WebDriver driver) {
        return driver.findElement(By.id("confirmResult"));
    }

    protected WebElement Automation_Practice_Form_First_Name(WebDriver driver) {
        return driver.findElement(By.id("firstName"));
    }

    protected WebElement Automation_Practice_Form_Last_Name(WebDriver driver) {
        return driver.findElement(By.id("lastName"));
    }

    protected WebElement Automation_Practice_Form_User_Name(WebDriver driver) {
        return driver.findElement(By.id("userEmail"));
    }

    protected WebElement Automation_Practice_Form_Gender_Male(WebDriver driver) {
        return driver.findElement(By.id("gender-radio-1"));
    }

    protected WebElement Automation_Practice_Form_Gender_Male_Lable(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@id='gender-radio-1']/following-sibling::label"));
    }

    protected WebElement Automation_Practice_Form_Gender_Female(WebDriver driver) {
        return driver.findElement(By.id("gender-radio-2"));
    }

    protected WebElement Automation_Practice_Form_Gender_Female_Lable(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@id='gender-radio-2']/following-sibling::label"));
    }

    protected WebElement Automation_Practice_Form_Gender_Other(WebDriver driver) {
        return driver.findElement(By.id("gender-radio-3"));
    }

    protected WebElement Automation_Practice_Form_User_Number(WebDriver driver) {
        return driver.findElement(By.id("userNumber"));
    }

    protected WebElement Automation_Practice_Form_Date_Of_Birth(WebDriver driver) {
        return driver.findElement(By.id("dateOfBirthInput"));
    }

    protected WebElement Automation_Practice_Form_Subject_Input(WebDriver driver) {
        return driver.findElement(By.id("subjectsInput"));
    }

    protected WebElement Automation_Practice_Form_Subject_Container(WebDriver driver) {
        return driver.findElement(By.xpath("//div[@id='subjectsContainer']//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']"));
    }

    protected String Automation_Practice_Form_Subject_Value() {
        return "//div[@id='subjectsContainer']//div[@class='css-12jo7m5 subjects-auto-complete__multi-value__label']";
    }

    protected String Automation_Practice_Form_Subject() {
        return "//input[@Id='subjectsInput']";
    }

    protected String Automation_Practice_Form_ChildSubject() {
        return "//div[starts-with(@id,'react-select-2-option-')]";
    }

    protected WebElement Automation_Practice_Form_Hobbies_Sports(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@id='hobbies-checkbox-1']/following-sibling::label"));
    }

    protected WebElement Automation_Practice_Form_Hobbies_Reading(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@id='hobbies-checkbox-2']/following-sibling::label"));
    }

    protected WebElement Automation_Practice_Form_Hobbies_Music(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@id='hobbies-checkbox-3']/following-sibling::label"));
    }

    protected WebElement Automation_Practice_Form_Picture(WebDriver driver) {
        return driver.findElement(By.id("uploadPicture"));
    }

    protected WebElement Automation_Practice_Form_Current_Address(WebDriver driver) {
        return driver.findElement(By.id("currentAddress"));
    }

    protected WebElement Automation_Practice_Form_State(WebDriver driver) {
        return driver.findElement(By.id("state"));
    }

    protected String Automation_Practice_Form_State_Child() {
        return "//div[starts-with(@id,'react-select-3-option-')]";
    }

    protected String Automation_Practice_Form_State() {
        return "//input[@id='react-select-3-input']";
    }

    protected String Automation_Practice_Form_City_Child() {
        return "//div[starts-with(@id,'react-select-4-option-')]";
    }

    protected String Automation_Practice_Form_City() {
        return "//input[@id='react-select-4-input']";
    }

    protected WebElement Automation_Practice_Form_Submit(WebDriver driver) {
        return driver.findElement(By.id("submit"));
    }

    protected WebElement Automation_Practice_Form_Rep_Student_Name(WebDriver driver) {
        return driver.findElement(By.xpath("//div[@class='table-responsive']//td[text()='Student Name']//following-sibling::td"));
    }

    protected WebElement Automation_Practice_Form_Rep_Student_Email(WebDriver driver) {
        return driver.findElement(By.xpath("//div[@class='table-responsive']//td[text()='Student Email']//following-sibling::td"));
    }

    protected WebElement Automation_Practice_Form_Rep_Gender(WebDriver driver) {
        return driver.findElement(By.xpath("//div[@class='table-responsive']//td[text()='Gender']//following-sibling::td"));
    }

    protected WebElement Automation_Practice_Form_Rep_Mobile(WebDriver driver) {
        return driver.findElement(By.xpath("//div[@class='table-responsive']//td[text()='Mobile']//following-sibling::td"));
    }

    protected WebElement Automation_Practice_Form_Rep_Date_Of_Birth(WebDriver driver) {
        return driver.findElement(By.xpath("//div[@class='table-responsive']//td[text()='Date of Birth']//following-sibling::td"));
    }

    protected WebElement Automation_Practice_Form_Rep_Subjects(WebDriver driver) {
        return driver.findElement(By.xpath("//div[@class='table-responsive']//td[text()='Subjects']//following-sibling::td"));
    }

    protected WebElement Automation_Practice_Form_Rep_Hobbies(WebDriver driver) {
        return driver.findElement(By.xpath("//div[@class='table-responsive']//td[text()='Hobbies']//following-sibling::td"));
    }

    protected WebElement Automation_Practice_Form_Rep_Picture(WebDriver driver) {
        return driver.findElement(By.xpath("//div[@class='table-responsive']//td[text()='Picture']//following-sibling::td"));
    }

    protected WebElement Automation_Practice_Form_Rep_Address(WebDriver driver) {
        return driver.findElement(By.xpath("//div[@class='table-responsive']//td[text()='Address']//following-sibling::td"));
    }

    protected WebElement Automation_Practice_Form_Rep_State_City(WebDriver driver) {
        return driver.findElement(By.xpath("//div[@class='table-responsive']//td[text()='State and City']//following-sibling::td"));
    }

    protected WebElement Handle_Iframe_Iframe_Fb(WebDriver driver) {
        return driver.findElement(By.xpath("//div[@class='face-content']//iframe"));
    }

    protected WebElement Handle_Iframe_Facebook_Likes(WebDriver driver) {
        return driver.findElement(By.xpath("//div[@class='lfloat']//div[@class='_1drq']"));
    }

    protected WebElement Handle_Windown_Tab_Login_Dictionary_Button(WebDriver driver) {
        return driver.findElement(By.xpath("//span[@class='lpr-0 hbtn hbtn-t lmt-5 fs15 cdo-login-button']"));
    }

    protected String Handle_Windown_Tab_Login_Button() {
        return "//input[@class='gigya-input-submit' and @value='Log in']";
    }

    protected WebElement Handle_Windown_Tab_Login_Button(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@class='gigya-input-submit' and @value='Log in']"));
    }

    protected WebElement Handle_Windown_Tab_Email_Error_Message(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@name='username' and @placeholder='Email *']//following-sibling::span"));
    }

    protected WebElement Handle_Windown_Tab_Password_Error_Message(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@name='password' and @placeholder='Password *']//following-sibling::span"));
    }
}
