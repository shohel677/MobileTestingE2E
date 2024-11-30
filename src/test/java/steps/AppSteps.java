package steps;

import Utils.Assertions;
import pageObject.HomeScreen;

public class AppSteps {
    HomeScreen homeScreen = new HomeScreen();

    public void homeScreenIsOpen(){

        Assertions.shouldBeTrue(homeScreen.isAppHomeScreen(),"Application home page is opened", "Application page is not opened");
    }
    public void selectCountry(){

        homeScreen.openCountryDropdown();
    }
}
