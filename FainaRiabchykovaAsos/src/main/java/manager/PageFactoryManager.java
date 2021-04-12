package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public MyAccountPage getMyAccountPage() {
        return new MyAccountPage(driver);
    }

    public BagsPLP getBagsPLP() {
        return new BagsPLP(driver);
    }

    public BagPDP getBagPDP() {
        return new BagPDP(driver);
    }

    public CheckoutPage getCheckoutPage() {
        return new CheckoutPage(driver);
    }

    public MyBagPage getMyBagPage() {
        return new MyBagPage(driver);
    }

    public DressPDP getDressPDP() {
        return new DressPDP(driver);
    }

    public SavedItemsPage getSavedItemsPage() {
        return new SavedItemsPage(driver);
    }

    public ContentPages getContentPages() {
        return new ContentPages(driver);
    }

    public GiftVouchersPage getGiftVouchersPage() {
        return new GiftVouchersPage(driver);
    }

}
