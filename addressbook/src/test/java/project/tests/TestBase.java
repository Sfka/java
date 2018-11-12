package project.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import project.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;



public class TestBase {

    protected static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite //suite (vsegda odin) - test - class - method
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite
    public void tearDown() throws Exception {
        app.stop();
    }

}
