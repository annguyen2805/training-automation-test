package location.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Template {
    WebDriver driver;

    @BeforeMethod
    public void BeforeMethod(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("");
        driver.manage().window().maximize();

    }

    @Test
    public void Register_Empty_Data(){

    }

    @AfterMethod
    public void AfterMethod(){

    }
}
