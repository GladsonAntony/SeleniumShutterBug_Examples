package examples;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Test6_EdgeFullPageScreenshot
{
    public static WebDriver webDriver;

    @Test
    public void test_EdgeFullPageScreenshot() throws Exception
    {
        WebDriverManager.edgedriver().setup();
        webDriver = new EdgeDriver();
        webDriver.get("https://www.amazon.in/");
        webDriver.manage().window().maximize();
        Shutterbug
                .shootPage(webDriver, ScrollStrategy.BOTH_DIRECTIONS,500,true)
                .withName("Test6_EdgeFullPageScreenshot")
                .save();
    }

    @AfterTest(alwaysRun = true)
    public void quitDriver() throws Exception
    {
        webDriver.quit();
    }
}
