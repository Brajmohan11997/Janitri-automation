package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By userId = By.id("formEmail");
    private By Password = By.id("formPassword");
    private By PasswordVisibilityIcon = By.className("passowrd-visible");
    private By LoginButton = By.className("login-button");
    private By ErrorMessage = By.className("normal-text");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver , Duration.ofSeconds(10));
    }

    public void enterUserId(String UserID){
        WebElement userIdelement = wait.until(ExpectedConditions.visibilityOfElementLocated(userId));
        userIdelement.clear();
        userIdelement.sendKeys(UserID);
    }
    public void enterPassword(String password){
        WebElement passwordelement = wait.until(ExpectedConditions.visibilityOfElementLocated(Password));
        passwordelement.clear();
        passwordelement.sendKeys(password);
    }
    public void submitButton(){
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(LoginButton));
        submit.click();
    }

    public void clickPasswordVisibilityToggle(){
        driver.findElement(PasswordVisibilityIcon).click();
    }
    public boolean isLoginButtonEnabled() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(LoginButton)).isEnabled();
    }


    // Get the text of the error message
    public String getErrorMessageText(){
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessage));
        return errorMessage.getText();
    }

    //Checks if the password input field is masked (type="password")
    public boolean isPasswordMasked() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(Password)).getAttribute("type").equals("password");
    }

    //Checks if the password input field is unmasked (type="text")
    public boolean isPasswordUnmasked() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(Password)).getAttribute("type").equals("text");
    }

   // Checks if the User ID input field is displayed.
    public boolean isUserIdInputDisplayed() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(userId)).isDisplayed();

    }

    // Checks if the Password input field is displayed.
    public boolean isPasswordInputDisplayed() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(Password)).isDisplayed();
    }

    // Checks if the Login button is displayed.
    public boolean isLoginButtonDisplayed() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(LoginButton)).isDisplayed();
    }

    // Checks if the Password Visibility Toggle (eye icon) is displayed.
    public boolean isPasswordVisibilityToggleDisplayed() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(PasswordVisibilityIcon)).isDisplayed();
    }

    // Get the page title text.
    public String getPageTitleText() {
        String pageTitle = driver.getTitle();
        return pageTitle;
    }

}
