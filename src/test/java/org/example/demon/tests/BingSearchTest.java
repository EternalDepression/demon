package org.example.demon.tests;

import org.example.demon.pages.MainPage;
import org.example.demon.pages.ResultsPage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BingSearchTest {

    String input = "Selenium";
    private WebDriver driver;
    MainPage mp;
    ResultsPage rp;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bing.com/");
        mp = new MainPage(driver);
        rp = new ResultsPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void searchResultsTest() {
        mp.sendText(input);
        rp.clickElement(0);
        assertEquals("https://www.selenium.dev/", driver.getCurrentUrl(), "Неверный результат");
    }

    @Test
    public void searchFieldTest() {
        mp.sendText(input);
        assertEquals(input, rp.getTextFromSearchField(), "Текст не совпал");
    }
}
