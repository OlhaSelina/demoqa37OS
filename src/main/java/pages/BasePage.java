package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BasePage {
    WebDriver driver;

    JavascriptExecutor js; // для скрола на странице
    static Logger logger = LoggerFactory.getLogger(BasePage.class);

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }

    public void clickBase(WebElement element){
        element.click();
    }

    public void clickWithJsScroll(WebElement element, int x, int y){
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
        clickBase(element); // проскролить, а потом кликнуть на  елемент
    }
    public void typeText(WebElement element, String text){
        element.click();
        element.clear();
        element.sendKeys();
    }
    public String getTextBase(WebElement element) {
        return element.getText().trim();
    }
    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    protected  boolean isStringEqual(String actualRes, String expectedRes){
        if(actualRes.equals(expectedRes)){
            return true;
        }else{
            System.out.println("actual res: " + actualRes
            + "expected res: " + expectedRes);
            return false;
        }
    }

}
