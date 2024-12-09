package steps;

import Utils.Assertions;
import pageObject.PuzzleScreen;
import pageObject.HomeScreen;
import pageObject.LoginScreen;

public class AppSteps {
    HomeScreen homeScreen = new HomeScreen();
    LoginScreen loginScreen = new LoginScreen();
    PuzzleScreen dragAndDropScreen = new PuzzleScreen();

    public void openHomeScreen(){
        Assertions.shouldBeTrue(homeScreen.isHomePageOpened(), "Home screen is opened", "Home screen is not opened");
    }
    public void openDragAndDropScreen(){
        Assertions.shouldBeTrue(dragAndDropScreen.isDragAndDropScreen(), "Drag and drop screen is opened", "Drag and drop screen is not opened");
    }
    public void dragAndDropPuzzle(){
       dragAndDropScreen.dragAndDropPuzzlePieces();
        Assertions.shouldBeTrue(dragAndDropScreen.isPuzzleCompleteConfirmationDisplayed(), "Puzzle drag and drop complete", "Puzzle drag and drop is not complete");

    }
    public void retryPuzzle(){
        Assertions.shouldBeTrue(dragAndDropScreen.clickRetryButton(), "Drag and drop screen is opened", "Drag and drop screen is not opened");
    }
    public void loginToApplication(){
        Assertions.shouldBeTrue(loginScreen.isLoginScreen(),"Application login screen is opened", "Application login screen is not opened");
        loginScreen.openCountryDropdown();
        loginScreen.enterName();
        loginScreen.clickLetsShopButton();
        Assertions.shouldBeTrue(homeScreen.isHomePageOpened(), "Login is successful and home page is opened", "Login is not successful and home page is not opened");

    }
}
