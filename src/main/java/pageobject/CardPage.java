package pageobject;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import pageobject.component.*;

public class CardPage extends Form {
    private static By timerLocator = By.cssSelector(".timer");
    private ILabel timerLabel = getElementFactory().getLabel(timerLocator, "Timer Label");
    private LoginCard loginCard = new LoginCard();
    private InterestsCard interestsCard = new InterestsCard();
    private PersonalDetailsCard personalDetailsCard = new PersonalDetailsCard();
    private HelpForm helpForm = new HelpForm();
    private CookiesForm cookiesForm = new CookiesForm();

    public CardPage() {
        super(timerLocator, "Card Page");
    }

    public LoginCard loginCard() {
        return this.loginCard;
    }

    public InterestsCard interestsCard() {
        return this.interestsCard;
    }

    public PersonalDetailsCard personalDetailsCard() {
        return this.personalDetailsCard;
    }

    public HelpForm helpForm() {
        return this.helpForm;
    }

    public CookiesForm cookies() {
        return this.cookiesForm;
    }

    public String getTimeValue() {
        return timerLabel.getText();
    }
}