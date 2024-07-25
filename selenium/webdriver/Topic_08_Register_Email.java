package webdriver;

import graphql.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_08_Register_Email
{
    WebDriver driver ;
    @BeforeClass
    public void beforeClass()
    {
      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void TC_01_Register_Mail_Chimp()
    {
        driver.get("https://login.mailchimp.com/signup/");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("guavatester2405@gmail.com");
        sleepInSecond(3);

        driver.findElement(By.xpath("//input[@id='new_password']")).sendKeys("12345");
        sleepInSecond(3);
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='One lowercase character']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='One uppercase character']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='One number']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='8 characters minimum']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Must not contain username']")).isDisplayed());
        sleepInSecond(3);
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

