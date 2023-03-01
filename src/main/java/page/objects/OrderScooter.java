package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrderScooter {
    private final WebDriver driver;
    private final By ORDER_HEADER = By.className("Order_Header__BZXOb");
    private final By NAME_FIELD = By.xpath(".//input[@placeholder = '* Имя']");
    private final By LAST_NAME_FIELD = By.xpath(".//input[@placeholder = '* Фамилия']");
    private final By ADDRESS_FIELD = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    private final By PHONE_FIELD = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    private final By METRO_FIELD = By.xpath(".//input[@placeholder = '* Станция метро']");
    private final By NEXT_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By COOKIE_WINDOW = By.xpath(".//div[@class='App_CookieConsent__1yUIN']");
    private final By SEND_A_DATE = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By ORDER_COUNT_DATE = By.xpath(".//div[@class='Dropdown-placeholder']");
    private final By ORDER_COLOUR = By.id("black");
    private final By COMMENT = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By ORDER_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By ORDER_UP_BUTTON = By.className("Button_Button__ra12g");
    private final By COMPLETE_ORDER = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By IS_ORDER_SUCCESS = By.className("Order_ModalHeader__3FDaJ");

    public OrderScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void goToCheckoutPage() {
        driver.findElement(ORDER_UP_BUTTON).click();
    }

    public void waitForLoadingPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(ORDER_HEADER));
    }

    public void fillNameField(String name) {
        driver.findElement(NAME_FIELD).sendKeys(name);
    }

    public void fillLastNameField(String lastName) {
        driver.findElement(LAST_NAME_FIELD).sendKeys(lastName);
    }

    public void fillAddressField(String address) {
        driver.findElement(ADDRESS_FIELD).sendKeys(address);
    }

    public void fillPhoneField(String phone) {
        driver.findElement(PHONE_FIELD).sendKeys(phone);
    }

    public void inputOrderMetro(int n) {
        driver.findElement(METRO_FIELD).click();
        for (int i = 0; i < n; i++) {
            driver.findElement(METRO_FIELD).sendKeys(Keys.DOWN);
        }
        driver.findElement(METRO_FIELD).sendKeys(Keys.ENTER);
    }

    public void clickOnNextButton() {
        driver.findElement(NEXT_BUTTON).click();
    }

    public void closeCookieWindow() {
        if (driver.findElement(COOKIE_WINDOW).isDisplayed()) {
            driver.findElement(By.className("App_CookieButton__3cvqF")).click();
        }
    }

    public void inputFirstOrderPageAndGo(String name, String lastName, String address, String phone) {
        waitForLoadingPage();
        fillNameField(name);
        fillLastNameField(lastName);
        fillAddressField(address);
        fillPhoneField(phone);
        inputOrderMetro(8);
        closeCookieWindow();
        clickOnNextButton();
    }

    public void fillSendDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy"); // готовим нужный форматтер
        String date = LocalDate.now().plusDays(2).format(formatter); // получаем текущую дату, прибавляем к ней 2 дня и форматируем
        driver.findElement(SEND_A_DATE).sendKeys(date);
        driver.findElement(SEND_A_DATE).sendKeys(Keys.ENTER);
    }

    public void fillOrderCountDate() {
        driver.findElement(ORDER_COUNT_DATE).click();
        driver.findElement(By.xpath(".//div[@class='Dropdown-menu']/div[2]")).click();
    }

    public void fillOrderColour() {
        driver.findElement(ORDER_COLOUR).click();
    }

    public void fillComment(String text) {
        driver.findElement(COMMENT).sendKeys(text);
    }

    public void clickOnOrderButton() {
        driver.findElement(ORDER_BUTTON).click();
    }

    public void orderScooter(String comment) {
        fillSendDate();
        fillOrderCountDate();
        fillOrderColour();
        fillComment(comment);
        clickOnOrderButton();
    }

    public void clickOnCompleteOrderButton() {
        driver.findElement(COMPLETE_ORDER).click();
    }

    public boolean isOrderSuccess() {
        return driver.findElement(IS_ORDER_SUCCESS).isDisplayed();
    }

}
