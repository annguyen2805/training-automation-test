package Locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;

public class BaitapLocator6 {
    WebDriver driver;
    String emailRd ="nan" + randomNumber() + "@gmail.com";
    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/v4/");

    }
    public int randomNumber() {
        Random ran = new Random();
        return ran.nextInt(999);
    }
    @Test
    public void TC01(){
        driver.findElement(By.xpath("//a[text()='here']")).click();
        driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("lanpth2@gmail.com");
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
        WebElement user = driver.findElement(By.xpath("//table[@align='center']//tr[4]//td[2]"));
        var userText =  user.getText();
        WebElement pass = driver.findElement(By.xpath("//table[@align='center']//tr[5]//td[2]"));
        var passText = pass.getText();
        driver.get("https://demo.guru99.com/v4/");
        driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userText);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passText);
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
        WebElement heading = driver.findElement(By.xpath("//marquee[@class='heading3']"));
        Assert.assertEquals(heading.getText(),"Welcome To Manager's Page of Guru99 Bank");
    }
   @Test
    public void TC02(){
        driver.findElement(By.xpath("//ul[@class='menusubnav']//li[2]")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("PhamLan");
        driver.findElement(By.xpath("//input[@name='dob']")).sendKeys("28-12-1998");
        driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys("Hà Nội");
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys("HN");
        driver.findElement(By.xpath("//input[@name='state']")).sendKeys("HN");
        driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys("0387338338");
        driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(emailRd);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123");
        driver.findElement(By.xpath("//input[@name='sub']")).click();
        //WebElement nameText = driver.findElement(By.xpath("//table[@name='customer']//tr[4]//td[2]"));
       Assert.assertEquals(driver.findElement(By.xpath("//table[@name='customer']//tr[5]//td[2]")).getText(),"PhamLan");
       Assert.assertEquals(driver.findElement(By.xpath("//table[@name='customer']//tr[6]//td[2]")).getText(),"male");
       Assert.assertEquals(driver.findElement(By.xpath("//table[@name='customer']//tr[7]//td[2]")).getText(),"1998-12-28");
       Assert.assertEquals(driver.findElement(By.xpath("//table[@name='customer']//tr[8]//td[2]")).getText(),"Hà Nội");
       Assert.assertEquals(driver.findElement(By.xpath("//table[@name='customer']//tr[9]//td[2]")).getText(),"HN");
       Assert.assertEquals(driver.findElement(By.xpath("//table[@name='customer']//tr[10]//td[2]")).getText(),"HN");
       Assert.assertEquals(driver.findElement(By.xpath("//table[@name='customer']//tr[11]//td[2]")).getText(),"123456");
       Assert.assertEquals(driver.findElement(By.xpath("//table[@name='customer']//tr[12]//td[2]")).getText(),"0387338338");
       Assert.assertEquals(driver.findElement(By.xpath("//table[@name='customer']//tr[13]//td[2]")).getText(),emailRd);
    }

}
