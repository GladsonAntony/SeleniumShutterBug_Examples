package examples;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Test1_DefaultLocation
{
    public static WebDriver webDriver;

    @Test
    public void test_DefaultScreenshotLocation() throws Exception
    {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get("https://www.google.co.in/");
        webDriver.manage().window().maximize();
        Shutterbug
                .shootPage(webDriver)
                .save();
    }

    @AfterTest(alwaysRun = true)
    public void quitDriver() throws Exception
    {
        webDriver.quit();
    }
}
