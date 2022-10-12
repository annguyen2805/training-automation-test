package project.website;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;

public class DemoGuru99 {
    WebDriver driver;
    String userId, password;
    String name,dateOfBirth,address, city, state, pin, phone, email, gender;
    String customoerId = "";

    By nameTextbox = By.name("name");
    By dateOfBirthTextbox = By.name("dob");
    By addressTextbox = By.name("addr");
    By cityTextbox = By.name("city");
    By stateTextbox = By.name("state");
    By pinTextbox = By.name("pinno");
    By phoneTextbox = By.name("telephoneno");
    By emailTextbox = By.name("emailid");
    By passwordTextbox = By.name("password");

    @BeforeTest
    public void BeforeTest() {
        System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
        driver = new FirefoxDriver();

        name="Thu";
        dateOfBirth="1996-11-27";
        address="147\nNguyen Trãi\nHà Nội";
        city="HaNoi";
        state="HN";
        pin="123456";
        phone="0987654321";
        email="naruto" +randomNumber() + "@gmail.com";
        gender = "male";

    }

    private int randomNumber() {
        Random ran = new Random();
        return ran.nextInt(999);
    }

    @Test
    public void tc01_Register() {
        driver.get("https://www.demo.guru99.com/v4");
        driver.findElement(By.xpath("//a[text()='here']")).click();
        driver.findElement(By.xpath("//input[@name='emailid']"))
                .sendKeys(email);
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        //lấy thông tin sau đăng nhập
        userId = driver.findElement(By.xpath(
                "//table[@align='center']//td[contains(text(),'User')]/following-sibling::td")).getText();
        password = driver.findElement(By.xpath(
                "//table[@align='center']//td[contains(text(),'Password')]/following-sibling::td")).getText();
    }
    @Test
    public void tc02_Login() {
        driver.get("https://www.demo.guru99.com/v4");
        driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userId);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//marquee[@class='heading3']")).getText(),
                "Welcome To Manager's Page of Guru99 Bank");
    }
    @Test
    public void tc03_NewCustomer() {
        //Click link new customer
        driver.findElement(By.xpath("//a[text()='New Customer']")).click();

        //Input data
        driver.findElement(nameTextbox).sendKeys(name);

        JavascriptExecutor js = (JavascriptExecutor) driver;  // Delete type = date
        js.executeScript("arguments[0].removeAttribute('type');",driver.findElement(dateOfBirthTextbox));

        driver.findElement(dateOfBirthTextbox).sendKeys(dateOfBirth);
        driver.findElement(addressTextbox).sendKeys(address);
        driver.findElement(cityTextbox).sendKeys(city);
        driver.findElement(stateTextbox).sendKeys(state);
        driver.findElement(pinTextbox).sendKeys(pin);
        driver.findElement(phoneTextbox).sendKeys(phone);
        driver.findElement(emailTextbox).sendKeys(email);
        driver.findElement(passwordTextbox).sendKeys(password);

        //Click Submit
        driver.findElement(By.name("sub"));

        //Lấy text thông báo thành công

        //So sánh dữ liệu
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td]")).getText(),name);
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Gender']/following-sibling::td]")).getText(),gender);
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td]")).getText(),dateOfBirth);
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td]")).getText(),address.replace("\n"," "));
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td]")).getText(),city);
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td]")).getText(),state);
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td]")).getText(),pin);
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td]")).getText(),phone);
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td]")).getText(),email);
    }

    @AfterTest
    public void AfterTest(){
//        driver.close();
    }
}
