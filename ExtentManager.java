package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    public static ExtentReports extentReports;
    public static ExtentSparkReporter extentSparkReporter;

    public static ExtentReports ConfigureExtentReport() {
        if (extentReports == null) {

            extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports");
            extentSparkReporter.config().setReportName("Automation Report");
            extentSparkReporter.config().setDocumentTitle("Test Results");

            extentReports = new ExtentReports();
            extentReports.attachReporter(extentSparkReporter);
            extentReports.setSystemInfo("SDET", "Piyush");
        }

        return extentReports;
    }
}


