import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import hoard.ConfigManager;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public abstract class BaseTest {
    @BeforeMethod
    public void setUp() {
        getBrowser().goTo(ConfigManager.getUrl());
    }
    @AfterMethod()
    public void tearDown() {
        getBrowser().quit();
    }
}