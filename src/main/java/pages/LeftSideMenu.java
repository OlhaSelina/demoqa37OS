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
    WebElement btnOpenWindows;
    @FindBy(xpath = "//span[contains(text(),'Select Menu')]")
    WebElement btnSelectMenu;
    public AlertsPage clickOnAlerts(){
       clickWithJsScroll(btnAlerts, 0, 200);
        return  new AlertsPage(driver);
    }


    public BrowserWindowsPage clickOnWindows() {
        clickWithJsScroll(btnOpenWindows, 0,200);
        return new BrowserWindowsPage(driver);
    }

    public SelectMenuPage clickOnSelectMenu() {
        clickWithJsScroll(btnSelectMenu, 0,500);
        return new SelectMenuPage(driver);
    }

}
