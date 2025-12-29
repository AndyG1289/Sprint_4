package ru.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // ======== ЛОКАТОРЫ ========

    // Верхняя кнопка "Заказать"
    private final By orderTopButton =
            By.xpath("//div[contains(@class, 'Header_Nav')]/button[text()='Заказать']");

    // Нижняя кнопка "Заказать"
    private final By orderBottomButton =
            By.xpath("//div[contains(@class, 'Home_FinishButton')]/button[text()='Заказать']");

    // FAQ
    private final String faqQuestionPattern = "//div[@id='accordion__heading-%d']";
    private final String faqAnswerPattern = "//div[@id='accordion__panel-%d']/p";

    // ======== КОНСТРУКТОР ========

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ======== МЕТОДЫ ========

    public void clickOrderTopButton() {
        driver.findElement(orderTopButton).click();
    }

    public void clickOrderBottomButton() {
        driver.findElement(orderBottomButton).click();
    }

    // Открыть вопрос FAQ
    public void openFaqQuestion(int index) {
        By question = By.xpath(String.format(faqQuestionPattern, index));
        wait.until(ExpectedConditions.elementToBeClickable(question));
        driver.findElement(question).click();
    }

    // Получить текст ответа FAQ
    public String getFaqAnswerText(int index) {
        By answer = By.xpath(String.format(faqAnswerPattern, index));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(answer)).getText();
    }
}
