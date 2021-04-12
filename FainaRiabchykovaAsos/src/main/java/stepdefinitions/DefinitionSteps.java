package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    MyAccountPage myAccountPage;
    CheckoutPage checkoutPage;
    BagsPLP bagsPLP;
    BagPDP bagPDP;
    MyBagPage myBagPage;
    DressPDP dressPDP;
    SavedItemsPage savedItemsPage;
    ContentPages contentPages;
    GiftVouchersPage giftVouchersPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @Given("User opens {string}")
    public void userOpensHomePage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @When("User hover over MyAccount icon")
    public void userHoverOverMyAccountIcon() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.hoverMyAccountIcon();
    }


    @And("User clicks MyAccount link")
    public void userClicksMyAccountLink() {
        homePage.clickMyAccountLink();
    }

    @And("User clicks SignIn CTA")
    public void userClicksSignInCTA() {
        myAccountPage = pageFactoryManager.getMyAccountPage();
        myAccountPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        myAccountPage.clickMyAccountSignInCTA();
    }

    @Then("User checks that EmptyEmail error is shown")
    public void userChecksThatEmptyEmailErrorIsShown() {
        myAccountPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertTrue(myAccountPage.isMyAccountEmptyEmailErrorVisible());
    }

    @And("User checks that EmptyPassword error is shown")
    public void userChecksThatEmptyPasswordErrorIsShown() {
        assertTrue(myAccountPage.isMyAccountEmptyPasswordErrorVisible());
    }

    @When("User hover over Accessories button on Navigation menu")
    public void userHoverOverAccessoriesButtonOnNavigationMenu() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.hoverAccessories();
    }

    @And("User clicks on Bags link")
    public void userClicksOnBagsLink() {
        homePage.clickmenuNavBagsLink();
    }

    @And("User clicks on Product Tile on Bags PLP")
    public void userClicksOnProductTileOnBagsPLP() {
        bagsPLP = pageFactoryManager.getBagsPLP();
        bagsPLP.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        bagsPLP.clickBagTileOnPLP();
    }

    @And("User clicks on Add To Bag Button")
    public void userClicksOnAddToBagButton() {
        bagPDP = pageFactoryManager.getBagPDP();
        bagPDP.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        bagPDP.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        bagPDP.clickAddToBagOnPDP();
    }

    @And("User clicks on Checkout Link On MiniCart DropDown")
    public void userClicksOnCheckoutLinkOnPDPCartFlyOut() {
        bagPDP.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getMinibagDropdown());
        homePage.clickCheckoutLinkOnMiniBagDropDown();
    }

    @Then("User checks that checkout Page header is {string}")
    public void userChecksThatCheckoutPageHeaderIsHeader(final String expectedText) {
        checkoutPage = pageFactoryManager.getCheckoutPage();
        checkoutPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        checkoutPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, checkoutPage.getCheckoutHeader());
        assertEquals(expectedText, checkoutPage.getCheckoutHeaderText());
    }

    @And("User checks Search Field is visible")
    public void userChecksSearchFieldIsVisible() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isSearchFieldVisible();
    }

    @When("User enter {string} into Search Field")
    public void userEnterKeywordIntoSearchField(final String keyword) {
        homePage.enterTextToSearchField(keyword);
    }

    @And("User clicks Search Button")
    public void userClicksSearchButton() {
        homePage.clickSearchButton();
    }

    @And("User clicks on Bag link on MiniBag DropDown")
    public void userClicksOnBagLinkOnMiniBagDropDown() {
        bagPDP.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getMinibagDropdown());
        homePage.clickBagLinkOnMiniBagDropDown();
    }

    @And("User checks My Bag Page header is visible")
    public void userChecksMyBagPageHeaderIsVisible() {
        myBagPage = pageFactoryManager.getMyBagPage();
        myBagPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        myBagPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, myBagPage.getHeaderMyBagPage());
        myBagPage.isHeaderMyBagPageVisible();
    }

    @And("User clicks Remove icon on My Bag Page")
    public void userClicksRemoveIconOnMyBagPage() {
        myBagPage.clickOnRemoveIconOnMyBag();
    }

    @Then("User checks that Bag Page Title is {string}")
    public void userChecksThatBagPageTitleIsTitle(final String expectedText) {
        myBagPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        myBagPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, myBagPage.getEmptyBagTitle());
        assertEquals(expectedText, myBagPage.getEmptyBagTitleText());
    }

    @And("User clicks on SelectSize DropDown")
    public void userClicksOnSelectSizeDropDown() {
        dressPDP = pageFactoryManager.getDressPDP();
        dressPDP.waitVisibilityOfElement(DEFAULT_TIMEOUT, dressPDP.getSizeOption());
        dressPDP.clickSelectSizeDropDown();
    }

    @And("User clicks on Size Option")
    public void userClicksOnSizeOption() {
        dressPDP.implicitWait(DEFAULT_TIMEOUT);
        dressPDP.waitVisibilityOfElement(DEFAULT_TIMEOUT, dressPDP.getSizeOption());
        dressPDP.clickSizeOption();
    }

    @Then("User checks that Size Option on MyBag Page is the same as on PDP")
    public void userChecksThatSizeOptionOnMyBagPageIsTheSameAsOnPDP() {
        myBagPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, myBagPage.getSizeOptionOnMyBagPage());
        assertEquals(dressPDP.getSizeOptionOnPDPText(), myBagPage.getSizeOptionOnMyBagPageText());
    }


    @And("User clicks on Save for later button on MyBag Page")
    public void userClicksOnSaveForLaterButtonOnMyBagPage() {
        myBagPage = pageFactoryManager.getMyBagPage();
        myBagPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, myBagPage.getHeaderMyBagPage());
        myBagPage.clickSaveForLaterOnMyBagePage();
    }

    @And("User checks that Empty Bag title is visible")
    public void userChecksThatEmptyBagTitleIsVisible() {
        myBagPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, myBagPage.getEmptyBagTitle());
        myBagPage.isEmptyBagTitleVisible();
    }

    @And("User clicks on Saved Items Icon")
    public void userClicksOnSavedItemsIcon() {
        homePage.clickSavedItemsIcon();
    }

    @And("User checks Saved Items Page Title is visible")
    public void userChecksSavedItemsPageTitleIsVisible() {
        savedItemsPage = pageFactoryManager.getSavedItemsPage();
        savedItemsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, savedItemsPage.getSavedItemsPageTitle());
        savedItemsPage.isSavedItemsPageTitleVisible();
    }

    @And("User clicks on Move To Bag Button")
    public void userClicksOnMoveToBagButton() {
        savedItemsPage.clickMoveToBagCTA();
    }

    @And("User hover over MiniBag Icon")
    public void userHoverOverMiniBagIcon() {
        homePage.hoverOverMiniBagIcon();
    }

    @Then("User checks that MiniBag Items Count is {string}")
    public void userChecksThatMiniBagItemsCountIsItemsCount(final String expectedText) {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getMiniBagItemCount());
        assertEquals(expectedText, homePage.getMiniBagItemCountText());
    }

    @And("User clicks on Free Delivery Link On MiniBag Footer")
    public void userClicksOnFreeDeliveryLinkOnMiniBagFooter() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getMinibagDropdown());
        homePage.clickFreeDeliveryLinkOnMiniBagFooter();
    }

    @Then("User checks that current url contains {string} word")
    public void userChecksThatCurrentUrlContainsDeliveryWord(final String urlWord) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertTrue(driver.getCurrentUrl().contains(urlWord));
    }

    @When("User clicks on Help Link On Footer")
    public void userClicksOnHelpLinkOnFooter() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.clickHelpLinkOnFooter();
    }

    @And("User checks Search For Help Field is Visible")
    public void userChecksSearchForHelpFieldIsVisible() {
        contentPages = pageFactoryManager.getContentPages();
        contentPages.waitVisibilityOfElement(DEFAULT_TIMEOUT, contentPages.getSearchForHelpField());
        contentPages.isSearchForHelpFieldVisible();
    }

    @And("User enter {string} into Search For Help Field")
    public void userEnterKeywordIntoSearchForHelpField(final String keyword) {
        contentPages.enterTextToSearchForHelpField(keyword);
    }

    @And("User clicks on search For Help Button")
    public void userClicksOnSearchForHelpButton() {
        contentPages.clickSearchForHelpButton();
    }

    @And("User checks that Search Header contains Text {string}")
    public void userChecksThatSearchHeaderContainsTextKeyword(final String keyword) {
        contentPages.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        contentPages.waitVisibilityOfElement(DEFAULT_TIMEOUT, contentPages.getSearchHeaderAfterSearchForHelp());
        assertTrue(contentPages.getSearchHeaderAfterSearchForHelpText(keyword));
    }

    @And("User click on Return Something To You Tab")
    public void userClickOnReturnSomethingToYouTab() {
        contentPages.clickReturnSomethingToYouTab();
    }

    @And("User checks that Return Something ToYou Header is Visible")
    public void userChecksThatReturnSomethingToYouHeaderIsVisible() {
        contentPages.waitVisibilityOfElement(DEFAULT_TIMEOUT, contentPages.getReturnSomethingToYouHeader());
        contentPages.isReturnSomethingToYouHeaderVisible();
    }

    @And("User clicks on View Your Returns Options Link")
    public void userClicksOnViewYourReturnsOptionsLink() {
        contentPages.clickOnViewYourReturnsOptions();
    }

    @And("User clicks on  Bags Breadcrums Link")
    public void userClicksOnBagsBreadcrumsLink() {
        bagPDP = pageFactoryManager.getBagPDP();
        bagPDP.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        bagPDP.waitVisibilityOfElement(DEFAULT_TIMEOUT, bagPDP.getBagsBreadcrumsLink());
        bagPDP.clickBagsBreadcrumsLink();
    }

    @When("User clicks Gift Vouchers Link On Footer")
    public void userClicksGiftVouchersLinkOnFooter() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.clickGiftVouchersLinkOnFooter();
    }

    @And("User checks Gift Vouchers Title contains {string}")
    public void userChecksGiftVouchersTitleContainsTitleText(final String titleText) {
        giftVouchersPage = pageFactoryManager.getGiftVouchersPage();
        giftVouchersPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        giftVouchersPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, giftVouchersPage.getGiftVouchersTitle());
        assertTrue(giftVouchersPage.containsGiftVouchersTitleText(titleText));
    }

    @And("User enters {string} into Voucher Value Field")
    public void userEntersValueTextIntoVoucherValueField(final String valueText) {
        giftVouchersPage.enterTextToVoucherValueField(valueText);
    }

    @And("User enters {string} into Voucher Email Field")
    public void userEntersEmailTextIntoVoucherEmailField(final String emailText) {
        giftVouchersPage.enterTextToVoucherEmailField(emailText);
    }

    @And("User enters {string} into Voucher Name Field")
    public void userEntersNameTextIntoVoucherNameField(final String nameText) {
        giftVouchersPage.enterTextToVoucherNameField(nameText);
    }

    @And("User clicks  Pay Securely Now Button")
    public void userClicksPaySecurelyNowButton() {
        giftVouchersPage.clickPaySecurelyNow();
    }


    @When("User clicks on select Country Icon;")
    public void userClicksOnSelectCountryIcon() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.clickSelectCountryIcon();
    }

    @And("User clicks on select Currency Field")
    public void userClicksOnSelectCurrencyField() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getCountrySelectorForm());
        homePage.clickCurrencyField();
    }

    @And("User clicks on Euro Option")
    public void userClicksOnEuroOption() {
        homePage.clickEuroOption();
    }

    @And("User clicks on updatePreferencesCTA")
    public void userClicksOnUpdatePreferencesCTA() {
        homePage.clickUpdatePreferencesCTA();
    }

    @Then("User checks that Price component on PDP contains {string}")
    public void userChecksThatPriceComponentOnPDPContainsCurrencySign(final String currencySign) {
        bagPDP = pageFactoryManager.getBagPDP();
        bagPDP.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        bagPDP.waitVisibilityOfElement(DEFAULT_TIMEOUT, bagPDP.getCurrentPriceOnPDP());
        assertTrue(bagPDP.containCurrencySignOnPriceOnPDP(currencySign));
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
