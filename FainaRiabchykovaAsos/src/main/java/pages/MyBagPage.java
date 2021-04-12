package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyBagPage extends BasePage {

    public MyBagPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[@class='bag-title bag-title--items']")
    private WebElement headerMyBagPage;

    @FindBy(xpath = "//button[@class='bag-item-remove']")
    private WebElement removeIconOnMyBag;

    @FindBy(xpath = "//h2[@class='empty-bag-title']")
    private WebElement emptyBagTitle;

    @FindBy(xpath = "//span[@title='EU 46']")
    private WebElement sizeOptionOnMyBagPage;

    @FindBy(xpath = "//button[@class='bag-item-moveToSaved']")
    private WebElement saveForLaterOnMyBagePage;

    public WebElement getHeaderMyBagPage() {
        return headerMyBagPage;
    }

    public void isHeaderMyBagPageVisible() {
        headerMyBagPage.isDisplayed();
    }

    public void clickOnRemoveIconOnMyBag() {
        removeIconOnMyBag.click();
    }

    public WebElement getEmptyBagTitle() {
        return emptyBagTitle;
    }

    public void isEmptyBagTitleVisible() {
        emptyBagTitle.isDisplayed();
    }

    public String getEmptyBagTitleText() {
        return emptyBagTitle.getText();
    }

    public WebElement getSizeOptionOnMyBagPage() {
        return sizeOptionOnMyBagPage;
    }

    public String getSizeOptionOnMyBagPageText() {
        return sizeOptionOnMyBagPage.getText();
    }

    public void clickSaveForLaterOnMyBagePage() {
        saveForLaterOnMyBagePage.click();
    }
}
