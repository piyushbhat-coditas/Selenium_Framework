package utility;

import DriverRepo.ConfigDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String captureScreenshot(String testName) {

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        String relativePath = "../../screenshots/" + testName + "_" + timestamp + ".png";
        String fullPath = System.getProperty("user.dir") + "/" + relativePath;

        TakesScreenshot ts = (TakesScreenshot) ConfigDriver.getDriver();
        return ts.getScreenshotAs(OutputType.BASE64);

    }

    public static String captureScreenshotBase64() {

        TakesScreenshot ts = (TakesScreenshot) ConfigDriver.getDriver();
        return ts.getScreenshotAs(OutputType.BASE64);
    }
}
