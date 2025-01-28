

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Properties;
import java.io.InputStream;

public class BaseTest {
    protected WebDriver driver;
    protected Properties config;

    public BaseTest() {
        setUp();
    }

    public void setUp() {
        try {
            config = new Properties();
            InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
            config.load(input);

            String browser = config.getProperty("browser");
            if ("chrome".equalsIgnoreCase(browser)) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            // Add more browsers here if needed

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
