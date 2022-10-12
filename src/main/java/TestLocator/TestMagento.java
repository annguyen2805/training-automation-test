package TestLocator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestMagento {
    WebDriver driver;
    @BeforeMethod
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://live.techpanda.org/");

    }

    @Test
    public void tc01_login_with_emty_email_password(){
        WebElement Myaccount = driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']"));
        Myaccount.click();

        WebElement Login = driver.findElement(By.xpath("//button[@id='send2']"));
        Login.click();

        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText(),"This is a required field.");

        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText(),"This is a required field.");
    }
    @Test
    public void tc02_login_with_incorect_email_password(){
        WebElement Myaccount = driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']"));
        Myaccount.click();

        driver.findElement(By.id("email")).sendKeys("trainningautomation@hotmail.com");
        driver.findElement(By.id("pass")).sendKeys("123123123");

        WebElement Login = driver.findElement(By.xpath("//button[@id='send2']"));
        Login.click();

        Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Invalid login or password.')]")).getText(),"Invalid login or password.");
    }


    @AfterMethod
    public void Exits(){
        driver.quit();
    }
}
