package webdriver;

import graphql.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_09_Log_In
{
    WebDriver driver ;
    @BeforeClass
    public void beforeClass()
    {
      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void TC_01_Blank_Email_Pw()
    {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSecond(3);
        driver.findElement(By.xpath("//button[@title='Login']")).click();
        sleepInSecond(3);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).isDisplayed());
        sleepInSecond(3);
    }
    @Test
    public void TC_02_Blank_Email()
    {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSecond(3);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("123@223.123");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@title='Login']")).click();
        sleepInSecond(3);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='advice-validate-email-email']")).isDisplayed());
        sleepInSecond(3);
    }
    public void TC_03_Pw_Less_Than_6()
    {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSecond(3);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("thao@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("12345");
        driver.findElement(By.xpath("//button[@title='Login']")).click();
        sleepInSecond(3);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).isDisplayed());
        sleepInSecond(3);
    }
    public void TC_04_Invalid_Email_Pw()
    {
        /* Trang web đã thay đổi nên không chạy được case này
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSecond(3);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("thao@gmail.com.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("12345333333333");
        driver.findElement(By.xpath("//button[@title='Login']")).click();
        sleepInSecond(3);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).isDisplayed());
        sleepInSecond(3);

         */
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
}

