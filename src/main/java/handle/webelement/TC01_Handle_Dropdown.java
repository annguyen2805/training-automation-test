package handle.webelement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Random;

public class TC01_Handle_Dropdown {
    WebDriver driver;

    @Test
    public void TC01_Register() {
        driver.get("https://demo.nopcommerce.com/register");
        //Click Register
        driver.findElement(By.xpath("//a[text()='Register']")).click();

        //Input infomation

        driver.findElement(By.xpath("//input[@id='gender-female']")).click();
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("first name");
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("last name");

        Select day = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
        day.selectByVisibleText("1");
        System.out.println(day.getOptions().size());
        Assert.assertEquals(day.getOptions().size(),32);

        Select month = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
        month.selectByVisibleText("July");
        System.out.println(month.getOptions().size());
        Assert.assertEquals(month.getOptions().size(),13);

        Select year = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
        year.selectByVisibleText("2000");
        System.out.println(year.getOptions().size());
        Assert.assertEquals(year.getOptions().size(),112);

        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("minhthu" +randomNumber() + "@gmail.com");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123456");

        //Click Register
        driver.findElement(By.xpath("//button[@id='register-button']")).click();

        //Verify
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='result']")).getText(),"Your registration completed");

    }

    @Test
    public void TC02_checkAccount(){
        //Click My Account
        driver.findElement(By.xpath("//a[@class='ico-account']")).click();

        //Verify
        Select day1 = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
        Select month1 = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
        Select year1 = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));

        Assert.assertEquals(day1.getFirstSelectedOption().getText(),"1");
        Assert.assertEquals(month1.getFirstSelectedOption().getText(),"July");
        Assert.assertEquals(year1.getFirstSelectedOption().getText(),"2000");
    }

    @BeforeTest
    public void BeforeTest() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @AfterTest
    public void AfterTest(){
//        driver.close();
    }

    private int randomNumber() {
        Random ran = new Random();
        return ran.nextInt(999);
    }
}
