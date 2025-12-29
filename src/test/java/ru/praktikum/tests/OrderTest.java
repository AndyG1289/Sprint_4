package ru.praktikum.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.pages.MainPage;
import ru.praktikum.pages.OrderPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {

    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;
    private final String date;
    private final String period;
    private final boolean black;
    private final boolean grey;
    private final String comment;

    public OrderTest(String name, String surname, String address, String metro, String phone,
                     String date, String period, boolean black, boolean grey, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.period = period;
        this.black = black;
        this.grey = grey;
        this.comment = comment;
    }

    @Parameterized.Parameters(name = "Заказ: {0} {1}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Иван", "Иванов", "Москва, ул. Пушкина", "Черкизовская",
                        "+79991234567", "30.10.2025", "двое суток", true, false, "Позвоните заранее"},
                {"Анна", "Петрова", "Москва, ул. Ленина", "Курская",
                        "+79997654321", "01.11.2025", "сутки", false, true, "Без звонка"}
        };
    }

    @Test
    public void testOrderFromTopButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOrderTopButton();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillOrderForm(name, surname, address, metro, phone);
        orderPage.fillAboutRent(date, period, black, grey, comment);

        assertTrue("Заказ не был оформлен через верхнюю кнопку", orderPage.isOrderSuccessful());
    }

    @Test
    public void testOrderFromBottomButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOrderBottomButton();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillOrderForm(name, surname, address, metro, phone);
        orderPage.fillAboutRent(date, period, black, grey, comment);

        assertTrue("Заказ не был оформлен через нижнюю кнопку", orderPage.isOrderSuccessful());
    }
}
