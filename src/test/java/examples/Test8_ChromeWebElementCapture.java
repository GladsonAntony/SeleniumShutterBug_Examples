package examples;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Test8_ChromeWebElementCapture
{
    public static WebDriver webDriver;

    @Test
    public void test_WebElementScreenshot() throws Exception
    {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get("https://www.amazon.in/");
        webDriver.manage().window().maximize();
        WebElement TestElement = webDriver.findElement(By.xpath("//div[@id='navbar']"));
        Shutterbug
                .shootElement(webDriver, TestElement)
                .withName("Amazon_Navbar")
                .save();
    }

    @AfterTest(alwaysRun = true)
    public void quitDriver() throws Exception
    {
        webDriver.quit();
    }
}
