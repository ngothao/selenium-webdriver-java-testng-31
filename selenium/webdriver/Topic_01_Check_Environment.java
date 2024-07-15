package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_01_Check_Environment {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }

    @Test
    public void TC_01_Empty_Data()
    {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

      driver.findElement(By.id("txtFirstname")).clear();
      driver.findElement(By.id("txtEmail")).clear();
      driver.findElement(By.id("txtCEmail")).clear();
      driver.findElement(By.id("txtPassword")).clear();
      driver.findElement(By.id("txtCPassword")).clear();
      driver.findElement(By.id("txtPhone")).clear();

      driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();

      Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(),"Vui lòng nhập họ tên");
      Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email");
      Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Vui lòng nhập lại địa chỉ email");
      Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Vui lòng nhập mật khẩu");
      Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Vui lòng nhập lại mật khẩu");
      Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Vui lòng nhập số điện thoại.");
    }
    @Test
    public void TC_02_Invalid_Email()
    {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtFirstname")).sendKeys("Ngo thi Thao");
        driver.findElement(By.id("txtEmail")).sendKeys("thao@@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("thao@@@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("123@abc");
        driver.findElement(By.id("txtCPassword")).sendKeys("123@abc");
        driver.findElement(By.id("txtPhone")).sendKeys("0977109156");

        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Email nhập lại không đúng");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}