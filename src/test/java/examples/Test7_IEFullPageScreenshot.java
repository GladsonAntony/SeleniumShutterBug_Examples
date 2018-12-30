package examples;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Test7_IEFullPageScreenshot
{
    public static WebDriver webDriver;

    @Test
    public void test_InternetExplorerFullPageScreenshot() throws Exception
    {
        WebDriverManager.iedriver().setup();
        webDriver = new InternetExplorerDriver();
        webDriver.get("https://www.amazon.in/");
        webDriver.manage().window().maximize();
        Shutterbug
                .shootPage(webDriver, ScrollStrategy.BOTH_DIRECTIONS,500,true)
                .withName("Test7_IEFullPageScreenshot")
                .save();
    }

    @AfterTest(alwaysRun = true)
    public void quitDriver() throws Exception
    {
        webDriver.quit();
    }
}
