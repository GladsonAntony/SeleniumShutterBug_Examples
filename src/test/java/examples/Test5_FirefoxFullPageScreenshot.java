package examples;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Test5_FirefoxFullPageScreenshot
{
    public static WebDriver webDriver;

    @Test
    public void test_FirefoxFullPageScreenshot() throws Exception
    {
        WebDriverManager.firefoxdriver().setup();
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.amazon.in/");
        webDriver.manage().window().maximize();
        Shutterbug
                .shootPage(webDriver, ScrollStrategy.BOTH_DIRECTIONS,500,true)
                .withName("Test5_FirefoxFullPageScreenshot")
                .save();
    }

    @AfterTest(alwaysRun = true)
    public void quitDriver() throws Exception
    {
        webDriver.quit();
    }
}
