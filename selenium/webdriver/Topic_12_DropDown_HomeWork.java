package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Topic_12_DropDown_HomeWork
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
    public void TC_01_Select_Verify()
    {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
        sleepInSecond(2);

        driver.findElement(By.xpath("//span[@id=\"number-button\"]")).click();
        sleepInSecond(2);
        //cho cho all Items trong dropdown dc displayed
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id=\"number-menu\"]//div")));

        //Luu 19 item trong mang
        List<WebElement> allItems= driver.findElements(By.xpath("//ul[@id=\"number-menu\"]//div"));

        for(WebElement item:allItems)
        {
            String textItem=item.getText();
            if(item.equals("8")){
                item.click();
                sleepInSecond(3);
                break;
            }
        }
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

