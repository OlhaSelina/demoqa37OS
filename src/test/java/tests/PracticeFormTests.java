package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LeftSideMenu;
import pages.PracticeFormPage;

public class PracticeFormTests extends BaseTest{

    @BeforeClass
    public void precondition(){
        new HomePage(driver).clickForms();
        new LeftSideMenu(driver).clickPracticeForm();
    }

    @Test
    public void practiceFormTest(){
        new PracticeFormPage(driver).hideIFrames();
        new PracticeFormPage(driver).enterPersonalData("Tom", "Smith",
                "tommsmith@gmail.com", "1234567890")
                .selectGender("Male")
                .enterBirthDay("16 Aug 1987")
                .enterSubjects(new String[]{"Maths", "Chemistry"})
                .selectHobby(new String[]{"Sports","Reading"})
                .uploadFile("C:\\Tools\\testfile\\intro.JPEG")
                .selectState("NCR")
                .selectCity("Delhi")
                .clickOnSubmit()
                .verifySuccessTitle("Thanks for submitting the form");

    }
}
