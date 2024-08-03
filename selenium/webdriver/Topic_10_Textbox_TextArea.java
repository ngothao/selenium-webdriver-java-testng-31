package webdriver;

import graphql.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_10_Textbox_TextArea
{
    WebDriver driver ;
    @BeforeClass
    public void beforeClass()
    {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void TC_01_Register_Account()
    {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
        sleepInSecond(2);


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

