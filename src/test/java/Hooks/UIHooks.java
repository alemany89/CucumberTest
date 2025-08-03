package Hooks;

import context.World;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class UIHooks {

    private final World world;

    public UIHooks(World world) {
        this.world = world;
    }

    @Before("@ui")
    public void setupAll() {
        ChromeOptions options = getHeadlessMode(true);
        this.world.driver = new ChromeDriver(options);
    }

    private ChromeOptions getHeadlessMode(boolean headlessMode) {
        ChromeOptions options = new ChromeOptions();

        if (headlessMode) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            try {
                Path tempProfile = Files.createTempDirectory("chrome-profile");
                options.addArguments("--user-data-dir=" + tempProfile.toAbsolutePath().toString());
            } catch (IOException e) {
                throw new RuntimeException("No se pudo crear el directorio temporal para Chrome", e);
            }
        } else {
            options.addArguments("--start-maximized");
        }

        return options;
    }

    @After("@ui")
    public void tearDown() {
        if (this.world.driver != null) {
            this.world.driver.quit();
        }
    }
}