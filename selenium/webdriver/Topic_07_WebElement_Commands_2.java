package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_07_WebElement_Commands_2
{
    WebDriver driver = new ChromeDriver();
    @BeforeClass
    public void beforeClass()
    {
      //driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void TC_01_Check_Shown()
    {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        if (driver.findElement(By.xpath("//input[@id=\"mail\"]")).isDisplayed())
        {
            driver.findElement(By.xpath("//input[@id=\"mail\"]")).sendKeys("Ke me tao");
            sleepInSecond(4);
        }else
        {
            System.out.println("Khong tim thay");
        }
        if (driver.findElement(By.xpath("//label[@for=\"under_18\"]")).isDisplayed())
        {
            driver.findElement(By.xpath("//label[@for=\"under_18\"]")).click();
            sleepInSecond(5);
        }else
        {
            System.out.println("Khong tim thay U18");
        }
        if(driver.findElement(By.xpath("//h5[text()=\"Name: User5\"]")).isDisplayed())
        {
            System.out.println("No khong an");
        }else
        {
            System.out.println("Phan tu nay bi an");
        }
    }
    @Test
    public void TC_02_Enable_OrDisable()
    {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        if(driver.findElement(By.xpath("//input[@id=\"mail\"]")).isEnabled())
        {
            System.out.println("Email is enable");
        }else
        {
            System.out.println("Email is not enabled");
        }
        if(driver.findElement(By.xpath("//label[@for=\"under_18\"]")).isEnabled())
        {
            System.out.println("Under age 18 is enable");
        }else
        {
            System.out.println("Under age 18 is disable");
        }
        if(driver.findElement(By.xpath("//textarea[@id='edu']")).isEnabled())
        {
            System.out.println("Edu field is enable");
        }else
        {
            System.out.println("Edu field is disable");
        }
        if(driver.findElement(By.xpath("//select[@id='job1']")).isEnabled())
        {
            System.out.println("Job 1 is enable");
        }else
        {
            System.out.println("Job 1 is disable");
        }
        if(driver.findElement(By.xpath("//select[@id='job1']")).isEnabled())
        {
            System.out.println("Job 1 is enable");
        }else
        {
            System.out.println("Job 1 is disable");
        }
        if(driver.findElement(By.xpath("//select[@id='job2']")).isEnabled())
        {
            System.out.println("Job 2 is enable");
        }else
        {
            System.out.println("Job 2 is disable");
        }
        if(driver.findElement(By.xpath("//input[@type='checkbox' and @id='development']")).isEnabled())
        {
            System.out.println("Development checkbox is enable");
        }else
        {
            System.out.println("Development checkbox is disable");
        }
        if(driver.findElement(By.xpath("//input[@name='slider-1']")).isEnabled())
        {
            System.out.println("Development checkbox is enable");
        }else
        {
            System.out.println("Development checkbox is disable");
        }

        if(driver.findElement(By.xpath("//input[@type='password']")).isEnabled())
        {
            System.out.println("PW is enable");
        }else
        {
            System.out.println("PW is disable");
        }
        if(driver.findElement(By.xpath("//input[@id='radio-disabled']")).isEnabled())
        {
            System.out.println("Age is enable");
        }else
        {
            System.out.println("Age is disable");
        }
        if(driver.findElement(By.xpath("//textarea[@id='bio']")).isEnabled())
        {
            System.out.println("Biography is enable");
        }else
        {
            System.out.println("Biography is disable");
        }
        if(driver.findElement(By.xpath("//select[@id='job2']")).isEnabled())
        {
            System.out.println("Job 2 is enable");
        }else
        {
            System.out.println("Job 2 is disable");
        }
        if(driver.findElement(By.xpath("//label[text()=\"Checkbox is disabled\"]")).isEnabled())
        {
            System.out.println("Interest checkbox is enable");
        }else
        {
            System.out.println("Interest checkbox is disable");
        }
        if(driver.findElement(By.xpath("//input[@id='slider-2']")).isEnabled())
        {
            System.out.println("Slider 2 is enable");
        }else
        {
            System.out.println("Slider 2 is disable");
        }
    }
    @Test
    public void TC_03_Selected_Or_Not()
    {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//label[@for=\"under_18\"]")).click();
        driver.findElement(By.xpath("//label[@for='java']")).click();
        sleepInSecond(5);
        if(driver.findElement(By.xpath("//label[@for=\"under_18\"]")).isSelected())
        {
            System.out.println("Age under 18 is selected");
        }else
        {
            System.out.println("Age under 18 is selected");
        }
        if(driver.findElement(By.xpath("//label[@for='java']")).isSelected())
        {
            System.out.println("Java is selected");
        }else
        {
            System.out.println("Java is not selected");
        }
        sleepInSecond(5);
        driver.findElement(By.xpath("//label[@for='java']")).click();
        if(driver.findElement(By.xpath("//label[@for='java']")).isSelected())
        {
            System.out.println("Java is selected");
        }else
        {
            System.out.println("Java is not selected");
        }
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

