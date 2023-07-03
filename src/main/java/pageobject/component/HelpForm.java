package pageobject.component;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HelpForm extends Form {
    private static By helpFormLocator = By.cssSelector(".help-form__close-button");
    private IButton sendToBottomBtn = getElementFactory()
            .getButton(By.xpath("//button[contains(@class, 'send-to-bottom-button')]"), "Send To Bottom Button");

    public HelpForm() {
        super(helpFormLocator, "Help Form");
    }

    public void clickSendToBottomBtn() {
        sendToBottomBtn.clickAndWait();
    }
}