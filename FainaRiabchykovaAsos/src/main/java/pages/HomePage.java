package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }
    //elements
    @FindBy(xpath = "//span[@type='accountUnfilled']")
    private WebElement myAccountIcon;

    @FindBy(xpath = "//a[@data-testid='myaccount-link']")
    private WebElement myAccountLink;

    @FindBy(xpath = "//button[@data-testid='primarynav-button' and contains(@data-id, '9cc4929a7134')]//span[text()='Accessories']")
    private WebElement menuNavAccessories;

    @FindBy(xpath = "//li[@class='_1g1PWkA _1rF5dEp']//a[text()='Bags & Purses']")
    private WebElement menuNavBagsLink;

    @FindBy(xpath = "//div[@data-testid='minibag-dropdown']")
    private WebElement minibagDropdown;

    @FindBy(xpath = "//input[@data-testid='search-input']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@data-testid='search-button-inline']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@data-test-id='checkout-link']")
    private WebElement checkoutLinkMiniBagDropDown;

    @FindBy(xpath = "//a[@data-test-id='bag-link']")
    private WebElement bagLinkMiniBagDropDown;

    @FindBy(xpath = "//a[@data-testid='savedItemsIcon']")
    private WebElement savedItemsIcon;

    @FindBy(xpath = "//a[@data-testid='miniBagIcon']")
    private WebElement miniBagIcon;

    @FindBy(xpath = "//span[@data-test-id='miniBagItemCount']")
    private WebElement miniBagItemCount;

    @FindBy(xpath = "//div[@data-test-id='miniBagFooter']//a[contains(@href, 'delivery')]")
    private WebElement freeDeliveryLinkOnMiniBagFooter;

    @FindBy(xpath = "//section[@data-testid='footer-links']//a[contains(@href,'customer-care')]")
    private WebElement helpLinkOnFooter;

    @FindBy(xpath = "//section[@data-testid='footer-links']//a[contains(@href,'gift-vouchers')]")
    private WebElement giftVouchersLinkOnFooter;

    @FindBy(xpath = "//div[@data-testid='topbar']//button[@data-testid='country-selector-btn']")
    private WebElement selectCountryIcon;

    @FindBy(xpath = "//section[@data-testid='country-selector-form']")
    private WebElement countrySelectorForm;

    @FindBy(xpath = "//select[@id='currency']")
    private WebElement selectCurrencyField;

    @FindBy(xpath = "//option[text()='€ EUR']")
    private WebElement euroOption;

    @FindBy(xpath = "//button[@data-testid='save-country-button']")
    private WebElement updatePreferencesCTA;


    //methods
    public void hoverMyAccountIcon() {
        Actions builder = new Actions(driver);
        builder.moveToElement(myAccountIcon).build().perform();
    }

    public void clickMyAccountLink() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", myAccountLink);
    }

    public void hoverAccessories() {
        Actions builder = new Actions(driver);
        builder.moveToElement(menuNavAccessories).build().perform();
    }

    public void clickmenuNavBagsLink() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", menuNavBagsLink);
    }

    public WebElement getMinibagDropdown() {
        return minibagDropdown;
    }

    public void isSearchFieldVisible() {
        searchField.isDisplayed();
    }

    public void enterTextToSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText);
    }

    public void clickSearchButton() {
        searchButton.click();
    }


    public void clickCheckoutLinkOnMiniBagDropDown() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", checkoutLinkMiniBagDropDown);
    }

    public void clickBagLinkOnMiniBagDropDown() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", bagLinkMiniBagDropDown);
    }

    public void clickSavedItemsIcon() {
        savedItemsIcon.click();
    }

    public void hoverOverMiniBagIcon() {
        Actions builder = new Actions(driver);
        builder.moveToElement(miniBagIcon).build().perform();
    }

    public WebElement getMiniBagItemCount() {
        return miniBagItemCount;
    }

    public String getMiniBagItemCountText() {
        return miniBagIcon.getText();
    }

    public void clickFreeDeliveryLinkOnMiniBagFooter() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", freeDeliveryLinkOnMiniBagFooter);
    }

    public void clickHelpLinkOnFooter() {
        helpLinkOnFooter.click();
    }

    public void clickGiftVouchersLinkOnFooter() {
        giftVouchersLinkOnFooter.click();
    }

    public void clickSelectCountryIcon() {
        selectCountryIcon.click();
    }

    public WebElement getCountrySelectorForm() {
        return countrySelectorForm;
    }

    public void clickCurrencyField() {
        selectCurrencyField.click();
    }

    public void clickEuroOption() {
        euroOption.click();
    }

    public void clickUpdatePreferencesCTA() {
        updatePreferencesCTA.click();
    }
}
