package Hooks;

import context.World;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
            options.addArguments("headless");
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