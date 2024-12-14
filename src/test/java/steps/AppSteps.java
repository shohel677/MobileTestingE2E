package steps;

import abstractComponents.WaitUtill;
import pageObject.CardSwipeScreen;
import utils.Assertions;
import pageObject.PuzzleScreen;
import pageObject.HomeScreen;
import pageObject.LoginScreen;

public class AppSteps {
    HomeScreen homeScreen = new HomeScreen();
    LoginScreen loginScreen = new LoginScreen();
    PuzzleScreen puzzleScreen = new PuzzleScreen();
    CardSwipeScreen cardSwipeScreen = new CardSwipeScreen();

    public void openHomeScreen(){
        Assertions.shouldBeTrue(homeScreen.isHomePageOpened(), "Home screen is opened", "Home screen is not opened");
    }
    public void openDragAndDropScreen(){
        Assertions.shouldBeTrue(puzzleScreen.isPuzzleScreen(), "Puzzle screen is opened", "Puzzle screen is not opened");
    }
    public void dragAndDropPuzzle(){
        puzzleScreen.dragAndDropPuzzlePieces();
        Assertions.shouldBeTrue(puzzleScreen.isPuzzleCompleteConfirmationDisplayed(), "Puzzle drag and drop complete", "Puzzle drag and drop is not complete");
    }
    public void retryPuzzle(){
        Assertions.shouldBeTrue(puzzleScreen.clickRetryButton(), "Drag and drop screen is opened", "Drag and drop screen is not opened");
    }
    public void openSwipeScreen(){
        Assertions.shouldBeTrue(cardSwipeScreen.isSwipeScreenOpen(), "Swipe screen is opened", "Swipe screen is not opened");
        WaitUtill.waitFor(2000);
    }
    public void checkCommunityCard(){
        Assertions.shouldBeTrue(cardSwipeScreen.isGreatCommunityCardVisible(), "Community card is displayed", "Community card is not displayed");
    }
    public void loginToApplication(){
        Assertions.shouldBeTrue(loginScreen.isLoginScreen(),"Application login screen is opened", "Application login screen is not opened");
        loginScreen.openCountryDropdown();
        loginScreen.enterName();
        loginScreen.clickLetsShopButton();
        Assertions.shouldBeTrue(homeScreen.isHomePageOpened(), "Login is successful and home page is opened", "Login is not successful and home page is not opened");

    }
}
