package testCases;

import org.testng.annotations.Test;
import steps.AppSteps;
import testComponents.BaseTest;

public class AppTest extends BaseTest {
    AppSteps appSteps = new AppSteps();


    @Test(description = "As a user, I want to see the home screen is loaded")
    public void testToCheckHomeScreen() {
        appSteps.openHomeScreen();
    }
    @Test(description = "As a user, I want to see the puzzle screen is loaded")
    public void testToCheckPuzzleScreen() {
        appSteps.openHomeScreen();
        appSteps.openDragAndDropScreen();
    }
    @Test(description = "As a user, I want to solve the puzzle")
    public void testToSolveThePuzzle() {
        appSteps.openHomeScreen();
        appSteps.openDragAndDropScreen();
        appSteps.dragAndDropPuzzle();
    }
    @Test(description = "As a user, I want to retry puzzle after solve the puzzle")
    public void testToCheckPuzzleRetryButtonAfterSolveThePuzzle() {
        appSteps.openHomeScreen();
        appSteps.openDragAndDropScreen();
        appSteps.dragAndDropPuzzle();
        appSteps.retryPuzzle();
    }
    @Test(description = "As a user, I want to card to left")
    public void testToSwipeCard() {
        appSteps.openSwipeScreen();
        appSteps.checkCommunityCard();
    }
}
