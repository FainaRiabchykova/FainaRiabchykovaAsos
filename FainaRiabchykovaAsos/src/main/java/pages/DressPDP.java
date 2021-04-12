package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DressPDP extends BasePage {

    public DressPDP(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='colour-size-select']//select[@data-id='sizeSelect']")
    private WebElement selectSizeDropDown;

    @FindBy(xpath = "//option[text()='EU 46']")
    private WebElement sizeOption;

    public void clickSelectSizeDropDown() {
        Actions actions = new Actions(driver);
        actions.click(selectSizeDropDown);
        actions.build().perform();
    }

    public void clickSizeOption() {
        sizeOption.click();
    }

    public String getSizeOptionOnPDPText() {
        return sizeOption.getText();
    }
    public WebElement getSizeOption() {
        return sizeOption;
    }
}
