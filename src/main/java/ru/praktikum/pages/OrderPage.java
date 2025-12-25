package ru.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private WebDriver driver;

    // ======== ЛОКАТОРЫ ========

    private final By firstNameField = By.xpath("//input[@placeholder='* Имя']");
    private final By lastNameField = By.xpath("//input[@placeholder='* Фамилия']");
    private final By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroStationField = By.xpath("//input[@placeholder='* Станция метро']");
    private final By phoneField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.xpath("//button[text()='Далее']");

    private final By dateField = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final By rentalPeriodDropdown = By.className("Dropdown-control");
    private final By blackColorCheckbox = By.id("black");
    private final By greyColorCheckbox = By.id("grey");
    private final By commentField = By.xpath("//input[@placeholder='Комментарий для курьера']");
    private final By orderButton = By.xpath("//button[text()='Заказать']");
    private final By confirmButton = By.xpath("//button[text()='Да']");

    private final By successModal = By.xpath("//div[contains(text(),'Заказ оформлен')]");

    // ======== КОНСТРУКТОР ========
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // ======== МЕТОДЫ ========

    public void fillOrderForm(String name, String surname, String address, String metro, String phone) {
        driver.findElement(firstNameField).sendKeys(name);
        driver.findElement(lastNameField).sendKeys(surname);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(metroStationField).sendKeys(metro);
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(nextButton).click();
    }

    public void fillAboutRent(String date, String period, boolean black, boolean grey, String comment) {
        driver.findElement(dateField).sendKeys(date);
        driver.findElement(rentalPeriodDropdown).click();
        driver.findElement(By.xpath(String.format("//div[@class='Dropdown-option' and text()='%s']", period))).click();
        if (black) driver.findElement(blackColorCheckbox).click();
        if (grey) driver.findElement(greyColorCheckbox).click();
        driver.findElement(commentField).sendKeys(comment);
        driver.findElement(orderButton).click();
        driver.findElement(confirmButton).click();
    }

    public boolean isOrderSuccessful() {
        return driver.findElements(successModal).size() > 0;
    }
}
