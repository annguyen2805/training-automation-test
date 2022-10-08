package seleniumwebdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateFirefoxWebDriver {
    public static void main(String[] args) {
        WebDriver driver;
        System.setProperty("webdriver.gecko.driver","C:\\Users\\ADMIN\\IdeaProjects\\tranning-automation-test\\src\\main\\resources\\driver.firefox\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        String title = driver.getTitle();
        System.out.println("title = " + title);

    }
}
