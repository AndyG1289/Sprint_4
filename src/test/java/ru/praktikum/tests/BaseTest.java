package ru.praktikum.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    protected WebDriver driver;

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome"); // по умолчанию chrome

        switch (browser.toLowerCase()) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
            default:
                driver = new ChromeDriver();
                break;
        }

        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
