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

public class BaitapLocator {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }
    @Test
     public void Bai1(){
         WebElement dangky = driver.findElement(By.xpath("//div[@id='leftcontent']//button[@class='btn_pink_sm fs16']"));
         dangky.click();
         WebElement Hovaten = driver.findElement(By.xpath("//div[@id='leftcontent']//label[@id='txtFirstname-error']"));
         Assert.assertEquals(Hovaten.getText(),"Vui lòng nhập họ tên");
         WebElement Email = driver.findElement(By.xpath("//div[@id='leftcontent']//label[@id='txtEmail-error']"));
         Assert.assertEquals(Email.getText(),"Vui lòng nhập email");
         WebElement NLEmail = driver.findElement(By.xpath("//div[@id='leftcontent']//label[@id='txtCEmail-error']"));
         Assert.assertEquals(NLEmail.getText(),"Vui lòng nhập lại địa chỉ email");
         WebElement Matkhau = driver.findElement(By.xpath("//div[@id='leftcontent']//label[@id='txtPassword-error']"));
         Assert.assertEquals(Matkhau.getText(),"Vui lòng nhập mật khẩu");
         WebElement NLMatkhau = driver.findElement(By.xpath("//div[@id='leftcontent']//label[@id='txtCPassword-error']"));
         Assert.assertEquals(NLMatkhau.getText(),"Vui lòng nhập lại mật khẩu");
         WebElement sdt = driver.findElement(By.xpath("//div[@id='leftcontent']//label[@id='txtPhone-error']"));
         Assert.assertEquals(sdt.getText(),"Vui lòng nhập số điện thoại.");
     }
    @Test
    public void Bai2(){
        //Nhập data vào from đăng ký
        /*WebElement IpHoten = driver.findElement(By.xpath("//div[@id='leftcontent']//label[@id='txtFirstname']"));
        IpHoten.sendKeys("Phạm Lan");*/
       // driver.findElement(By.xpath("//div[@id='leftcontent']//label[@id='txtEmail']")).sendKeys("");;
        driver.findElement(By.id("txtFirstname")).sendKeys("Pham Lan");;
        driver.findElement(By.id("txtEmail")).sendKeys("");;
        driver.findElement(By.id("txtCEmail")).sendKeys("");;
        driver.findElement(By.id("txtPassword")).sendKeys("123456a@");;
        driver.findElement(By.id("txtCPassword")).sendKeys("123456a@");;
        driver.findElement(By.id("txtPhone")).sendKeys("0387338333");;
        //Click vào btn đang ký
        WebElement btndangky = driver.findElement(By.xpath("//div[@id='leftcontent']//button[@class='btn_pink_sm fs16']"));
        btndangky.click();
        WebElement Email = driver.findElement(By.xpath("//div[@id='leftcontent']//label[@id='txtEmail-error']"));
        Assert.assertEquals(Email.getText(),"Vui lòng nhập email");
        WebElement NLEmail = driver.findElement(By.xpath("//div[@id='leftcontent']//label[@id='txtCEmail-error']"));
        Assert.assertEquals(NLEmail.getText(),"Vui lòng nhập lại địa chỉ email");
    }
    @Test
    public void Bai3(){
        //Nhập data vào from đăng ký
        /*WebElement IpHoten = driver.findElement(By.xpath("//div[@id='leftcontent']//label[@id='txtFirstname']"));
        IpHoten.sendKeys("Phạm Lan");*/
        // driver.findElement(By.xpath("//div[@id='leftcontent']//label[@id='txtEmail']")).sendKeys("");;
        driver.findElement(By.id("txtFirstname")).sendKeys("Pham Lan");;
        driver.findElement(By.id("txtEmail")).sendKeys("lanpth2812@gmail.com");;
        driver.findElement(By.id("txtCEmail")).sendKeys("");;
        driver.findElement(By.id("txtPassword")).sendKeys("123456a@");;
        driver.findElement(By.id("txtCPassword")).sendKeys("123456a@");;
        driver.findElement(By.id("txtPhone")).sendKeys("0387338333");;

        //Click vào btn đang ký
        WebElement btndangky = driver.findElement(By.xpath("//div[@id='leftcontent']//button[@class='btn_pink_sm fs16']"));
        btndangky.click();
        WebElement NLEmail = driver.findElement(By.xpath("//div[@id='leftcontent']//label[@id='txtCEmail-error']"));
        Assert.assertEquals(NLEmail.getText(),"Vui lòng nhập lại địa chỉ email");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
