package seleniumwebdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CreateMsedgeWebdiver {
    public static void main(String[] args) {
        WebDriver driver;
        System.setProperty("webdriver.edge.driver","C:\\Users\\ADMIN\\IdeaProjects\\tranning-automation-test\\src\\main\\resources\\driver.msedge\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        String title = driver.getTitle();
        System.out.println("title = " + title);
    }
}
