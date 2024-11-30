package testComponents;

import abstractComponents.AbstractComponents;
import abstractComponents.GenericApp;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;

public class BaseTest {
    @BeforeMethod
    public void appInitialize() {

        GenericApp.instanceApplication();
    }

    @AfterMethod(alwaysRun = true)
    public void appClose(){
        GenericApp.tearDown();
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
