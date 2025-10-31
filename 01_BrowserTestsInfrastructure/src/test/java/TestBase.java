import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\skillbox\\driver\\chromedriver.exe");
        var options = new ChromeOptions();
        options.addArguments("--start-maximixed");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }
}
