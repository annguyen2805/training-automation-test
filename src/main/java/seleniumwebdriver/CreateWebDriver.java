package seleniumwebdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateWebDriver {
    public static void main(String[] args) {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ADMIN\\IdeaProjects\\tranning-automation-test\\src\\main\\resources\\driver.chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        String title = driver.getTitle();
        System.out.println("title = " + title);
    }
}
