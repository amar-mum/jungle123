
package pageobjects;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.AssertJUnit;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
//import static org.testng.AssertJUnit.assertTrue;
import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertEquals;

import io.cucumber.messages.types.Duration;

public class LoginPage {
    private static final String landingpagetxt1 = null;
	private WebDriver driver;
    WebDriverWait wait;
    @FindBy(id = "txtEmailId")
    private WebElement usernameField;

    @FindBy(id = "txtPasswordId")
    private WebElement passwordField;

    @FindBy(id = "btnLoginId")
    private WebElement loginButton;
    
    @FindBy(xpath= "//h2[@class='text' and normalize-space()='Landing Page']")
    private WebElement landingpagetxt;
    
        

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
    	System.out.println("wait bhai");
    	//wait.until(ExpectedConditions.elementToBeClickable(loginButton)); // Wait until clickable
    	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loginButton)));
    	
    	// Scroll to the button if not visible
    	
    	
    	 //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // WebElement btnLogin = wait.until(ExpectedConditions.elementToBeClickable(loginButton));

    	
    	try {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loginButton);

        // Click the button
       loginButton.click();
    } catch (ElementNotInteractableException e) {
        System.out.println("Button is not interactable. Trying JavaScript click.");
       // WebElement btnLogin = driver.findElement(By.id("btnLogin"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginButton);
    }
    

    	
    	
    	
    	
    	
    	 System.out.println("Done bhai?");
        //loginButton.click();
        System.out.println("ha bhai");
       
    }
    
    public void verifyLogin() {
    
    	 String landingPageText1= landingpagetxt.getText();
    	 System.out.println(landingPageText1);
    	 
    	//Assert.assertTrue(landingpagetxt1, "Landing Page text is not visible on the page.");
    	// Assert.assertEquals(landingpagetxt1, "LANDING PAGE");
    	 //AssertJUnit.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()); 
    }
}
