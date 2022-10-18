package Locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;

public class BaitapLoccator5 {
    WebDriver driver;
    String emailRd ="nan" + RandomNumber() + "@gmail.com";
    @BeforeTest
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/register");
    }
    private int RandomNumber() {
        Random ran = new Random();
        return ran.nextInt(999);
    }
    @Test
    public void Tc01_Register(){
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        driver.findElement(By.xpath("//input[@id = 'gender-female']")).click();
        driver.findElement(By.xpath("//input[@id = 'FirstName']")).sendKeys("Phạm");
        driver.findElement(By.xpath("//input[@id = 'LastName']")).sendKeys("Lan");
        Select selectDate = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
        Assert.assertEquals(32,selectDate.getOptions().size());
        selectDate.selectByIndex(1);
        Select selectMonth = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
        Assert.assertEquals(13,selectMonth.getOptions().size());
        selectMonth.selectByVisibleText("July");
        Select selectYear = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
        Assert.assertEquals(112,selectYear.getOptions().size());
        selectYear.selectByValue("2000");
        driver.findElement(By.xpath("//input[@id = 'Email']")).sendKeys(emailRd);
        driver.findElement(By.xpath("//input[@id = 'Company']")).sendKeys("Citi");
        driver.findElement(By.xpath("//input[@id = 'Password']")).sendKeys("123456a@");
        driver.findElement(By.xpath("//input[@id = 'ConfirmPassword']")).sendKeys("123456a@");
        driver.findElement(By.xpath("//button[@id = 'register-button']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='page-body']//div[@class='result']")).getText(),"Your registration completed");
    }
    @Test
    public void Tc02_Compare(){
        driver.findElement(By.xpath("//a[@class='ico-account']")).click();
        // so sánh
        Select date = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
        Select month = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
        Select year = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
        Assert.assertEquals(date.getFirstSelectedOption().getText(),"1");
        Assert.assertEquals(month.getFirstSelectedOption().getText(),"July");
        Assert.assertEquals(year.getFirstSelectedOption().getText(),"2000");
    }
    @AfterTest
    public void AfferTest(){
        driver.quit();
    }
}
