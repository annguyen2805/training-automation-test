package Locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaitapLocator2 {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://live.techpanda.org/");
    }
    @Test
    public void Bai4(){
        WebElement Myaccount = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
        Myaccount.click();
        WebElement btndangky = driver.findElement(By.id("send2"));
        btndangky.click();
        WebElement EmailAdress = driver.findElement(By.id("advice-required-entry-email"));
        Assert.assertEquals(EmailAdress.getText(),"This is a required field.");
        WebElement Password = driver.findElement(By.id("advice-required-entry-pass  "));
        Assert.assertEquals(Password.getText(),"This is a required field.");
    }
    @Test
    public void Bai5(){
        WebElement Myaccount = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
        Myaccount.click();
        driver.findElement(By.id("email")).sendKeys("trainningautomation@hotmail.com");;
        driver.findElement(By.id("pass")).sendKeys("123123123");;
        WebElement btndangky = driver.findElement(By.id("send2"));
        btndangky.click();
        WebElement error = driver.findElement(By.xpath("//li/span"));
        Assert.assertEquals(error.getText(),"Invalid login or password.");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
