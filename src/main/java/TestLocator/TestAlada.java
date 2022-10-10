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

public class TestAlada {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }

    @Test
    public void TC01_Register_with_empty_data(){
       WebElement Submit = driver.findElement(By.xpath("//button[@type='submit']"));
       Submit.click();

       Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtFirstname-error']")).getText(),"Vui lòng nhập họ tên");

       Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtEmail-error']")).getText(),"Vui lòng nhập email");

       Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText(),"Vui lòng nhập lại địa chỉ email");

       Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPassword-error']")).getText(),"Vui lòng nhập mật khẩu");

       Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText(),"Vui lòng nhập lại mật khẩu");

       Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText(),"Vui lòng nhập số điện thoại.");

    }

    @Test
    public void TC02_Register_with_Invalid_Email(){

        driver.findElement(By.id("txtFirstname")).sendKeys("Bui Huong");
        driver.findElement(By.id("txtEmail")).sendKeys("huong");
        driver.findElement(By.id("txtCEmail")).sendKeys("huong");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtCPassword")).sendKeys("123456");
        driver.findElement(By.id("txtPhone")).sendKeys("0358922221");

        WebElement Submit = driver.findElement(By.xpath("//button[@type='submit']"));
        Submit.click();

        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtEmail-error']")).getText(),"Vui lòng nhập email hợp lệ");

        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText(),"Email nhập lại không đúng");

    }
    @Test
    public void TC03_Register_with_incorrect_confirm_Email(){
        driver.findElement(By.id("txtFirstname")).sendKeys("Bui Huong");
        driver.findElement(By.id("txtEmail")).sendKeys("huong");
        driver.findElement(By.id("txtCEmail")).sendKeys("huong000");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtCPassword")).sendKeys("123456");
        driver.findElement(By.id("txtPhone")).sendKeys("0358922221");

        WebElement Submit = driver.findElement(By.xpath("//button[@type='submit']"));
        Submit.click();

        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText(),"Email nhập lại không đúng");

    }

    @AfterMethod
    public void After(){
        driver.quit();
    }

}
