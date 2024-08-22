package org.example.demon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ResultsPage {


    @FindBy(css = "#sb_form_q")
    private WebElement searchField;

    @FindBy(css = ":not(.b_adurl) > cite")
    private List <WebElement> results;


    public void clickElement(int num) {
        results.get(num).click();
        System.out.println("Нажатие на результат под номером " + num);
    }

    public String getTextFromSearchField(){
        String val = searchField.getAttribute("value");
        System.out.println("В строке поиска текст: " + val);
        return val;
    }

    public ResultsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}

