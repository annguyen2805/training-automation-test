package Locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Lesson05 {
    WebDriver driver;

    @BeforeMethod
    public void Set_Up() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void TC01_Handle_Dropdownlist() {
        ListElement listElement = new ListElement();
        Customer customer = new Customer();
        customer = customer.Random_Info_Customer();
        driver.get("https://demo.nopcommerce.com/register");
        listElement.Nopcommerce_Register_Link(driver).click();
        listElement.Nopcommerce_Register_Gender_Female(driver).click();
        listElement.Nopcommerce_Register_First_Name(driver).clear();
        listElement.Nopcommerce_Register_First_Name(driver).sendKeys(customer.getCusName());
        listElement.Nopcommerce_Register_Last_Name(driver).clear();
        listElement.Nopcommerce_Register_Button(driver).sendKeys(customer.getCusLastName());

        Select dateOfBirthDay = new Select(listElement.Nopcommerce_Register_Date_Of_Birth_Day(driver));
        List<WebElement> Options = dateOfBirthDay.getOptions();
        Options.forEach(value -> System.out.print(value.getText() + " "));
        Assert.assertEquals(Options.size(), 32);
        dateOfBirthDay.selectByVisibleText("1");

        Select dateOfBirthMonth = new Select(listElement.Nopcommerce_Register_Date_Of_Birth_Month(driver));
        Options = dateOfBirthMonth.getOptions();
        Options.forEach(value -> System.out.print(value.getText() + " "));
        Assert.assertEquals(Options.size(), 13);
        dateOfBirthMonth.selectByVisibleText("July");

        Select dateOfBirthYear = new Select(listElement.Nopcommerce_Register_Date_Of_Birth_Year(driver));
        Options = dateOfBirthYear.getOptions();
        Options.forEach(value -> System.out.print(value.getText() + " "));
        Assert.assertEquals(Options.size(), 112);
        dateOfBirthYear.selectByValue("2000");

        listElement.Nopcommerce_Register_Email(driver).clear();
        listElement.Nopcommerce_Register_Email(driver).sendKeys(customer.getCusEmail());

        listElement.Nopcommerce_Register_Password(driver).clear();
        listElement.Nopcommerce_Register_Password(driver).sendKeys(customer.getCusPassword());

        listElement.Nopcommerce_Register_Confirm_Password(driver).clear();
        listElement.Nopcommerce_Register_Confirm_Password(driver).sendKeys(customer.getCusPassword());

        listElement.Nopcommerce_Register_Button(driver).click();
        Assert.assertEquals(listElement.Nopcommerce_Register_Result(driver).getText(), "Your registration completed");
        Assert.assertTrue(listElement.Nopcommerce_Register_MyAccount(driver).isDisplayed());
        Assert.assertTrue(listElement.Nopcommerce_Register_Logout(driver).isDisplayed());

        listElement.Nopcommerce_Register_MyAccount(driver).click();
        Select cusInfoDateOfBirthDay = new Select(listElement.Nopcommerce_Register_Date_Of_Birth_Day(driver));
        Assert.assertEquals(cusInfoDateOfBirthDay.getFirstSelectedOption().getText(), "1");
        Select cusInfoDateOfBirthMonth = new Select(listElement.Nopcommerce_Register_Date_Of_Birth_Month(driver));
        Assert.assertEquals(cusInfoDateOfBirthMonth.getFirstSelectedOption().getText(), "July");
        Select cusInfoDateOfBirthYear = new Select(listElement.Nopcommerce_Register_Date_Of_Birth_Year(driver));
        Assert.assertEquals(cusInfoDateOfBirthYear.getFirstSelectedOption().getText(), "2000");

    }

    @Test
    public void TC02_Handle_Dropdown_List_Custom() {
        //Open "https://demoqa.com/select-menu"
        driver.get("https://demoqa.com/select-menu");

        Select_Item_In_Dropdown("//div[@id='withOptGroup']", "//div[starts-with(@id,'react-select-2-option')]", "A root option");
        Select_Item_In_Dropdown("//div[@id='selectOne']", "//div[starts-with(@id,'react-select-3-option')]", "Other");

    }

    @Test
    public void TC03_Handle_Alert_Click_Accept() {
        driver.get("https://demoqa.com/alerts");
        ListElementToolQA listElement = new ListElementToolQA();
        //check khi click
        listElement.Alert_Click_Me_Button(driver).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Assert.assertEquals(listElement.Alert_Confirm_Result(driver).getText(), "You selected Ok");
    }

    @Test
    public void TC03_Handle_Alert_Click_Cancel() {
        driver.get("https://demoqa.com/alerts");
        ListElementToolQA listElement = new ListElementToolQA();
        //check khi click
        listElement.Alert_Click_Me_Button(driver).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        Assert.assertEquals(listElement.Alert_Confirm_Result(driver).getText(), "You selected Cancel");
    }

    @Test
    public void TC04_Add_Info_To_Form() {
        driver.get("https://demoqa.com/automation-practice-form");
        ListElementToolQA listElement = new ListElementToolQA();
        Customer customer = new Customer();
        customer = customer.Random_Info_Customer();
        //Fill all data
        //FirstName
        listElement.Automation_Practice_Form_First_Name(driver).clear();
        listElement.Automation_Practice_Form_First_Name(driver).sendKeys(customer.getCusName());
        //LastName
        listElement.Automation_Practice_Form_Last_Name(driver).clear();
        listElement.Automation_Practice_Form_Last_Name(driver).sendKeys(customer.getCusLastName());
        //email
        listElement.Automation_Practice_Form_User_Name(driver).clear();
        listElement.Automation_Practice_Form_User_Name(driver).sendKeys(customer.getCusEmail());
        //Gender
        if (customer.getGender() == "1") {
            Select_Radio_Checkbox(listElement.Automation_Practice_Form_Gender_Female_Lable(driver));
            customer.setGender("Female");
        } else {
            Select_Radio_Checkbox(listElement.Automation_Practice_Form_Gender_Male_Lable(driver));
            customer.setGender("Male");
        }
        //Mobile
        listElement.Automation_Practice_Form_User_Number(driver).clear();
        listElement.Automation_Practice_Form_User_Number(driver).sendKeys(customer.getMobileNumber());
        //DateOfBirth
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].removeAttribute('type');", listElement.Automation_Practice_Form_Date_Of_Birth(driver));
        listElement.Automation_Practice_Form_Date_Of_Birth(driver).click();
        js.executeScript("arguments[0].value='0'", listElement.Automation_Practice_Form_Date_Of_Birth(driver));
        listElement.Automation_Practice_Form_Date_Of_Birth(driver).sendKeys(customer.getDateOfBirthFormat("dd MMM yyyy"));
        Sleep_In_Second(1);
        listElement.Automation_Practice_Form_Date_Of_Birth(driver).sendKeys(Keys.ENTER);
        System.out.println("dateOfBirthInput= " + listElement.Automation_Practice_Form_Date_Of_Birth(driver).getAttribute("value"));
        //Subject
        Select_Item_Search_In_Dropdown(listElement.Automation_Practice_Form_Subject(), listElement.Automation_Practice_Form_ChildSubject(), "English");
        Select_Item_Search_In_Dropdown(listElement.Automation_Practice_Form_Subject(), listElement.Automation_Practice_Form_ChildSubject(), "Maths");
        customer.setSubject(Select_Item_Search_In_Dropdown_Get_Value(listElement.Automation_Practice_Form_Subject_Value()));

        //Hobbies
        Select_Radio_Checkbox(listElement.Automation_Practice_Form_Hobbies_Music(driver));
        Select_Radio_Checkbox(listElement.Automation_Practice_Form_Hobbies_Reading(driver));
        Select_Radio_Checkbox(listElement.Automation_Practice_Form_Hobbies_Sports(driver));
        customer.setHobbies("Music, Reading, Sports");
        //Updload file
        listElement.Automation_Practice_Form_Picture(driver).sendKeys("C:\\Users\\Admin\\Pictures\\upload.jpg");
        customer.setPicture("upload.jpg");

        //Current address
        listElement.Automation_Practice_Form_Current_Address(driver).clear();
        listElement.Automation_Practice_Form_Current_Address(driver).sendKeys(customer.getAddress() + "," + customer.getCity());

        //State
        Select_Item_Search_In_Dropdown(listElement.Automation_Practice_Form_State(), listElement.Automation_Practice_Form_State_Child(), "NCR");
        customer.setState("NCR");
        Select_Item_Search_In_Dropdown(listElement.Automation_Practice_Form_City(), listElement.Automation_Practice_Form_City_Child(), "Gurgaon");
        customer.setCity("Gurgaon");

        //submit
        listElement.Automation_Practice_Form_Submit(driver).click();
        //verify info
        Assert.assertEquals(listElement.Automation_Practice_Form_Rep_Mobile(driver).getText(), customer.getMobileNumber());
        Assert.assertEquals(listElement.Automation_Practice_Form_Rep_Student_Email(driver).getText(), customer.getCusEmail());
        Assert.assertEquals(listElement.Automation_Practice_Form_Rep_Student_Name(driver).getText(), customer.getCusName() + " " + customer.getCusLastName());
        Assert.assertEquals(listElement.Automation_Practice_Form_Rep_Date_Of_Birth(driver).getText(), customer.getDateOfBirthFormat("dd MMMM,yyyy"));
        Assert.assertEquals(listElement.Automation_Practice_Form_Rep_Subjects(driver).getText(), customer.getSubject());
        Assert.assertEquals(listElement.Automation_Practice_Form_Rep_Hobbies(driver).getText(), customer.getHobbies());
        Assert.assertEquals(listElement.Automation_Practice_Form_Rep_Picture(driver).getText(), customer.getPicture());
        Assert.assertEquals(listElement.Automation_Practice_Form_Rep_State_City(driver).getText(), customer.getState() + " " + customer.getCity());
    }

    @Test
    public void TC05_Handle_Iframe() {
        driver.get("https://kyna.vn/");
        ListElementToolQA listElement = new ListElementToolQA();
        driver.switchTo().frame(listElement.Handle_Iframe_Iframe_Fb(driver));
        Scroll_Down_To_Element(driver, listElement.Handle_Iframe_Facebook_Likes(driver));
        Assert.assertEquals(listElement.Handle_Iframe_Facebook_Likes(driver).getText(), "165K likes");
    }

    @Test
    public void TC06_Handle_WindowTab() {
        driver.get("https://dictionary.cambridge.org/vi/");
        ListElementToolQA listElement = new ListElementToolQA();
        listElement.Handle_Windown_Tab_Login_Dictionary_Button(driver).click();
        String mainWindowHandle = driver.getWindowHandle();
        Switch_To_Tab_Opened(driver, mainWindowHandle);
        System.out.println("mainWindowHandle = " + mainWindowHandle);
        System.out.println("driver.getTitle() = " + driver.getTitle());
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(listElement.Handle_Windown_Tab_Login_Button())));
        listElement.Handle_Windown_Tab_Login_Button(driver).click();
        Assert.assertEquals(listElement.Handle_Windown_Tab_Email_Error_Message(driver).getText(), "This field is required");
        Assert.assertEquals(listElement.Handle_Windown_Tab_Password_Error_Message(driver).getText(), "This field is required");
    }

    @AfterMethod
    public void Tear_Down() {
        driver.quit();
    }

    public void Switch_To_Tab_Opened(WebDriver driver, String mainWindowHandle) {
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String actual : allWindowHandles) {
            if (!actual.equalsIgnoreCase(mainWindowHandle)) {
                //Switch to the opened tab
                System.out.println("actual = " + actual);
                driver.switchTo().window(actual);
            }
        }
    }

    public void Scroll_Up_To_Element(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void Scroll_Down_To_Element(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", element);
    }

    public String Select_Item_Search_In_Dropdown_Get_Value(String xpathValue) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //Chờ cho đến khi các item được load thành công
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpathValue)));
        List<WebElement> allValues = driver.findElements(By.xpath(xpathValue));
        String values = "";
        for (WebElement childElement : allValues) {
            values = values + childElement.getText() + ", ";
        }

        return values.substring(0, values.length() - 2);
    }

    public void Select_Item_Search_In_Dropdown(String prarentXpath, String childXpath, String expectValueItem) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //Mở dropdownlist
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(prarentXpath)));
        driver.findElement(By.xpath(prarentXpath)).sendKeys(expectValueItem);
        //Chờ cho đến khi các item được load thành công
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childXpath)));
        List<WebElement> allitems = driver.findElements(By.xpath(childXpath));
        for (WebElement childElement : allitems) {
            System.out.println(childElement.getText());
        }
        //Duyệt qua hết tất cả các phần tử cho đến khi thỏa mãn điều kiện
        for (WebElement childElement : allitems) {
            if (childElement.getText().equals(expectValueItem)) {
                //scroll đến item cần chọn (nếu như item cần chọn có thể nhìn thấy k cần scroll)
                JavascriptExecutor jstExecutor = (JavascriptExecutor) driver;
                jstExecutor.executeScript("arguments[0].scrollIntoView(true);", childElement);
                Sleep_In_Second(1);

                explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(childXpath)));
                childElement.click();
                Sleep_In_Second(1);
                break;
            }
        }

    }

    public void Select_Item_In_Dropdown(String prarentXpath, String childXpath, String expectValueItem) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //Mở dropdownlist
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(prarentXpath)));
        driver.findElement(By.xpath(prarentXpath)).click();
        //Chờ cho đến khi các item được load thành công
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childXpath)));
        List<WebElement> allitems = driver.findElements(By.xpath(childXpath));
        for (WebElement childElement : allitems) {
            System.out.println(childElement.getText());
        }
        //Duyệt qua hết tất cả các phần tử cho đến khi thỏa mãn điều kiện
        for (WebElement childElement : allitems) {
            if (childElement.getText().equals(expectValueItem)) {
                //scroll đến item cần chọn (nếu như item cần chọn có thể nhìn thấy k cần scroll)
                JavascriptExecutor jstExecutor = (JavascriptExecutor) driver;
                jstExecutor.executeScript("arguments[0].scrollIntoView(true);", childElement);
                Sleep_In_Second(1);

                explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(childXpath)));
                childElement.click();
                Sleep_In_Second(1);
                break;
            }
        }

    }

    public void Select_Radio_Checkbox(WebElement element) {
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void Deselect_Radio_Checkbox(WebElement element) {
        if (element.isSelected()) {
            element.click();
        }
    }

    private void Sleep_In_Second(long time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
