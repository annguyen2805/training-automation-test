package location.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Web_Alada {
    WebDriver driver;

    @BeforeMethod
    public void BeforeMethod(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.manage().window().maximize();
    }

    @Test
    public void TC01_Register_Empty_Data() throws InterruptedException {
        // click button Đăng ký
        driver.findElement(By.xpath("//div[@class='field_btn']/button[text()='ĐĂNG KÝ']")).click();

        Thread.sleep(1000);

        ArrayList<String> listActual = new ArrayList<>();
        listActual.add("Vui lòng nhập họ tên");
        listActual.add("Vui lòng nhập email");
        listActual.add("Vui lòng nhập lại địa chỉ email");
        listActual.add("Vui lòng nhập mật khẩu");
        listActual.add("Vui lòng nhập lại mật khẩu");
        listActual.add("Vui lòng nhập số điện thoại.");

        List<WebElement> listError = driver.findElements(By.xpath("//label[@class='error']"));
        ArrayList<String> listErrorText = new ArrayList<>();
        for (WebElement w: listError) {
            System.out.println(w.getText());
            listErrorText.add(w.getText());
        }
        Assert.assertEquals(listErrorText,listActual);
    }

    @Test
    public void TC02_Register_Invalid_Email(){
        driver.findElement(By.id("txtFirstname")).sendKeys("Minh Thu");
        driver.findElement(By.id("txtEmail")).sendKeys("email");
        driver.findElement(By.id("txtCEmail")).sendKeys("email");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtCPassword")).sendKeys("123456");
        driver.findElement(By.id("txtPhone")).sendKeys("0987654321");

        // click button Đăng ký
        driver.findElement(By.xpath("//div[@class='field_btn']/button[text()='ĐĂNG KÝ']")).click();

        //Verify
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email hợp lệ");

        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Email nhập lại không đúng");
    }

    @Test
    public void TC03_Register_Incorrect_Confirm_Email() throws InterruptedException {
        Random ran = new Random();
        driver.findElement(By.id("txtFirstname")).sendKeys("Minh Thu");
        String email = "mothu"+ ran.nextInt(9999) + "@gmail.com";
        driver.findElement(By.id("txtEmail")).sendKeys(email);
        driver.findElement(By.id("txtCEmail")).sendKeys("email@g.vn");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtCPassword")).sendKeys("123456");
        driver.findElement(By.id("txtPhone")).sendKeys("0987654321");

        // click button Đăng ký
        driver.findElement(By.xpath("//div[@class='field_btn']/button[text()='ĐĂNG KÝ']")).click();

        //Verify
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Email nhập lại không đúng");
    }


        @AfterMethod
    public void AfterMethod(){
//        driver.quit();
    }
}
