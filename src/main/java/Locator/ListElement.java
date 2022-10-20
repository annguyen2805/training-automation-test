package Locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListElement {
    protected WebElement Nopcommerce_Register_Link(WebDriver driver){
        return driver.findElement(By.xpath("//a[@class='ico-register']")) ;
    }
    protected WebElement Nopcommerce_Register_Gender_Male(WebDriver driver){
        return driver.findElement(By.id("gender-male"));
    }
    protected WebElement Nopcommerce_Register_Gender_Female(WebDriver driver){
        return driver.findElement(By.id("gender-female"));
    }
    protected WebElement Nopcommerce_Register_First_Name(WebDriver driver){
        return driver.findElement(By.id("FirstName"));
    }
    protected WebElement Nopcommerce_Register_Last_Name(WebDriver driver){
        return driver.findElement(By.id("LastName"));
    }
    protected WebElement Nopcommerce_Register_Date_Of_Birth_Day(WebDriver driver){
        return driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")) ;
    }
    protected WebElement Nopcommerce_Register_Date_Of_Birth_Month(WebDriver driver){
        return driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")) ;
    }
    protected WebElement Nopcommerce_Register_Date_Of_Birth_Year(WebDriver driver){
        return driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")) ;
    }
    protected WebElement Nopcommerce_Register_Email(WebDriver driver){
        return driver.findElement(By.id("Email"));
    }
    protected WebElement Nopcommerce_Register_Password(WebDriver driver){
        return driver.findElement(By.id("Password"));
    }
    protected WebElement Nopcommerce_Register_Confirm_Password(WebDriver driver){
        return driver.findElement(By.id("ConfirmPassword"));
    }
    protected WebElement Nopcommerce_Register_Button(WebDriver driver){
        return driver.findElement(By.id("register-button"));
    }
    protected WebElement Nopcommerce_Register_Result(WebDriver driver){
        return driver.findElement(By.xpath("//div[@class='result']")) ;
    }
    protected WebElement Nopcommerce_Register_MyAccount(WebDriver driver){
        return driver.findElement(By.xpath("//a[@class='ico-account']")) ;
    }
    protected WebElement Nopcommerce_Register_Logout(WebDriver driver){
        return driver.findElement(By.xpath("//a[@class='ico-logout']")) ;
    }

}
