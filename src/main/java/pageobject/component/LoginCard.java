package pageobject.component;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

import static constant.ElementValueConstants.OTHER_DOMAIN;

public class LoginCard extends Form {
    private static By firstCardLocator = By.className("login-form");
    private By domainListLocator = By.className("dropdown__list-item");
    private ITextBox passwordField = getElementFactory()
            .getTextBox(By.xpath("//input[@placeholder='Choose Password']"), "Password Field");
    private ITextBox emailField = getElementFactory()
            .getTextBox(By.xpath("//input[@placeholder='Your email']"), "Email Field");
    private ITextBox domainNameField = getElementFactory()
            .getTextBox(By.xpath("//input[@placeholder='Domain']"), "Domain Name Field");
    private IButton dropDownDomain = getElementFactory().
            getButton(By.xpath("//div[@class='dropdown__opener']/span"), "Dropdown Domain");
    private ICheckBox acceptCheckBox = getElementFactory()
            .getCheckBox(By.className("checkbox"), "Terms and Conditions CheckBox");
    private IButton nextBtn = getElementFactory()
            .getButton(By.xpath("//a[@class='button--secondary']"), "Next Button");

    public LoginCard() {
        super(firstCardLocator, "First Card");
    }

    public void inputPassword(String password) {
        passwordField.clearAndType(password);
    }

    public void inputEmail(String email) {
        emailField.clearAndType(email);
    }

    public void inputDomainName(String domainName) {
        domainNameField.clearAndType(domainName);
    }

    public void clickNextBtn() {
        nextBtn.clickAndWait();
    }

    public void acceptCheckBox() {
        acceptCheckBox.check();
    }

    public void clickDropDownDomain() {
        dropDownDomain.clickAndWait();
    }

    private List<ITextBox> getValuesDomainField() {
        return getElementFactory()
                .findElements(domainListLocator, ElementType.TEXTBOX);
    }

    private List<ITextBox> getValidValuesDomain() {
        return getValuesDomainField()
                .stream()
                .filter(iTextBox -> !iTextBox.getText().equals(OTHER_DOMAIN))
                .collect(Collectors.toList());
    }

    public int getSizeValidDomainList() {
        return getValidValuesDomain().size();
    }

    private ITextBox getDomain(int index) {
        return getValidValuesDomain().get(index);
    }

    public void chooseDomainByIndex(int index) {
        getDomain(index).clickAndWait();
    }
}