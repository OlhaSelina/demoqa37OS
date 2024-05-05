package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftSideMenu extends BasePage{
    public LeftSideMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'Alerts')]")
    WebElement btnAlerts;

    @FindBy(xpath = "//span[contains(text(),'Browser Windows')]")
    WebElement btnOpenWindowsPage;
    @FindBy(xpath = "//span[contains(text(),'Select Menu')]")
    WebElement btnSelectMenu;
    @FindBy(xpath = "//span[.='Droppable']")
    WebElement droppable;
    @FindBy(xpath = "//span[text()='Practice Form']")
    WebElement btnPracticeForm;


    public AlertsPage clickOnAlerts(){
       clickWithJsScroll(btnAlerts, 0, 200);
        return  new AlertsPage(driver);
    }


    public BrowserWindowsPage clickOnWindows() {
        clickWithJsScroll(btnOpenWindowsPage, 0,200);
        return new BrowserWindowsPage(driver);
    }

    public SelectMenuPage clickOnSelectMenu() {
        clickWithJsScroll(btnSelectMenu, 0,500);
        return new SelectMenuPage(driver);
    }

    public DroppablePage clickOnDroppable() {
        clickWithJsScroll(droppable, 0, 450);
        return new DroppablePage(driver);
    }

    public PracticeFormPage clickPracticeForm() {
        clickBase(btnPracticeForm);
        return new PracticeFormPage(driver);
    }
}
