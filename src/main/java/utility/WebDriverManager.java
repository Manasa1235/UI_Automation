
package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public class WebDriverManager {

    // Create the driver
    // Based on Input chrome or firefox browser is selected, if nothing selected by default chrome is used
    // If any preferences to chrome or firefox can be set in this method
    // Also can set headless mode true or false
    public static WebDriver getDriver() {
        String browser = System.getProperty("browser", System.getenv().getOrDefault("BROWSER", "chrome"));
        boolean headless = Boolean.parseBoolean(System.getProperty("headless",
                System.getenv().getOrDefault("HEADLESS", "false")));

        WebDriver driver;

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();

            // Custom preferances for Chrome
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);

            // Incognito and headless options
            options.addArguments("--incognito");
            if (headless) {
                options.addArguments("--headless=new");
                options.addArguments("--disable-gpu");
            }
            options.addArguments("--window-size=1920,1080");

            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            if (headless) {
                options.addArguments("--headless");
            }
            options.addArguments("-private");
            options.addArguments("--width=1920");
            options.addArguments("--height=1080");

            driver = new FirefoxDriver(options);
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        //Logging support
        TestLogger.setDriver(driver);
        return driver;
    }
}
