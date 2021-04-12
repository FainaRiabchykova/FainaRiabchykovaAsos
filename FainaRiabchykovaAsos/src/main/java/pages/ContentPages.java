package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContentPages extends BasePage {

    public ContentPages(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[contains(@aria-label,'Search for help')]")
    private WebElement searchForHelpField;

    @FindBy(xpath = "//button[contains(@aria-label,'Search for help')]")
    private WebElement searchForHelpButton;

    @FindBy(xpath = "//h1[@class='SearchHeader_header']")
    private WebElement searchHeaderAfterSearchForHelp;

    @FindBy(xpath = "//h1[@class='PageTitle_header']")
    private WebElement returnSomethingToYouHeader;

    @FindBy(xpath = "//a[contains(@href, 'return-something-to-you')]")
    private WebElement returnSomethingToYouTab;

    @FindBy(xpath = "//a[contains(@href, 'returns') and contains(text(), 'View your returns options here')]")
    private WebElement viewYourReturnsOptionsLink;

    @FindBy(xpath = "//h1[text()='Delivery And Returns']")
    private WebElement deliveryAndReturnsHeader;

    public WebElement getSearchForHelpField() {
        return searchForHelpField;
    }

    public void isSearchForHelpFieldVisible() {
        searchForHelpField.isDisplayed();
    }

    public void enterTextToSearchForHelpField(final String searchText) {
        searchForHelpField.clear();
        searchForHelpField.sendKeys(searchText);
    }

    public void clickSearchForHelpButton() {
        searchForHelpButton.click();
    }

    public WebElement getSearchHeaderAfterSearchForHelp() {
        return searchHeaderAfterSearchForHelp;
    }

    public Boolean getSearchHeaderAfterSearchForHelpText(final String keyword) {
        return searchHeaderAfterSearchForHelp.getText().contains(keyword);
    }

    public void clickReturnSomethingToYouTab() {
        returnSomethingToYouTab.click();
    }

    public WebElement getReturnSomethingToYouHeader() {
        return returnSomethingToYouHeader;
    }

    public void isReturnSomethingToYouHeaderVisible() {
        returnSomethingToYouHeader.isDisplayed();
    }

    public void clickOnViewYourReturnsOptions() {
        viewYourReturnsOptionsLink.click();
    }

    public WebElement getDeliveryAndReturnsHeader() {
        return deliveryAndReturnsHeader;
    }

}
