package selenium_commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class Handle_Popup {
    @Test
    public void TC04_Add_Infor_To_Form(){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/automation-practice-form");
        //input thông tin
        driver.findElement(By.id("firstName")).sendKeys("Trang");
        driver.findElement(By.id("lastName")).sendKeys("Le");
        driver.findElement(By.id("userEmail")).sendKeys("trang@gmail.com");
        driver.findElement(By.xpath("//input[@name='gender' and @value='Male']/parent::div")).click();
        driver.findElement(By.id("userNumber")).sendKeys("0386064469");
        driver.findElement(By.id("dateOfBirthInput")).click();
        driver.findElement(By.xpath("//div[@aria-label='Choose Thursday, November 17th, 2022']")).click();
        driver.findElement(By.xpath("//input[@id='subjectsInput']")).sendKeys("t");
        driver.findElement(By.id("react-select-2-option-0")).click();
        driver.findElement(By.xpath("//input[@id='hobbies-checkbox-1']/parent::div")).click();
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\tranglt3\\IdeaProjects\\baitap-topic5\\src\\test\\test.png");
        driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("Hà Nội");
        driver.findElement(By.id("state")).click();
        driver.findElement(By.xpath("//div[@id='react-select-3-option-0']")).click();
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("react-select-4-option-0")).click();
        driver.findElement(By.xpath("//button[@id='submit']")).click();

        //verify
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='table-responsive']//td[text(🙁'Student Name']/following-sibling::td")).getText(),
                "Trang Le");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='table-responsive']//td[text(🙁'Student Email']/following-sibling::td")).getText(),
                "trang@gmail.com");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='table-responsive']//td[text(🙁'Gender']/following-sibling::td")).getText(),
                "Male");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='table-responsive']//td[text(🙁'Mobile']/following-sibling::td")).getText(),
                "0386064469");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='table-responsive']//td[text(🙁'Date of Birth']/following-sibling::td")).getText(),
                "17 November,2022");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='table-responsive']//td[text(🙁'Subjects']/following-sibling::td")).getText(),
                "Maths");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='table-responsive']//td[text(🙁'Hobbies']/following-sibling::td")).getText(),
                "Sports");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='table-responsive']//td[text(🙁'Picture']/following-sibling::td")).getText(),
                "test.png");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='table-responsive']//td[text(🙁'Address']/following-sibling::td")).getText(),
                "Hà Nội");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='table-responsive']//td[text(🙁'State and City']/following-sibling::td")).getText(),
                "NCR Delhi");

        driver.quit();


    }
}