package handlewebelement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.Random;

public class TC04_Add_Info_To_form {
    private int Random() {
        Random random = new Random();
        return random.nextInt(100);
    }

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @Test
    public void Add_Info_To_Form() throws InterruptedException {
        driver.findElement(By.id("firstName")).sendKeys("chieu");
        driver.findElement(By.id("lastName")).sendKeys("do");
        driver.findElement(By.id("userEmail")).sendKeys("chieu" + Random() + "@gmail.com");
        driver.findElement(By.className("custom-control-label")).click();
        driver.findElement(By.id("userNumber")).sendKeys("0948578780");
        driver.findElement(By.id("dateOfBirthInput")).click();
        WebElement mounth = driver.findElement(By.className("react-datepicker__month-select"));
        Select slectMounth = new Select(mounth);
        slectMounth.selectByValue("1");
        WebElement year = driver.findElement(By.className("react-datepicker__year-select"));
        Select selectYear = new Select(year);
        selectYear.selectByValue("1993");
        driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day') and text() = 15]")).click();
        driver.findElement(By.id("subjectsInput")).sendKeys("M");
        Thread.sleep(1000);
        driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']")).click();
        WebElement uploadFile = driver.findElement(By.id("uploadPicture"));
        uploadFile.sendKeys("C:\\img\\QRcode.png");
        driver.findElement(By.id("currentAddress")).sendKeys("Hanoi");
        driver.findElement(By.id("state")).click();
        driver.findElement(By.xpath("//div[@id='react-select-3-option-0']")).click();
        driver.findElement(By.id("city")).click();
        driver.findElement(By.xpath("//div[@id='react-select-4-option-0']")).click();
        driver.findElement(By.id("submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='modal-content']//td[text()='Student Name']//following-sibling::td")), "chieu do");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='modal-content']//td[text()='Student Email']//following-sibling::td")), "chieu" + Random() + "@gmail.com");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='modal-content']//td[text()='Gender']//following-sibling::td")), "Female");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='modal-content']//td[text()='Mobile']//following-sibling::td")), "0948578780");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='modal-content']//td[text()='Date of Birth']//following-sibling::td")), "15 February,1993");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='modal-content']//td[text()='Subjects']//following-sibling::td")), "Maths");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='modal-content']//td[text()='Hobbies']//following-sibling::td")), "Sports");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='modal-content']//td[text()='Picture']//following-sibling::td")), "QRcode.png");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='modal-content']//td[text()='Address']//following-sibling::td")), "Hanoi");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='modal-content']//td[text()='State and City']//following-sibling::td")), "NCR Delhi");
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
