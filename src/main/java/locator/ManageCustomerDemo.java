package locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class ManageCustomerDemo {
    WebDriver driver;

    private int randomNumber() {
        Random random = new Random();
        return random.nextInt(100);
    }
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup(); //khoi tao chrome
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/v4/");
    }
    @Test
    public void Register_Customer() {
        WebElement buttonVisit = driver.findElement(By.cssSelector("ol li:first-child a"));
        buttonVisit.click();
        driver.findElement(By.cssSelector("input[name='emailid']")).sendKeys("abc"+randomNumber() +"@gmail.com");
        driver.findElement(By.cssSelector("input[name='btnLogin']")).click();
        String userName=driver.findElement(By.xpath("//table//tr/td[text()='User ID :']//following-sibling::td")).getText();
        String passWord = driver.findElement(By.xpath("//table//tr/td[text()='Password :']//following-sibling::td")).getText();
        driver.get("https://demo.guru99.com/v4/");
        driver.findElement(By.cssSelector("input[name='uid']")).sendKeys(userName);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(passWord);
        driver.findElement(By.cssSelector("input[name='btnLogin']")).click();
        driver.findElement(By.cssSelector("//ul[@class='menusubnav']//li//a[text()='New Customer']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//p[text()='Add New Customer']")).getText(), "Add New Customer");
        driver.findElement(By.xpath("//input[@onkeyup='validatecustomername();']")).sendKeys("Thuy CHieu");
        driver.findElement(By.xpath("//input[@value='f']")).click();
        driver.findElement(By.xpath("//input[@onkeyup='validatedob();']")).sendKeys("12/12/1993");
        driver.findElement(By.xpath("//input[@onkeyup='validateAddress();']")).sendKeys("difhsif fusiu fsuii ");
        driver.findElement(By.xpath("//input[@onkeyup='validateCity();']")).sendKeys("difhsif fusiu fsuii ");
        driver.findElement(By.xpath("//input[@onkeyup='validateState();']")).sendKeys("state");
        driver.findElement(By.xpath("//input[@onkeyup='validatePIN();']")).sendKeys("4756934343");
        driver.findElement(By.xpath("//input[@onkeyup='validateTelephone();']")).sendKeys("4537458");
        driver.findElement(By.xpath("//input[@onkeyup='validateEmail();']")).sendKeys("chieu"+randomNumber()+"citogo.com");
        driver.findElement(By.xpath("//input[@onkeyup='validatepassword();']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//table//tr/td[text()='Customer ID']//following-sibling::td")).getText(), "Thuy CHieu");
        Assert.assertEquals(driver.findElement(By.xpath("//table//tr/td[text()='Customer Name']//following-sibling::td")).getText(), "Thuy CHieu");
        Assert.assertEquals(driver.findElement(By.xpath("//table//tr/td[text()='Gender']//following-sibling::td")).getText(), "female");
        Assert.assertEquals(driver.findElement(By.xpath("//table//tr/td[text()='Birthdate']//following-sibling::td")).getText(), "12/12/1993");
        Assert.assertEquals(driver.findElement(By.xpath("//table//tr/td[text()='Address']//following-sibling::td")).getText(), "difhsif fusiu fsuii ");
        Assert.assertEquals(driver.findElement(By.xpath("//table//tr/td[text()='City']//following-sibling::td")).getText(), "difhsif fusiu fsuii ");
        Assert.assertEquals(driver.findElement(By.xpath("//table//tr/td[text()='State']//following-sibling::td")).getText(), "state");
        Assert.assertEquals(driver.findElement(By.xpath("//table//tr/td[text()='Pin']//following-sibling::td")).getText(), "4756934343");
        Assert.assertEquals(driver.findElement(By.xpath("//table//tr/td[text()='Mobile No.']//following-sibling::td")).getText(), "4537458");
        Assert.assertEquals(driver.findElement(By.xpath("//table//tr/td[text()='Email']//following-sibling::td")).getText(), "chieu"+randomNumber()+"citogo.com");












    }

}
