package ru.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    // ======== ЛОКАТОРЫ ========

    // Верхняя кнопка "Заказать"
    private final By orderTopButton = By.xpath("//div[contains(@class, 'Header_Nav')]/button[text()='Заказать']");

    // Нижняя кнопка "Заказать"
    private final By orderBottomButton = By.xpath("//div[contains(@class, 'Home_FinishButton')]/button[text()='Заказать']");

    // Вопросы в блоке FAQ
    private final String faqQuestionPattern = "//div[@id='accordion__heading-%d']";
    // Ответы в блоке FAQ
    private final String faqAnswerPattern = "//div[@id='accordion__panel-%d']/p";

    // ======== КОНСТРУКТОР ========
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // ======== МЕТОДЫ ========

    public void clickOrderTopButton() {
        driver.findElement(orderTopButton).click();
    }

    public void clickOrderBottomButton() {
        driver.findElement(orderBottomButton).click();
    }

    // Клик по вопросу FAQ по индексу
    public void clickFaqQuestion(int index) {
        driver.findElement(By.xpath(String.format(faqQuestionPattern, index))).click();
    }

    // Получить текст ответа по индексу
    public String getFaqAnswerText(int index) {
        return driver.findElement(By.xpath(String.format(faqAnswerPattern, index))).getText();
    }
}
