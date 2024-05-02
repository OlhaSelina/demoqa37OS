package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LeftSideMenu;
import pages.SelectMenuPage;

public class SelectMenuTests extends BaseTest{

    @BeforeClass
    public void beforeClassPreconditions(){
        new HomePage(driver).clickoNwIDGETS();
        new LeftSideMenu(driver).clickOnSelectMenu();
    }
    @Test
    public void fillFormTest(){
        new SelectMenuPage(driver)
                .fillSelectValue("Group 1, option 1")
                .fillSelectOne("Mr.")
                .fillOldStyleSelectMenu("Red")
                .fillMultiSelect(new String[]{"Green", "Black" })
                .fillStandsrtMultiSelect("Volvo");
        SelectMenuPage selectMenuPage = new SelectMenuPage(driver);
        softAssert.assertTrue(selectMenuPage.verifySelectValue("Group 1, option 1"));
        softAssert.assertTrue(selectMenuPage.verifySelectOne("Mr."));
        softAssert.assertTrue(selectMenuPage.verifyOldStyleSelectMenu("Red"));
        softAssert.assertTrue(selectMenuPage.verifyDropDownSelect("Green"));
        softAssert.assertTrue(selectMenuPage.verifyStandsrtMultiSelect("Volvo"));

        softAssert.assertAll();

    }

}
