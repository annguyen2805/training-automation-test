package Locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoLocator {
    WebDriver driver;
    @BeforeMethod
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void tc01RegisterWithEmptyData()
    {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(),"Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Vui lòng nhập số điện thoại.");

    }
    @Test
    public void tc02RegisterWithInvalidEmail()
    {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtFirstname"))).sendKeys("Mỹ Linh");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtEmail"))).sendKeys("linhntm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtCEmail"))).sendKeys("linhntm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtPassword"))).sendKeys("123456");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtCPassword"))).sendKeys("123456");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtPhone"))).sendKeys("0121345678");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();

        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Email nhập lại không đúng");


    }
    @Test
    public void tc03RegisterWithIncorrectConfirmEmail()
    {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtFirstname"))).sendKeys("Mỹ Linh");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtEmail"))).sendKeys("linh@gmail.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtCEmail"))).sendKeys("linhntm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtPassword"))).sendKeys("123456");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtCPassword"))).sendKeys("123456");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtPhone"))).sendKeys("0121345678");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();

        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Email nhập lại không đúng");


    }
    @Test
    public void tc04LoginWithEmptyEmailPassword()
    {
        driver.get("http://live.techpanda.org/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='footer']//a[@title='My Account']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit' and @title='Login']"))).click();


        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(),"This is a required field.");
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(),"This is a required field.");

    }
    @Test
    public void tc05LoginWithIncorrectEmailPassword()
    {
        driver.get("http://live.techpanda.org/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='footer']//a[@title='My Account']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='login[username]' ]"))).sendKeys("trainningautomation@hotmail.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password' ]"))).sendKeys("123123123");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit' and @title='Login']"))).click();


        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='error-msg' ]"))).getText(),"Invalid login or password.");

    }
    @AfterMethod
    public void tearDown()
    {

        driver.quit();
    }
}
