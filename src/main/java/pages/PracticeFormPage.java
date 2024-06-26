package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PracticeFormPage extends BasePage{
    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "firstName")
    WebElement inputName;
    @FindBy(id = "lastName")
    WebElement inputLastName;
    @FindBy(id = "userEmail")
    WebElement inputEmail;
    @FindBy(id = "userNumber")
    WebElement inputPhone;
    public PracticeFormPage enterPersonalData(String name, String lastName,
                                              String email, String phone) {
        typeText(inputName, name);
        typeText(inputLastName, lastName);
        typeText(inputEmail, email);
        typeText(inputPhone, phone);
        return this;
    }
    @FindBy(css = "[for='gender-radio-1']")
    WebElement male;
    @FindBy(css = "[for='gender-radio-2']")
    WebElement female;
    @FindBy(css = "[for='gender-radio-3']")
    WebElement other;
    public PracticeFormPage selectGender(String gender) {
        if (gender.equals("Male")){
            clickBase(male);
        }else if(gender.equals("Female")){
            clickBase(female);
        }else {
            clickBase(other);
        }
        return this;
    }

    @FindBy(id = "dateOfBirthInput")
    WebElement inputDateOfBirth;

    public PracticeFormPage enterBirthDay(String dataBirth) {
        clickWithJsScroll(inputDateOfBirth, 0,520);
        Keys key = getKeyForOSCommandOrControl();
        inputDateOfBirth.sendKeys(key, "a");
        inputDateOfBirth.sendKeys(dataBirth);
        inputDateOfBirth.sendKeys(Keys.ENTER);
        return this;
    }
    @FindBy(id = "subjectsInput")
    WebElement inputSubjects;
    public PracticeFormPage enterSubjects(String[] strings) {
        for (String str:strings) {
            typeText(inputSubjects, str);
            inputSubjects.sendKeys(Keys.ENTER);
        }
        return this;
    }
    @FindBy(xpath = "//label[contains(@for,'hobbies')]")
    List<WebElement> allHobbies;
    public PracticeFormPage selectHobby(String[] strings) {
        for (String str:strings) {
            for (WebElement element:allHobbies){
                if (getTextBase(element).equals(str)) {
                    clickBase(element);
                    break;
                }
            }
        }
        return this;
    }
    @FindBy(xpath = "//input[@id='uploadPicture']")
    WebElement btnUploadFile;
    public PracticeFormPage uploadFile(String path) {
        btnUploadFile.sendKeys(path);
        return this;
    }
    @FindBy(xpath = "//input[@id='react-select-3-input']")
    WebElement inputState;
    public PracticeFormPage selectState(String state) {
        //clickBase(inputState);
        inputState.sendKeys(state);
        inputState.sendKeys(Keys.ENTER);
        return this;
    }
    @FindBy(xpath = "//input[@id='react-select-4-input']")
    WebElement inputCity;
    public PracticeFormPage selectCity(String city) {
        //clickBase(inputCity);
        inputCity.sendKeys(city);
        inputCity.sendKeys(Keys.ENTER);
        return this;
    }
    @FindBy(id = "submit")
    WebElement btnSubmit;
    public PracticeFormPage clickOnSubmit() {
        clickBase(btnSubmit);
        return this;
    }
    @FindBy(xpath = "//div[contains(@class,'modal-title')]")
    WebElement successTitleModal;
    public boolean verifySuccessTitle(String str) {
        String actualRes = getTextBase(successTitleModal);
        return isStringEqual(actualRes, str);
    }
}
