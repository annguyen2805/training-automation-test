package locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class techPanda {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://live.techpanda.org/");
        WebElement clickButton = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
        clickButton.click();
    }

    @Test
//   TC_04
    public void login_With_Empty_Email_Password() {

        WebElement clickLogin = driver.findElement(By.xpath("//button[@title='Login']"));
        clickLogin.click();
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(), "This is a required field.");
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(), "This is a required field.");
    }

    @Test
    //  TC_05
    public void login_With_Incorrect_Email_Password() {
        driver.findElement(By.id("email")).sendKeys("trainningautomation@hotmail.com");
        driver.findElement(By.id("pass")).sendKeys("123123123");
        WebElement clickLogin = driver.findElement(By.xpath("//button[@title='Login']"));
        clickLogin.click();
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='error-msg']//span")), "Invalid login or password.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
