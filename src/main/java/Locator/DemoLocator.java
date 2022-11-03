package Locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class DemoLocator extends Customer {
    WebDriver driver;

    public DemoLocator() {
        super();
    }

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void Tc01_Register_With_Empty_Data() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");

    }

    @Test
    public void Tc02_Register_With_Invalid_Email() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtFirstname"))).sendKeys("Mỹ Linh");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtEmail"))).sendKeys("linhntm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtCEmail"))).sendKeys("linhntm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtPassword"))).sendKeys("123456");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtCPassword"))).sendKeys("123456");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtPhone"))).sendKeys("0121345678");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();

        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");


    }

    @Test
    public void Tc03_Register_With_Incorrect_Confirm_Email() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtFirstname"))).sendKeys("Mỹ Linh");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtEmail"))).sendKeys("linh@gmail.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtCEmail"))).sendKeys("linhntm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtPassword"))).sendKeys("123456");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtCPassword"))).sendKeys("123456");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtPhone"))).sendKeys("0121345678");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();

        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");


    }

    @Test
    public void Tc04_Login_With_Empty_Email_Password() {
        driver.get("http://live.techpanda.org/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='footer']//a[@title='My Account']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit' and @title='Login']"))).click();


        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(), "This is a required field.");
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(), "This is a required field.");

    }

    @Test
    public void Tc05_Login_With_Incorrect_Email_Password() {
        driver.get("http://live.techpanda.org/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='footer']//a[@title='My Account']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='login[username]' ]"))).sendKeys("trainningautomation@hotmail.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password' ]"))).sendKeys("123123123");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit' and @title='Login']"))).click();


        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='error-msg' ]"))).getText(), "Invalid login or password.");

    }

    public static String Random_String(int length, String listCharacter) {
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int) (listCharacter.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(listCharacter
                    .charAt(index));
        }
        return sb.toString();
    }

//    public static Customer Random_Info_Customer() {
//        String listCharacter = "zxcvbnmlkjhgfdsaqwertyuiop";
//        String listNumber = "123456789";
//        String listGender = "01";
//        String cusName = Random_String(4, listCharacter) + " " + Random_String(4, listCharacter);
//        String gender = Random_String(1, listGender);
//        String address = "123 Cầu giấy";
//        String city = "HN";
//        String state = "single";
//        String pin = Random_String(6, listNumber);
//        String mobileNumber = "0" + Random_String(9, listNumber);
//        String cusemail = Random_String(9, listCharacter) + "@gmail.com";
//        String cuspassword = Random_String(3, listCharacter) + Random_String(3, listNumber);
//        System.out.println(cusName + "," + gender + "," + address + "," + city + "," + state + "," + pin + "," + mobileNumber + "," + cusemail + "," + cuspassword);
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        Integer yearMin = 1980;
//        Integer yearMax = 2010;
//        Integer monthMin = 1;
//        Integer monthMax = 12;
//        Integer dayMin = 1;
//        Integer dayMax = 12;
//        //random year
//        Integer year = (int) (Math.random() * (yearMax - yearMin + 1) + yearMin);
//        Integer month = (int) (Math.random() * (monthMax - monthMin + 1) + monthMin);
//        Integer day = (int) (Math.random() * (dayMax - dayMin + 1) + dayMin);
//        LocalDateTime myDateObj = LocalDateTime.of(year, month, day, 0, 0, 0);
//        String cusDateOfBirth = myDateObj.format(dtf);
//        Customer cus = new Customer(cusName, gender, address, city, state, pin, mobileNumber, cusemail, cuspassword, cusDateOfBirth);
//        return cus;
//    }

    public void handleClickByXpath(String xpath) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
    }

    public void handleClickById(String id) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(id))).click();
    }

    public void handleSenkeysByXpath(String xpath, String text) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).sendKeys(text);
    }

    public void handleSenkeysById(String id, String text) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).sendKeys(text);
    }

    public String handleGetTextByXpath(String xpath) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(1));
        String result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).getText();
        return result;
    }

    public String handleGetAttributeValueByXpath(String xpath) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(1));
        String result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).getAttribute("value");
        return result;
    }

    public String handleGetTextById(String id) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(1));
        String result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).getText();
        return result;
    }

    public void handleClearByXpath(String xpath) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).clear();
    }

    @Test
    public void Tc06_Manage_Customer_Demo_Guru99() {
        //random email
        String listCharacter = "adfghjklzxcvnmewrtyuiop0987654321";
        String email = Random_String(12, listCharacter) + "@gmail.com";

        driver.get("https://demo.guru99.com/v4/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        handleClickByXpath("//li[contains(text(),'Visit')]//a[text()='here']");
        handleSenkeysByXpath("//input[@name='emailid']", email);
        handleClickByXpath("//input[@type='submit']");
        String userId = handleGetTextByXpath("//td[contains(text(),'User ID')]//following-sibling::td");
        String password = handleGetTextByXpath("//td[contains(text(),'Password')]//following-sibling::td");
        System.out.println("userId: " + userId + ", password:" + password);
        driver.navigate().to("https://demo.guru99.com/v4/");
        handleSenkeysByXpath("//input[@name='uid']", userId);
        handleSenkeysByXpath("//input[@name='password']", password);
        handleClickByXpath("//input[@name='btnLogin']");
        //verify login success
        Assert.assertEquals(handleGetTextByXpath("//marquee[@class='heading3']"), "Welcome To Manager's Page of Guru99 Bank");

        //action create customer
        handleClickByXpath("//a[text()='New Customer']");

        Customer cus = new Customer();
        cus = Random_Info_Customer();
        handleSenkeysByXpath("//input[@name='name']", cus.getCusName());
        String cusGender = "";
        if (cus.getGender() == "0") {
            cusGender = "male";
            handleClickByXpath("//input[@name='rad1' and @value='m']");
        } else {
            cusGender = "female";
            handleClickByXpath("//input[@name='rad1' and @value='f']");
        }
        handleSenkeysByXpath("//textarea[@name='addr']", cus.getAddress());
        handleSenkeysByXpath("//input[@name='city']", cus.getCity());
        handleSenkeysByXpath("//input[@name='state']", cus.getState());
        handleSenkeysByXpath("//input[@name='pinno']", cus.getPin());
        handleSenkeysByXpath("//input[@name='telephoneno']", cus.getMobileNumber());
        handleSenkeysById("dob", cus.getDateOfBirth());
        WebElement dob = driver.findElement(By.id("dob"));
        String dateInput = dob.getText();
        while (dateInput.length() > 10) {
            dob.sendKeys(Keys.BACK_SPACE);
            dob.sendKeys(cus.getYearOfBirth());
        }
        handleSenkeysByXpath("//input[@name='emailid']", cus.getCusEmail());
        handleSenkeysByXpath("//input[@name='password']", cus.getCusPassword());
//        System.out.println("date text="+handleGetTextById("dob"));
        handleClickByXpath("//input[@name='sub']");
        //check customer creation results

        Assert.assertEquals(handleGetTextByXpath("//p[@class='heading3']"), "Customer Registered Successfully!!!");
        String cusId = handleGetTextByXpath("//td[text()='Customer ID']/following-sibling::td");
        Assert.assertEquals(handleGetTextByXpath("//td[text()='Gender']/following-sibling::td"), cusGender);
        String dateOfBirth = cus.getDateOfBirth().substring(6, 10) + "-" + cus.getDateOfBirth().substring(0, 2) + "-" + cus.getDateOfBirth().substring(3, 5);
        Assert.assertEquals(handleGetTextByXpath("//td[text()='Birthdate']/following-sibling::td"), dateOfBirth);
        Assert.assertEquals(handleGetTextByXpath("//td[text()='Address']/following-sibling::td"), cus.getAddress());
        Assert.assertEquals(handleGetTextByXpath("//td[text()='City']/following-sibling::td"), cus.getCity());
        Assert.assertEquals(handleGetTextByXpath("//td[text()='State']/following-sibling::td"), cus.getState());
        Assert.assertEquals(handleGetTextByXpath("//td[text()='Pin']/following-sibling::td"), cus.getPin());
        Assert.assertEquals(handleGetTextByXpath("//td[text()='Mobile No.']/following-sibling::td"), cus.getMobileNumber());
        Assert.assertEquals(handleGetTextByXpath("//td[text()='Email']/following-sibling::td"), cus.getCusEmail());
        System.out.println("cusID:" + cusId);
        //action Edit customer
        handleClickByXpath("//ul[@class='menusubnav']//a[contains(text(),'Edit Customer')]");
        handleSenkeysByXpath("//input[@name='cusid']", cusId);
        handleClickByXpath("//input[@name='AccSubmit']");
        cus.setAddress("01 Thường tín");
        handleClearByXpath("//textarea[@name='addr']");
        handleSenkeysByXpath("//textarea[@name='addr']", cus.getAddress());
        cus.setMobileNumber("0393983223");
        handleClearByXpath("//input[@name='telephoneno']");
        handleSenkeysByXpath("//input[@name='telephoneno']", cus.getMobileNumber());
        handleClickByXpath("//input[@name='sub']");

        //verify thông tin vừa sửa
//        System.out.println("text alert: "+driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        handleSenkeysByXpath("//input[@name='cusid']", cusId);
        handleClickByXpath("//input[@name='AccSubmit']");
        Assert.assertEquals(handleGetTextByXpath("//textarea[@name='addr']"), cus.getAddress());
        System.out.println("edit number:" + cus.getMobileNumber());
        Assert.assertEquals(handleGetAttributeValueByXpath("//input[@name='telephoneno']"), cus.getMobileNumber());

        //action delete customer
        handleClickByXpath("//ul[@class='menusubnav']//a[contains(text(),'Delete Customer')]");
        handleSenkeysByXpath("//input[@name='cusid']", cusId);
        handleClickByXpath("//input[@name='AccSubmit']");
        //accept to delete the customer
        driver.switchTo().alert().accept();
        //verify delete customer
        Assert.assertEquals(this.driver.switchTo().alert().getText(), "Customer does not Exist!!!");
//        driver.switchTo().alert().accept();


    }

    @AfterMethod
    public void tearDown() {

//        driver.quit();
    }

//    public static void main(String[] args) {
//        Integer yearMin=1980;
//        Integer yearMax=2010;
//        Integer monthMin=1;
//        Integer monthMax=12;
//        Integer dayMin=1;
//        Integer dayMax=28;
//        //random year
//        Integer year=(int)(Math.random()*(yearMax-yearMin+1)+yearMin);
//        Integer month=(int)(Math.random()*(monthMax-monthMin+1)+monthMin);
//        Integer day=(int)(Math.random()*(dayMax-dayMin+1)+dayMin);
//        LocalDateTime myDateObj = LocalDateTime.of(year,month,day,0,0,0);
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        String cusDateOfBirth=myDateObj.format(dtf);
//        System.out.println("cusDateOfBirth:"+cusDateOfBirth);
//        System.out.println("cusDateOfBirth:"+cusDateOfBirth.substring(6,10)+"-"+cusDateOfBirth.substring(3,5)+"-"+cusDateOfBirth.substring(0,2));
//    }
}
