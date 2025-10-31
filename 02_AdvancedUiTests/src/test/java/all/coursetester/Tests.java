package all.coursetester;

import all.TestBase;
import all.coursetester.pages.AuthorizationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class Tests extends TestBase {
    @Test
    public void personalPage_AddDifferentCourses_Success(){
        //arrange
        var authorizationPage = new AuthorizationPage(driver, wait);
        authorizationPage.open();
        var mainPage = authorizationPage.authorize("admin", "tester");
        mainPage.open();

        //act
        var firstCourse = mainPage.getCourseCard(0);
        var secondCourse = mainPage.getCourseCard(1);

        var expectedFirstCourseTitle = firstCourse.getTitles();
        var expectedSecondCourseTitle = secondCourse.getTitles();

        firstCourse.add();
        secondCourse.add();

        var personalPage = mainPage.header.openPersonalPage();
        personalPage.delayedCoursesTab.click();



        //assert
        var actualFirstCourseTitle = personalPage.getCourseCard(0).getTitle();
        var actualSecondCourseTitle = personalPage.getCourseCard(1).getTitle();
        Assertions.assertAll(
                () -> Assertions.assertEquals(2, personalPage.courseCards.size(), "Неверное количество добавленных отложенных курсов"),
                () -> Assertions.assertEquals(expectedFirstCourseTitle, actualFirstCourseTitle, "Неверный заголовок у первого отложенного курса"),
                () -> Assertions.assertEquals(expectedSecondCourseTitle, actualSecondCourseTitle, "Неверный заголовок у второго отложенного курса"),
                () -> Assertions.assertFalse(actualFirstCourseTitle.equals(actualSecondCourseTitle), "Ошибочно были добавлены одинаковые курсы")
        );
    }

    @Test
    public void personalPage_AddSameCourse_Twice_Fail(){
        //arrange
        var authorizationPage = new AuthorizationPage(driver, wait);
        authorizationPage.open();
        var mainPage = authorizationPage.authorize("admin", "tester");
        mainPage.open();

        //act
        var firstCourse = mainPage.getCourseCard(0);
        var expectedTitle = firstCourse.getTitles();

        firstCourse.add();
        firstCourse.add();

        var personalPage = mainPage.header.openPersonalPage();
        personalPage.delayedCoursesTab.click();

        //assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(1, personalPage.courseCards.size(), "Должен быть только один курс"),
                () -> Assertions.assertEquals(expectedTitle, personalPage.getCourseCard(0).getTitle())
        );
    }

    @Test
    public void personalPage_EmptyDelayedCourses_ClickToCourseList_Success(){
        //arrange
        var authorizationPage = new AuthorizationPage(driver, wait);
        authorizationPage.open();
        var mainPage = authorizationPage.authorize("admin", "tester");
        mainPage.open();

        //act
        var personalPage = mainPage.header.openPersonalPage();
        personalPage.delayedCoursesTab.click();

        personalPage.backToCoursesButton.click();

        //assert
        Assertions.assertNotNull(mainPage.getCourseCard(7));
    }

    @Test
    public void headerPanel_Logout_Success() {
        //arrange
        var authorizationPage = new AuthorizationPage(driver, wait);
        authorizationPage.open();
        var mainPage = authorizationPage.authorize("admin", "tester");
        mainPage.open();

        //act
        mainPage.header.exitButton.click();

        //assert
        Assertions.assertTrue(driver.getCurrentUrl().contains("autorization1"));
    }

    @Test
    public void headerPanel_NavigateToPersonalPage_Success() {
        //arrange
        var authorizationPage = new AuthorizationPage(driver, wait);
        authorizationPage.open();
        var mainPage = authorizationPage.authorize("admin", "tester");
        mainPage.open();

        //act
        var personalPage = mainPage.header.openPersonalPage();

        //assert
        Assertions.assertTrue(driver.getCurrentUrl().contains("personal"));
    }

    @Test
    public void headerPanel_NavigateToMainPage_Success() {
        //arrange
        var authorizationPage = new AuthorizationPage(driver, wait);
        authorizationPage.open();
        var mainPage = authorizationPage.authorize("admin", "tester");
        mainPage.open();

        //act
        var personalPage = mainPage.header.openPersonalPage();
        personalPage.delayedCoursesTab.click();
        mainPage.header.openMainPage();

        //assert
        Assertions.assertTrue(driver.getCurrentUrl().contains("maincatalog"));
    }

    @Test
    public void personalPage_DelayedCourses_TabSwitch_Success() {
        //arrange
        var authorizationPage = new AuthorizationPage(driver, wait);
        authorizationPage.open();
        var mainPage = authorizationPage.authorize("admin", "tester");
        mainPage.open();

        //act
        var course = mainPage.getCourseCard(0);
        var expectedTitle = course.getTitles();
        course.add();
        var personalPage = mainPage.header.openPersonalPage();
        personalPage.delayedCoursesTab.click();

        //assert
        var actualTitle = personalPage.getCourseCard(0).getTitle();
        Assertions.assertEquals(expectedTitle, actualTitle);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void parametrized_AddSingleCourse_CheckAllParameters(int index) {
        //arrange
        var authorizationPage = new AuthorizationPage(driver, wait);
        authorizationPage.open();
        var mainPage = authorizationPage.authorize("admin", "tester");
        mainPage.open();

        //act
        var course = mainPage.getCourseCard(index);
        var expectedTitle = course.getTitles();
        var expectedStartDate = course.getStartDate();
        var expectedVideos = course.getVideosCount();
        var expectedLessons = course.getLessonsCount();
        var expectedDuration = course.getDuration();
        course.add();
        var personalPage = mainPage.header.openPersonalPage();
        personalPage.delayedCoursesTab.click();

        //assert
        var actualCourse = personalPage.getCourseCard(0);
        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedTitle, actualCourse.getTitle()),
                () -> Assertions.assertEquals(expectedStartDate, actualCourse.getStartDate()),
                () -> Assertions.assertEquals(expectedVideos, actualCourse.getVideosCount()),
                () -> Assertions.assertEquals(expectedLessons, actualCourse.getLessonsCount()),
                () -> Assertions.assertEquals(expectedDuration, actualCourse.getDuration()) );
    }

    @Test
    public void personalPage_CoursesNotSavedAfterLogout_Success() {
        //arrange
        var authorizationPage = new AuthorizationPage(driver, wait);
        authorizationPage.open();
        var mainPage = authorizationPage.authorize("admin", "tester");
        mainPage.open();

        //act
        var course = mainPage.getCourseCard(0);
        course.add();

        var personalPage = mainPage.header.openPersonalPage();
        personalPage.delayedCoursesTab.click();

        // выход
        mainPage.header.exitButton.click();

        // повторный вход
        authorizationPage = new AuthorizationPage(driver, wait);
        authorizationPage.open();
        mainPage = authorizationPage.authorize("admin", "tester");
        mainPage.open();

        personalPage = mainPage.header.openPersonalPage();
        personalPage.delayedCoursesTab.click();

        //assert
        Assertions.assertEquals(0, personalPage.courseCards.size(),
                "После выхода и повторного входа список отложенных курсов должен быть пустым");
    }
}

