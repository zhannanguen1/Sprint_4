package order.scooter.test;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import page.objects.OrderScooter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class PraktikumEndToEndTest {
    private final String name;
    private final String lastName;
    private final String address;
    private final String phone;
    private final String comment;
    private WebDriver driver;

    public PraktikumEndToEndTest(String name, String lastName, String address, String phone, String comment) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.comment = comment;
    }

    @Parameterized.Parameters(name = "Данные для ввода в форму заказа: {0} {1} {2} {3} {4}")
    public static Object[][] testData() {
        return new Object[][]{{"Гарри", "Поттер", "Хогвартс", "89267374774", ""},
                {"Рон", "Уизли", "Дом Нора", "00777777777", "Домофон не работает"},
                {"Северус", "Снейп", "Улица", "12347777789", "12321"}};
    }

    @Test
    public void orderAScooterTest() {
        System.setProperty("webdriver.gecko.driver", "C:/Users/User/Downloads/geckodriver-v0.32.2-win32/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        OrderScooter objOrderScooter = new OrderScooter(driver);
        objOrderScooter.goToCheckoutPage();
        objOrderScooter.inputFirstOrderPageAndGo(name, lastName, address, phone);
        objOrderScooter.orderScooter(comment);
        objOrderScooter.clickOnCompleteOrderButton();
        boolean actual = objOrderScooter.isOrderSuccess();
        assertTrue("Заказ не оформлен", actual);
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
