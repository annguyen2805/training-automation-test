package selenium_commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DropdownList {

    @Test
    public void TC01_Handle_DropList() {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Step01: Truy cập vào trang  https://demo.nopcommerce.com
        driver.get("https://demo.nopcommerce.com/");

        //Step 02: Click register
        driver.findElement(By.xpath("//a[text()='Register']")).click();

        //Step 03: input các thông tin hợp lệ vào form
        driver.findElement(By.xpath("//input[@id='gender-male']")).click();
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Trang");
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Le");

        Select day = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
        day.selectByIndex(1);
        Assert.assertEquals(day.getOptions().size(), 32);

        Select month = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
        month.selectByIndex(7);
        Assert.assertEquals(month.getOptions().size(), 13);

        Select year = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
        year.selectByVisibleText("2000");
        Assert.assertEquals(year.getOptions().size(), 112);

        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("trang@gmail.com");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123456");

        //Step 04: Click Register
        driver.findElement(By.xpath("//button[@id='register-button']")).click();

        //Step 05: Verify Đã đăng kí thành công

        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]")).isDisplayed());

        //Step 06: Click vào tap My account kiểm tra ngày tháng vừa nhập vào đúng
        driver.findElement(By.xpath("//a[@class='ico-account']")).click();
        Select daySelected = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
        Select monthSelected = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
        Select yearSelected = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));

        Assert.assertEquals(daySelected.getFirstSelectedOption().getText(), "1");
        Assert.assertEquals(monthSelected.getFirstSelectedOption().getText(), "July");
        Assert.assertEquals(yearSelected.getFirstSelectedOption().getText(), "2000");


    }


}
