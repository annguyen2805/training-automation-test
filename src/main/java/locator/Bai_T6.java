package locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Bai_T6 {
    WebDriver driver;
    String userId, passWord;


    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void TC01() {
        //Step 01: Truy cập link https://demo.guru99.com/v4/
        driver.get("https://demo.guru99.com/v4/");

        //Step 02: Click Visit here đăng kí account
        driver.findElement(By.xpath("//a[text()='here']")).click();
        driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("trang@gmail.com");
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        //Step 03: Lấy thông tin đăng kí
        userId = driver.findElement(By.xpath(
                "//table[@align='center']//td[contains(text(),'User')]/following-sibling::td")).getText();
        passWord = driver.findElement(By.xpath(
                "//table[@align='center']//td[contains(text(),'Password')]/following-sibling::td")).getText();

        //Đang nhập trên trang https://demo.guru99.com/v4/ và verify đăng nhập thành công
        driver.get("https://demo.guru99.com/v4/");
        driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userId);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passWord);
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//marquee[@class='heading3']")).getText(),
                "Welcome To Manager's Page of Guru99 Bank");

        //Step 04: Click tap New Customer and Verify Header page display
        driver.findElement(By.xpath("//a[text()='New Customer']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//title[contains(text(),'New Customer Entry Page')]")).isDisplayed());

        //Step 05: Fill đầy đủ thông tin và ấn Save
        driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).sendKeys("Trang");
        driver.findElement(By.xpath("//td[text()='Gender']/following-sibling::td")).click();
        driver.findElement(By.xpath("//td[text()='Date of Birth']/following-sibling::td")).sendKeys("22-07-2000");
        driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).sendKeys("Vĩnh Lộc");
        driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).sendKeys("Thanh Hóa");
        driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).sendKeys("state");
        driver.findElement(By.xpath("//td[//td[text()='PIN']/following-sibling::td")).sendKeys("123456");
        driver.findElement(By.xpath("//td[text()='Mobile Number']/following-sibling::td")).sendKeys("0389569963");
        driver.findElement(By.xpath("//td[text()='E-mail']/following-sibling::td")).sendKeys("name@gmail.com");
        driver.findElement(By.xpath("//td[text()='Password']/following-sibling::td")).sendKeys("123456");
        driver.findElement(By.name("Sub")).click();

        //Verify tạo mới thành công đúng thông tin đã fill.
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(),"Trang");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Gender']/following-sibling::td")).getText(),"male");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Date of Birth']/following-sibling::td")).getText(),"22-07-2000");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(),"Vĩnh Lộc");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(),"Thanh Hóa");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(),"state");
        Assert.assertEquals(driver.findElement(By.xpath("//td[//td[text()='PIN']/following-sibling::td")).getText(),"123456");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile Number']/following-sibling::td")).getText(),"0389569963");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='E-mail']/following-sibling::td")).getText(),"22-07-2000");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Date of Birth']/following-sibling::td")).getText(),"name@gmail.com");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Password']/following-sibling::td")).getText(),"123456");


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
