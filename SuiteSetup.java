package utility;

import DriverRepo.ConfigDriver;
import constants.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class SuiteSetup extends Constants {
    protected WebDriver driver;
    protected String baseUrl;
    public static Logger logger;

    @Parameters({"Browser"})
    @BeforeSuite
    public void setup(@Optional("chrome")String browser) {
        logger = LogManager.getLogger(this.getClass());
        ConfigDriver.setDriver(browser);
        baseUrl = GenericMethods.readPropertiesFile().getProperty("url");
        ConfigDriver.getDriver().get(baseUrl);

//        driver = ConfigDriver.getDriver();
        initializePages();
//        GenericMethods.launchUrl(GenericMethods.readPropertiesFile().getProperty("url"));
    }

    private void initializePages() {
       login = ObjectRepo.innitilizeLoginPage();
       homePage = ObjectRepo.innitilizeHomePage();
       registerPage = ObjectRepo.initializeRegisterPage();
    }


    @AfterSuite
    public void quit() {
        ConfigDriver.tearDown();
    }
}
