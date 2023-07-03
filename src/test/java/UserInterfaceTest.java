import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.CardPage;
import pageobject.MainPage;
import utils.LoggerManager;
import utils.RandomUtil;
import utils.ScriptExecutor;
import hoard.TestDataManager;

import java.util.List;

public class UserInterfaceTest extends BaseTest {

    @Test(testName = "Get personal details card")
    public void getToPersonalDetailsCardTest() {
        LoggerManager.info("Step 1: Navigate to home page");
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main Page is not displayed");
        LoggerManager.info("Step 2: Click the link (in text 'Please click HERE to GO to the next page') to navigate the next page");
        mainPage.clickLinkHere();
        CardPage cardPage = new CardPage();
        Assert.assertTrue(cardPage.loginCard().state().waitForDisplayed(), "First Card is not displayed");
        LoggerManager.info("Step 3: Input random valid password, email, accept the terms of use and click \"next\" button");
        cardPage.loginCard().inputPassword(TestDataManager.getPassword());
        cardPage.loginCard().inputEmail(TestDataManager.getEmail());
        cardPage.loginCard().inputDomainName(TestDataManager.getDomainName());
        cardPage.loginCard().acceptCheckBox();
        cardPage.loginCard().clickDropDownDomain();
        int sizeValidDomainList = cardPage.loginCard().getSizeValidDomainList();
        int randomDomainIndex = RandomUtil.getRandomInt(sizeValidDomainList);
        cardPage.loginCard().chooseDomainByIndex(randomDomainIndex);
        cardPage.loginCard().clickNextBtn();
        Assert.assertTrue(cardPage.interestsCard().state().waitForDisplayed(), "Second Card is not displayed");
        LoggerManager.info("Step 4: Choose 2 random interests, upload image, click \"Next\" button");
        cardPage.interestsCard().unselectAllInterests();
        int listInterestSize = cardPage.interestsCard().getSizeInterestsList();
        int amountInterests = TestDataManager.getAmountInterests();
        List<Integer> randomIndexesList = RandomUtil.getRandomIndexes(amountInterests, listInterestSize);
        for (int i = 0; i < randomIndexesList.size(); i++) {
            cardPage.interestsCard().checkInterestsByIndex(randomIndexesList.get(i));
        }
        cardPage.interestsCard().clickDownloadImageBtn();
        cardPage.interestsCard().clickUploadImage();
        ScriptExecutor.uploadImage();
        cardPage.interestsCard().clickNextBtn();
        Assert.assertTrue(cardPage.personalDetailsCard().state().waitForDisplayed(), "Third Card is not displayed");
    }

    @Test(testName = "Hide Help Form")
    public void hideHelpFormTest() {
        LoggerManager.info("Step 1: Navigate to home page");
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main Page is not displayed");
        mainPage.clickLinkHere();
        LoggerManager.info("Step 2: Hide help form");
        CardPage cardPage = new CardPage();
        cardPage.helpForm().clickSendToBottomBtn();
        Assert.assertTrue(cardPage.helpForm().state().waitForNotDisplayed(), "Help Form is not hidden");
    }

    @Test(testName = "Accept cookies")
    public void acceptCookiesTest() {
        LoggerManager.info("Step 1: Navigate to home page");
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main Page is not displayed");
        mainPage.clickLinkHere();
        LoggerManager.info("Step 2: Accept cookies");
        CardPage cardPage = new CardPage();
        cardPage.cookies().clickAcceptCookies();
        Assert.assertTrue(cardPage.cookies().state().waitForNotDisplayed(), "Cookies Form is not hidden");
    }

    @Test(testName = "Comparing start value")
    public void compareStartValueTest() {
        LoggerManager.info("Step 1: Navigate to home page");
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main Page is not displayed");
        mainPage.clickLinkHere();
        CardPage cardPage = new CardPage();
        Assert.assertEquals(cardPage.getTimeValue(), TestDataManager.getTimeValue(), "Time value doesn't match");
    }
}