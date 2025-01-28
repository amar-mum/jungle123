package stepdefinitions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;

import io.cucumber.messages.types.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.InputStream;


public class BaseTest {
    protected WebDriver driver;
    
    protected Properties config;

    public BaseTest() {
        setUp();
    }

    @BeforeMethod
	public void setUp() {
		/*
		 * try { config = new Properties(); InputStream input =
		 * getClass().getClassLoader().getResourceAsStream("config.properties");
		 * config.load(input);
		 */

           // String browser = config.getProperty("chrome");
            //if ("chrome".equalsIgnoreCase(browser)) {
               // WebDriverManager.chromedriver().setup();
                //driver = new ChromeDriver();
                //WebDriverManager.edgedriver().setup();  // This will manage EdgeDriver
               // driver = new EdgeDriver();
                WebDriverManager.firefoxdriver().setup();  // This will manage GeckoDriver
                driver = new FirefoxDriver();
              //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
            
            // Add more browsers here if needed

			/*
			 * } catch (Exception e) { e.printStackTrace(); }
			 */
    }

    @AfterMethod
	public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
