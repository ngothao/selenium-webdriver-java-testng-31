package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_11_DropDown_Default
{
    WebDriver driver ;
    String firstName = "Test",lastName = "Ngo" ,emailAddress = getEmailAddress(),company="IVS", password="ThaoEsoft1";
    String day="15", month="October", year="1987";

    @BeforeClass
    public void beforeClass()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Test
    public void TC_01_Register_Account()
    {
        driver.get("https://demo.nopcommerce.com/");
        sleepInSecond(2);

        driver.findElement(By.xpath("//a[@class='ico-register']")).click();

        driver.findElement(By.xpath("//span[@class='male']/input[@id='gender-male']")).click();
        sleepInSecond(2);

        new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"))).selectByVisibleText(day);
        new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"))).selectByVisibleText(month);
        new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"))).selectByVisibleText(year);
        sleepInSecond(2);

        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(lastName);
        sleepInSecond(2);

        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailAddress);
        sleepInSecond(2);

        driver.findElement(By.xpath("//input[@id='Company']")).sendKeys(company);
        sleepInSecond(2);

        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys(password);
        sleepInSecond(5);
       driver.findElement(By.xpath("//button[@id='register-button']")).click();
        sleepInSecond(5);
        Assert.assertEquals(driver.findElement(By.xpath(" //div[text()='Your registration completed']")),"Your registration completed");
        driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
    }
    @Test
    public void TC_02_Verify_Information()
    {
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();
        driver.findElement(By.xpath("//input[@class='email']")).sendKeys(emailAddress);
        driver.findElement(By.xpath("//input[@class='password']")).sendKeys(password);
        driver.findElement(By.xpath(" //button[text()='Log in']")).click();
        sleepInSecond(5);

    }

    @AfterClass
    public void afterClass()
    {
        driver.quit();
    }
    public void sleepInSecond(long timeInSecond)
    {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String getEmailAddress()
    {
        Random rand= new Random();
        return "thao"+rand.nextInt(99999)+"@gmail.com";
    }
}

