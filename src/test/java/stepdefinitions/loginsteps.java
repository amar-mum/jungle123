package stepdefinitions;


import static org.testng.AssertJUnit.assertTrue;
import io.cucumber.java.en.*;

import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.WebDriver;
import pageobjects.LoginPage;


public class loginsteps extends BaseTest {
    private LoginPage loginPage;

    @Given("the user is on the login page")
    public void navigateToLoginPage() {
        //driver.get(config.getProperty("app.url"));
    	driver.get("https://acsint.kalelogistics.com/login");
    	
        loginPage = new LoginPage(driver);
    }

    @When("the user enters username and password from excel")
    public void enterCredentials() {
        String[][] credentials = ExcelUtil.readExcelData("D:/credentials.xlsx", "Sheet1");
        String username = credentials[1][0]; // Assuming first row is header
        String password = credentials[1][1];
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("clicks the login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("the user should be logged in successfully")
    public void verifyLogin() {
    	
		loginPage.verifyLogin();
    }
}

