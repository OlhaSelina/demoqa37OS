package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectMenuPage extends BasePage{
    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }
@FindBy(xpath = "//div[contains(text(),'Select Option')]")
WebElement fildSelectMenu;
    public SelectMenuPage fillSelectValue(String str) {
        clickWithJsScroll(fildSelectMenu,0,400);
       // some function to click on text
                return this;
    }
    @FindBy(xpath = "//div[@id='selectOne']")
    WebElement selectOne;
    public SelectMenuPage fillSelectOne(String str) {

    return this;
    }
    @FindBy(xpath = "//select[@id='oldSelectMenu']")
    WebElement selectDropDown;
    public SelectMenuPage fillOldStyleSelectMenu(String str) {
        Select select = new Select(selectDropDown);
        select.selectByVisibleText(str);
        List<WebElement> options = select.getOptions();
        for (WebElement element: options){
            if (getTextBase(element).equals(str)){
                clickBase(element);
                break;
            }
        }
        return this;
    }
    @FindBy(id = "react-select-4-input")
    WebElement multiSelect;
    @FindBy(className = "text-center")
    WebElement pageTitele;
    public SelectMenuPage fillMultiSelect(String[] colors) {
        for (String color: colors){
            multiSelect.sendKeys(color);
            multiSelect.sendKeys(Keys.ENTER); // нажать кнопку Enter
        }
        clickBase(pageTitele);
        return this;
    }
}
