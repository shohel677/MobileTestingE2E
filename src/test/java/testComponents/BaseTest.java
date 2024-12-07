package testComponents;

import abstractComponents.GenericApp;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;

import static abstractComponents.GenericApp.logger;

public class BaseTest {
    @BeforeMethod
    public void appInitialize(ITestResult result) {
        String testMethod = result.getMethod().getMethodName();

        logger.info("------------- Start of Testcase: '"+testMethod+"' -----------------");
        GenericApp.instanceMobileDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void appClose(ITestResult result){
        int status = result.getStatus();
        String testDescription = result.getMethod().getDescription();
        String testMethod = result.getMethod().getMethodName();

        if (status == ITestResult.SUCCESS) {
            logger.info("'" + testDescription + "' is successfully passed");
        } else if (status == ITestResult.FAILURE) {
            logger.info("'" + testDescription + "' failed");
        } else if (status == ITestResult.SKIP) {
            logger.info("'" + testDescription + "' is skipped");
        }


        logger.info("------------- End of Testcase: '"+testMethod+"' -----------------");
        GenericApp.mobileTearDown();
    }
    @BeforeSuite
    public void cleanUpDirectories() {
        cleanFolder("D:\\AppiumMobileAutomation\\reports\\logs");
        cleanFolder("D:\\AppiumMobileAutomation\\reports\\report");
    }

    private void cleanFolder(String folderPath) {
        File folder = new File(folderPath);
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        if (!file.delete()) {
                            System.err.println("Failed to delete file: " + file.getAbsolutePath());
                        }
                    } else if (file.isDirectory()) {
                        cleanFolder(file.getAbsolutePath()); // Recursive call for subdirectories
                        if (!file.delete()) {
                            System.err.println("Failed to delete directory: " + file.getAbsolutePath());
                        }
                    }
                }
            }
        } else {
            System.out.println("Folder does not exist or is not a directory: " + folderPath);
        }
    }
}
