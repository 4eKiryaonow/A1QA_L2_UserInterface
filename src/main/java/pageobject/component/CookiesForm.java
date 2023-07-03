package pageobject.component;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CookiesForm extends Form {
    private static By cookiesLocator = By.className("cookies");
    private IButton acceptCookies = getElementFactory()
            .getButton(By.xpath("//button[contains(text(), 'Not really, no')]"), "No Button");

    public CookiesForm() {
        super(cookiesLocator, "Cookies Form");
    }

    public void clickAcceptCookies() {
        acceptCookies.clickAndWait();
    }
}