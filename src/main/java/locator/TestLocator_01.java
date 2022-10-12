package locator;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestLocator_01 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }

    @Test
    public void TC01_Register_With_Empty_Data() {
        WebElement dangky = driver.findElement(By.xpath("//div[@id='leftcontent']//button[@type='submit']"));
        dangky.click();
        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");

    }

    @Test
    public void TC02_Register_With_Invalid_Email() {
        driver.findElement(By.id("txtFirstname")).sendKeys("Trang");
        driver.findElement(By.id("txtEmail")).sendKeys("trang");
        driver.findElement(By.id("txtCEmail")).sendKeys("trang");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtCPassword")).sendKeys("123456");
        driver.findElement(By.id("txtPhone")).sendKeys("0386064966");

        WebElement dangky = driver.findElement(By.xpath("//div[@id='leftcontent']//button[@type='submit']"));
        dangky.click();

        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
    }

    @Test
    public void TC03_Register_With_Incorrect_Confirm_Email() {
        driver.findElement(By.id("txtFirstname")).sendKeys("Trang");
        driver.findElement(By.id("txtEmail")).sendKeys("trangle22072k@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("trang");
        driver.findElement(By.id("txtPassword")).sendKeys("123456a");
        driver.findElement(By.id("txtCPassword")).sendKeys("123456a");
        driver.findElement(By.id("txtPhone")).sendKeys("0386064966");

        WebElement dangky = driver.findElement(By.xpath("//div[@id='leftcontent']//button[@type='submit']"));
        dangky.click();
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Email nhập lại không đúng");
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}
