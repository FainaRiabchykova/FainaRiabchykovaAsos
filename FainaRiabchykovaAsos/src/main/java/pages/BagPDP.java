package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BagPDP extends BasePage {

    public BagPDP(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@data-test-id='add-button']")
    private WebElement addToBagButtonPDP;

    @FindBy(xpath = "//nav[@aria-label='breadcrumbs']//a[contains(@href, 'bags-purses')]")
    private WebElement bagsBreadcrumsLink;

    @FindBy(xpath = "//span[@data-id='current-price']")
    private WebElement currentPriceOnPDP;


    public void clickAddToBagOnPDP() {
        addToBagButtonPDP.click();
    }

    public void clickBagsBreadcrumsLink() {
        bagsBreadcrumsLink.click();
    }

    public WebElement getBagsBreadcrumsLink() {
        return bagsBreadcrumsLink;
    }

    public WebElement getCurrentPriceOnPDP() {
        return currentPriceOnPDP;
    }

    public Boolean containCurrencySignOnPriceOnPDP(final String currencySign) {
        return currentPriceOnPDP.getText().contains(currencySign);
    }
}

