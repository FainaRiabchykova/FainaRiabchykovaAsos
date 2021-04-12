package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BagsPLP extends BasePage {

    public BagsPLP(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(@href, '24155441')]")
    private WebElement bagTileOnPLP;

    public void clickBagTileOnPLP() {
        bagTileOnPLP.click();
    }
}
