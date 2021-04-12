package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SavedItemsPage extends BasePage {

    public SavedItemsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[@class='header_tS_Sk']")
    private WebElement savedItemsPageTitle;

    @FindBy(xpath = "//button[contains(@class,'toBagButton')]")
    private WebElement moveToBagCTA;

    public WebElement getSavedItemsPageTitle() {
        return savedItemsPageTitle;
    }

    public void isSavedItemsPageTitleVisible() {
        savedItemsPageTitle.isDisplayed();
    }

    public void clickMoveToBagCTA() {
        moveToBagCTA.click();
    }
}
