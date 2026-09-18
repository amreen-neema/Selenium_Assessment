package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class baseclass {

    protected WebDriver driver;
    protected Properties p;

    @BeforeClass
    public void openBrowser() throws IOException {

        // Read property file
        FileInputStream fis =
                new FileInputStream(
                        "./src/test/resources/DDT/config.properties");

        p = new Properties();

        p.load(fis);

        String browser =
                p.getProperty("browser");


        // ==========================================
        // CHROME
        // ==========================================

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options =
                    new ChromeOptions();

            // Disable Chrome password manager
            options.addArguments(
                    "--disable-notifications");

            options.addArguments(
                    "--disable-save-password-bubble");

            // Disable password leak detection popup
            Map<String, Object> prefs =
                    new HashMap<>();

            prefs.put(
                    "credentials_enable_service",
                    false);

            prefs.put(
                    "profile.password_manager_enabled",
                    false);

            prefs.put(
                    "profile.password_manager_leak_detection",
                    false);

            options.setExperimentalOption(
                    "prefs",
                    prefs);


            driver =
                    new ChromeDriver(options);
        }


        // ==========================================
        // EDGE
        // ==========================================

        else if (browser.equalsIgnoreCase("edge")) {

            driver =
                    new EdgeDriver();
        }


        // ==========================================
        // INVALID BROWSER
        // ==========================================

        else {

            throw new RuntimeException(
                    "Invalid browser name");
        }


        // ==========================================
        // BROWSER SETTINGS
        // ==========================================

        driver.manage()
                .window()
                .maximize();

        driver.get(
                p.getProperty("url"));

        fis.close();
    }


    // ==========================================
    // CLOSE BROWSER
    // ==========================================

    @AfterClass
    public void closeBrowser() {

        if (driver != null) {

            driver.quit();
        }
    }
}