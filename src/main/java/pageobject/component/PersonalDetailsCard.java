package pageobject.component;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PersonalDetailsCard extends Form {
    private static By thirdCardLocator = By.className("personal-details");
    public PersonalDetailsCard() {
        super(thirdCardLocator, "Third Card");
    }
}