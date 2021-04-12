package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[contains(@data-st-tagname-signin,'id-signIn-loginAttempt-click')]")
    private WebElement myAccountSignInCTA;

    @FindBy(xpath = "//span[@id='EmailAddress-error']")
    private WebElement myAccountEmptyEmailError;

    @FindBy(xpath = "//span[@id='Password-error']")
    private WebElement myAccountEmptyPasswordError;

    public void clickMyAccountSignInCTA() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", myAccountSignInCTA);
    }

    public boolean isMyAccountEmptyEmailErrorVisible() {
        return myAccountEmptyEmailError.isDisplayed();
    }

    public boolean isMyAccountEmptyPasswordErrorVisible() {
        return myAccountEmptyPasswordError.isDisplayed();
    }
}