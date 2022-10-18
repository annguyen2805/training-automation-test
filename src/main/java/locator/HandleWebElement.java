package locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.Random;

public class HandleWebElement {
    WebDriver driver;

    private int Random() {
        Random random = new Random();
        return random.nextInt(100);
    }

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com");
    }

    @Test
    public void TC06_NopCommerce() {
        driver.findElement(By.className("ico-register")).click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Chieu");
        driver.findElement(By.id("LastName")).sendKeys("Do Thuy");
        WebElement selectDate = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
        Select select = new Select(selectDate);
        select.selectByValue("1");
        Assert.assertEquals(32, select.getOptions().size());
        WebElement selectMonth = driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
        Select select1 = new Select(selectMonth);
        select1.selectByValue("7");
        Assert.assertEquals(13, select1.getOptions().size());
        WebElement selectYear = driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
        Select select2 = new Select(selectYear);
        select2.selectByValue("2000");
        Assert.assertEquals(112, select2.getOptions().size());
        driver.findElement(By.id("Email")).sendKeys("chieu" + Random() + "@gmail.com");
        driver.findElement(By.id("Company")).sendKeys("Microsoft company");
        driver.findElement(By.id("Password")).sendKeys("123456");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("123456");
        driver.findElement(By.id("register-button")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/registerresult/1?returnUrl=/");
        driver.findElement(By.className("ico-account")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']//option[@selected]")).getText(), "1");
        Assert.assertEquals(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']//option[@selected]")).getText(), "July");
        Assert.assertEquals(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']//option[@selected]")).getText(), "2000");
//        Assert.assertTrue(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']//option[@selected]")), "1");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
