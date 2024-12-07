package testCases;

import steps.AppSteps;
import testComponents.BaseTest;
import org.testng.annotations.Test;

public class StandAloneTest extends BaseTest {

    AppSteps  appSteps = new AppSteps();


    @Test
    public void appiumTest() {
        appSteps.loginToApplication();
    }

}
