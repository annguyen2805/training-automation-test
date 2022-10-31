package handle.webelement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC04_AddInfoToForm {
    WebDriver driver;

    @Test
    public void tc01_VerifyUrl() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().setSize(new Dimension(700, 1000));

        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Minh");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Thu");
        WebElement radioButton = driver.findElement(By.xpath("//label[@class='custom-control-label' and text()='Male']"));
        scrollElement(radioButton);
        radioButton.click();

        driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys("0987654321");


        WebElement element = driver.findElement(By.xpath("//button[@id='submit']"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", element);
//        Thread.sleep(500);
        scrollElement(element);
        element.click();

//        driver.findElement(By.xpath("//div[@class='table-responsive']//td[text(🙁'Student Name']/following-sibling::td"));
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='table-responsive']//td[text()='Student Name']/following-sibling::td")).getText(),
                "Minh Thu");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='table-responsive']//td[text()='Gender']/following-sibling::td")).getText(),
                "Male");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='table-responsive']//td[text()='Mobile']/following-sibling::td")).getText(),
                "0987654321");

    }

    public void scrollElement(WebElement element) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
    }

    @BeforeTest
    public void BeforeTest() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @AfterTest
    public void AfterTest(){
//        driver.close();
    }
}
