package utility;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Base64;

public class TestLogger {
    private static Scenario scenario;
    private static WebDriver driver;

    public static void initScenario(Scenario s) {
        scenario = s;
    }

    public static void setDriver(WebDriver d) {
        driver = d;
    }

    // Manually log the information to Extent Reports
    public static void log(String message) {
        if (scenario != null) {
            scenario.log(message);
        } else {
            System.out.println("[WARN] Scenario is null. Log skipped: " + message);
        }
    }

    // Takes screenshot and upload to Extent reports
    public static void screenshot(String label) {
        if (driver == null || scenario == null) {
            System.out.println("[WARN] Screenshot skipped. Driver or Scenario not initialized.");
            return;
        }

        try {
            byte[] image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            String base64 = Base64.getEncoder().encodeToString(image);
            String html = "<br>" + label + "<br><img src='data:image/png;base64," + base64 + "' height='300'/>";
            scenario.log(html);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
