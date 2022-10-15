package TestLocator;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class TestGuru99 {
    WebDriver driver;
    String email,userId,password,customerId;
    private int randomNumber()
    {
        Random randomNumber = new Random();
        return randomNumber.nextInt(999);
    }    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/v4/");
        email = "buihuong"+randomNumber()+"@gmail.com";
    }
    @Test
    public void dang_ki_account(){

        WebElement visit_here = driver.findElement(By.xpath("//a[contains(text(),'here')]"));
        visit_here.click();
        driver.findElement(By.xpath("//input[@name='emailid']/following-sibling::label")).sendKeys(email);
        WebElement submit_email = driver.findElement(By.xpath("//input[@name='btnLogin']"));
        userId = String.valueOf(driver.findElement(By.xpath("//td[contains(text(),'User ID')]/following-sibling::td")));
        password = String.valueOf(driver.findElement(By.xpath("//td[contains(text(),'Password :')]/following-sibling::td")));

    }
    @Test
    public void dang_nhap(){
        driver.get("https://demo.guru99.com/v4/");
        driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userId);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//marquee[contains(text(),'Welcome')]")).getText(),"Welcome To Manager's Page of Guru99 Bank");
    }
    @Test
    public void new_customer(){
        driver.findElement(By.xpath("//a[contains(text(),'New Customer')]")).click();
        driver.findElement(By.xpath("//p[contains(text(),'Add New Customer')]")).isDisplayed();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Buihuong");
        driver.findElement(By.xpath("//input[@value='f']")).click();
        driver.findElement(By.xpath("//input[@type='date']")).sendKeys("10152022");
        driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys("Me Linh");
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Ha Noi");
        driver.findElement(By.xpath("//input[@name='state']")).sendKeys("Viet Name");
        driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys("0123456");
        driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys("0334567891");
        driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@name='sub']")).click();
        driver.findElement(By.xpath("//p[contains(text(),'Customer Registered Successfully!!!')]")).isDisplayed();
        customerId = String.valueOf(driver.findElement(By.xpath("//td[contains(text(),'Customer ID')]/following-sibling::td")));

    }
    @Test
    public void edit(){
        driver.findElement(By.xpath("//a[contains(text(),'Edit Customer')]")).click();
        driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys(customerId);
        driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();
        driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys("Edit");
        driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys("0334567999");
        driver.findElement(By.xpath("//input[@name='sub']")).click();
        //web tb message no changes trong khi đã edit thành công ???
    }
    @Test
    public void delete(){
        driver.findElement(By.xpath("//a[contains(text(),'Delete Account')]")).click();
        driver.findElement(By.xpath("//input[@name='accountno']")).sendKeys(customerId);
        driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();
        driver.switchTo().alert().accept();
    }
    @AfterMethod
    public void after(){
        driver.quit();
    }
}
