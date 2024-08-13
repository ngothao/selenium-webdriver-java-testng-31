package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_13_Button_Radio
{
    WebDriver driver ;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass()
    {
        driver = new FirefoxDriver();
        explicitWait= new WebDriverWait(driver,Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void TC_01_Button_Disable()
    {
        driver.get("https://www.fahasa.com/customer/account/login");
        WebElement registerButton = driver.findElement(By.cssSelector("button[class='fhs-btn-login'"));
        Assert.assertFalse(registerButton.isEnabled());
        String colorButton=registerButton.getCssValue("background-color");
        System.out.println("Ma mau "+ colorButton);

        Color registerButton1= Color.fromString(colorButton);
        String colorHexa= registerButton1.asHex();
        Assert.assertEquals(colorHexa,"#000000");

    }
    @Test
    public void TC_02_Button_Enable()
    {
        driver.get("https://www.fahasa.com/customer/account/login");
        WebElement registerButton = driver.findElement(By.cssSelector("button[class='fhs-btn-login'"));
        WebElement ten=driver.findElement(By.cssSelector("input[id='login_username']"));
        WebElement password= driver.findElement(By.cssSelector("input[id='login_password']"));

        Assert.assertFalse(registerButton.isEnabled());
        ten.sendKeys("0977109156");
        password.sendKeys("123456");

        String colorButton=registerButton.getCssValue("background-color");
        System.out.println("Ma mau "+ colorButton);

        Color registerButton1= Color.fromString(colorButton);
        String colorHexa= registerButton1.asHex();
        String colorUppercase= colorHexa.toUpperCase();
        Assert.assertEquals(colorUppercase,"#C92127");

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

