package org.example.demon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ResultsPage {

    WebDriver driver;
    @FindBy(css = "#sb_form_q")
    private WebElement searchField;

    @FindBy(css = ":not(.b_adurl) > cite")
    private List <WebElement> results;

    public void clickElement(int num) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector(":not(.b_adurl) > cite"))
        );
        results.get(num).click();
        System.out.println("Нажатие на результат под номером " + num);

        ArrayList tabs = new ArrayList<> (driver.getWindowHandles());
        if (tabs.size() > 1) driver.switchTo().window(tabs.get(1).toString());
    }

    public String getTextFromSearchField(){
        String val = searchField.getAttribute("value");
        System.out.println("В строке поиска текст: " + val);
        return val;
    }

    public ResultsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

