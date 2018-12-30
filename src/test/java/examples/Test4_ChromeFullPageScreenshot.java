package examples;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Test4_ChromeFullPageScreenshot
{
    public static WebDriver webDriver;

    @Test
    public void test_ChromeFullPageScreenshot() throws Exception
    {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get("https://www.amazon.in/");
        webDriver.manage().window().maximize();
        Shutterbug
                .shootPage(webDriver, ScrollStrategy.WHOLE_PAGE_CHROME,true)
                .withName("Test4_ChromeFullPageScreenshot")
                .save();
    }

    @AfterTest(alwaysRun = true)
    public void quitDriver() throws Exception
    {
        webDriver.quit();
    }
}
