package tests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DroppablePage;
import pages.HomePage;
import pages.LeftSideMenu;
public class DroppableTests extends BaseTest{
    @BeforeClass
    public void precondition() {
        new HomePage(driver).clickOnInteractions();
        new LeftSideMenu(driver).clickOnDroppable();
    }

    @Test
    public void dragAndDropActions() {
        new DroppablePage(driver).actionsDragMe();
    }
}
