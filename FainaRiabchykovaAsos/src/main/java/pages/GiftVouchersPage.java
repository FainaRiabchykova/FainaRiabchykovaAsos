package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GiftVouchersPage extends BasePage {

    public GiftVouchersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[@data-test-id='title']")
    private WebElement giftVouchersTitle;

    @FindBy(xpath = "//input[@id='voucher-value']")
    private WebElement voucherValueField;

    @FindBy(xpath = "//input[@id='voucher-toEmail']")
    private WebElement voucherEmailField;

    @FindBy(xpath = "//input[@id='voucher-toName']")
    private WebElement voucherNameField;

    @FindBy(xpath = "//button[@data-test-id='paySecurelyNow']")
    private WebElement paySecurelyNowCTA;

    public WebElement getGiftVouchersTitle() {
        return giftVouchersTitle;
    }

    public Boolean containsGiftVouchersTitleText(final String keyword) {
        return giftVouchersTitle.getText().contains(keyword);
    }

    public void enterTextToVoucherValueField(final String valueText) {
        voucherValueField.clear();
        voucherValueField.sendKeys(valueText);
    }

    public void enterTextToVoucherEmailField(final String emailText) {
        voucherEmailField.clear();
        voucherEmailField.sendKeys(emailText);
    }

    public void enterTextToVoucherNameField(final String nameText) {
        voucherNameField.clear();
        voucherNameField.sendKeys(nameText);
    }

    public void clickPaySecurelyNow() {
        paySecurelyNowCTA.click();
    }
}
