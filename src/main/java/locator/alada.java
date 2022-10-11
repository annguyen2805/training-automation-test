package locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class alada {
    WebDriver driver;

    @BeforeMethod
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }

    @Test
//    TC_01
    public void register_With_Empty_Data() {
        WebElement findRegisterButton = driver.findElement(By.xpath("//button[@type='submit']"));
        findRegisterButton.click();
//        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
//        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
//        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
//        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
//        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
//        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");
        Assert.assertTrue(driver.findElement(By.id("txtFirstname-error")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("txtEmail-error")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("txtCEmail-error")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("txtPassword-error")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("txtCPassword-error")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("txtPhone-error")).isDisplayed());

    }

    @Test
    //    TC_02
    public void register_With_Invalid_Email() {
        driver.findElement(By.id("txtFirstname")).sendKeys("THủy Chiều");
        driver.findElement(By.id("txtEmail")).sendKeys("abc");
        driver.findElement(By.id("txtCEmail")).sendKeys("abc");
        driver.findElement(By.id("txtPassword")).sendKeys("1235677");
        driver.findElement(By.id("txtCPassword")).sendKeys("1235677");
        driver.findElement(By.id("txtPhone")).sendKeys("0987656444");
        WebElement findRegisterButton = driver.findElement(By.xpath("//button[@type='submit']"));
        findRegisterButton.click();
//        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
//        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
        Assert.assertTrue(driver.findElement(By.id("txtEmail-error")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("txtCEmail-error")).isDisplayed());

    }

    @Test
    //    TC_03
    public void register_With_Incorrect_Confirm_Email() {
        driver.findElement(By.id("txtFirstname")).sendKeys("chieu");
        driver.findElement(By.id("txtEmail")).sendKeys("abc@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("sds");
        driver.findElement(By.id("txtPassword")).sendKeys("1235677");
        driver.findElement(By.id("txtCPassword")).sendKeys("1235677");
        driver.findElement(By.id("txtPhone")).sendKeys("0987656444");
        WebElement findRegisterButton = driver.findElement(By.xpath("//button[@type='submit']"));
        findRegisterButton.click();
//        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
        Assert.assertTrue(driver.findElement(By.id("txtCEmail-error")).isDisplayed());
    }

    @AfterClass
    public void tearDown() {

//        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        driver.quit();
    }

}
