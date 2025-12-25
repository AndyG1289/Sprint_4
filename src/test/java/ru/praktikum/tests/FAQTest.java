package ru.praktikum.tests;

import org.junit.Test;
import ru.praktikum.pages.MainPage;

import static org.junit.Assert.assertTrue;

public class FAQTest extends BaseTest {

    @Test
    public void checkFaqAnswers() {
        MainPage mainPage = new MainPage(driver);

        for (int i = 0; i <= 7; i++) {
            mainPage.clickFaqQuestion(i);
            String answer = mainPage.getFaqAnswerText(i);
            assertTrue("Ответ не отображается для вопроса " + i, answer != null && !answer.isEmpty());
        }
    }
}