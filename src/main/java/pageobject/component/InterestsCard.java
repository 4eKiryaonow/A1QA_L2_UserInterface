package pageobject.component;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static constant.ElementValueConstants.SELECT_ALL_CHECKBOX;
import static constant.ElementValueConstants.UNSELECT_ALL_CHECKBOX;

public class InterestsCard extends Form {
    private static By secondCardLocator = By.className("avatar-and-interests-page");
    private By checkBoxLabelLocator = By.xpath("//div[@class='avatar-and-interests__interests-list__item']");
    private By checkBoxLocator = By.className("checkbox__box");
    private IButton downloadImageBtn = getElementFactory()
            .getButton(By.xpath("//button[contains(text(), 'Download image')]"), "Download Image Button");
    private ITextBox uploadImage = getElementFactory()
            .getTextBox(By.xpath("//a[@class='avatar-and-interests__upload-button']"), "Upload Text Box");
    private IButton nextBtn = getElementFactory()
            .getButton(By.xpath("//button[contains(text(), 'Next')]"), "Next Button");
    private ICheckBox unselectAllCheckBox = getElementFactory()
            .getCheckBox(By.xpath("//label[@for='interest_unselectall']/span[@class='checkbox__box']"), "Unselect All checkbox");

    public InterestsCard() {
        super(secondCardLocator, "Second Card");
    }

    private List<ICheckBox> getListInterests() {
        return getElementFactory()
                .findElements(checkBoxLabelLocator, ILabel.class)
                .stream()
                .filter(iLabel -> !iLabel.getText().equals(UNSELECT_ALL_CHECKBOX) & !iLabel.getText().equals(SELECT_ALL_CHECKBOX))
                .flatMap(iLabel -> Optional.ofNullable(iLabel.findChildElement(checkBoxLocator, ICheckBox.class))
                        .stream())
                .collect(Collectors.toList());
    }
    public int getSizeInterestsList() {
        return getListInterests().size();
    }

    public void unselectAllInterests() {
        unselectAllCheckBox.check();
    }

    public void checkInterestsByIndex(int index) {
        List<ICheckBox> interestsList = getListInterests();
        interestsList.get(index).click();
    }

    public void clickUploadImage() {
        uploadImage.clickAndWait();
    }

    public void clickDownloadImageBtn() {
        downloadImageBtn.clickAndWait();
    }

    public void clickNextBtn() {
        nextBtn.clickAndWait();
    }
}