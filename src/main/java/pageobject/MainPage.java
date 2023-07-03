package pageobject;

import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MainPage extends Form {
    private static By labelLocator = By.className("start__button");
    private ITextBox linkHere = getElementFactory().getTextBox(By.className("start__link"), "Link Here");

    public MainPage() {
        super(labelLocator, "Main Page");
    }

    public void clickLinkHere() {
        linkHere.clickAndWait();
    }
}