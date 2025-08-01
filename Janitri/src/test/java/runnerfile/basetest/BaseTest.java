package runnerfile.basetest;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    private WebDriver driver;
    private LoginPage loginPage;

    String testUserName = "secureuser@gmail.com";
    String testPassword = "securepassword123";

    @BeforeMethod
    public void setUp(){
        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 1); // 1 = allow, 2 = block
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);

        driver.get("https://dev-dash.janitri.in/");
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

    }

    @Test(description = "Verify Login button is disabled when user ID and password fields are empty")
    public void testLoginButtonDisabledWhenFieldAreEmpty(){
        loginPage.enterUserId("");
        loginPage.enterPassword("");
        Assert.assertFalse(loginPage.isLoginButtonEnabled());
    }

    @Test(description = "Verify password masking and unmasking functionality")
    public void testPasswordMaskedbutton(){

        loginPage.enterPassword(testPassword);

        // Initially, password should be masked
        Assert.assertTrue(loginPage.isPasswordMasked(), "Password should be masked by default.");

        // Click the eye icon to unmask
        loginPage.clickPasswordVisibilityToggle();
        Assert.assertTrue(loginPage.isPasswordUnmasked(), "Password should be unmasked after clicking the eye icon.");

        // Click the eye icon again to mask
        loginPage.clickPasswordVisibilityToggle();
        Assert.assertTrue(loginPage.isPasswordMasked(), "Password should be masked again after clicking the eye icon a second time.");

    }

    @Test(description = "Verify error message for invalid login credentials")
    public void testInvalidLoginShowErrorMsg() throws InterruptedException {
//        Thread.sleep(10000);
        loginPage.enterUserId(testUserName);
        loginPage.enterPassword(testPassword);
        loginPage.submitButton();


        // Wait for and verify the error message
        String actualError = "Invalid Credentials";
        String expectedError = loginPage.getErrorMessageText();
        Assert.assertTrue(actualError.contains(expectedError),
                "Error message for invalid credentials should be displayed. Actual: " + actualError);

    }

    @Test(description = "Validate presence of key login page elements")
    public void ValidatePresenceOfPageElements(){
        String actualTitle = "Janitri";
        String expectedTitle = loginPage.getPageTitleText();

        // Verify the page title
        Assert.assertEquals(actualTitle, expectedTitle,"Page title is :"+actualTitle);

        // Validate presence of User ID input field
        Assert.assertTrue(loginPage.isUserIdInputDisplayed(), "User ID input field should be displayed.");

        // Validate presence of Password input field
        Assert.assertTrue(loginPage.isPasswordInputDisplayed(), "Password input field should be displayed.");

        // Validate presence of Login button
        Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "Login button should be displayed.");

        // Validate presence of Password Visibility Toggle (eye icon)
        Assert.assertTrue(loginPage.isPasswordVisibilityToggleDisplayed(), "Password visibility toggle should be displayed.");

    }

    @AfterMethod
    public void closeTheBrowser() throws InterruptedException {
        Thread.sleep(5000);
        if (driver!=null){
            driver.quit();
        }
    }

}
