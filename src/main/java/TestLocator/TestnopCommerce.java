package TestLocator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class TestnopCommerce {
    WebDriver driver;
    private String email;
    private int randomNumber()
    {
        Random randomNumber = new Random();
        return randomNumber.nextInt(999);
    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com");
        email = "buihuong"+randomNumber()+"@gmail.com";

    }
    @Test
    public void TC01_Register() {
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        driver.findElement(By.xpath("//input[@id='gender-female']")).click();
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Bui");
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Huong");
        Select selectByIndex = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
        selectByIndex.selectByIndex(1);
        Assert.assertEquals(32, selectByIndex.getOptions().size());
        Select selectByText = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
        selectByText.selectByVisibleText("July");
        Assert.assertEquals(13, selectByText.getOptions().size());
        Select selectByValue = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
        selectByValue.selectByValue("2000");
        Assert.assertEquals(112, selectByValue.getOptions().size());
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@id='register-button']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='result']")).getText(), "Your registration completed");

    }
    @Test
    public void TC02_Verify(){
        driver.findElement(By.xpath("//a[@class='ico-account']")).click();
        Select date = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
        Assert.assertEquals(date.getFirstSelectedOption().getText(),"1");
        Select month = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
        Assert.assertEquals(month.getFirstSelectedOption().getText(),"July");
        Select year = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
        Assert.assertEquals(year.getFirstSelectedOption().getText(),"2000");
    }
    @AfterMethod
    public void After(){
        driver.quit();
    }
}
