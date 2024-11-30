package Utils;

import abstractComponents.GenericApp;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class Assertions extends GenericApp {

    private static final List<AssertionInfo> assertions = new ArrayList<>();

    private static void assertionPassMessage(String message){
        logger.info("Step: {}" ,message);

    }
    private static void assertionFailMessage(String message){
        logger.info("Fail: {}" ,message);

    }
    public static void shouldBeTrue(boolean condition, String message) {
        if(condition){
            assertions.add(new AssertionInfo(true, message));
            Assert.assertTrue(true, message);
            assertionPassMessage(message);
        }
        else{
            assertions.add(new AssertionInfo(false, message));
            assertionFailMessage(message);
            Assert.fail(message);

        }
    }
    public static void shouldBeTrue(boolean condition, String expected, String actual) {
        if(condition){
            assertions.add(new AssertionInfo(true, expected));
            Assert.assertTrue(true, expected);
            assertionPassMessage(expected);
        }
        else{
            assertions.add(new AssertionInfo(false, actual));
            assertionFailMessage(actual);
            Assert.fail(actual);
        }

    }

    public static List<AssertionInfo> getAllAssertions() {
        return assertions;
    }

    public static class AssertionInfo {
        private final boolean status;
        private final String message;

        public AssertionInfo(boolean status, String message) {
            this.status = status;
            this.message = message;
        }

        public boolean getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }
    }
}
