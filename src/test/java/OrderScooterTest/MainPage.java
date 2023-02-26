package OrderScooterTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    // Заголовок страницы
    private By headTitle = By.className("Home_Header__iJKdX");
    // Логотип (хедер)
    private By logo = By.className("Header_Logo__23yGT");
    // Заказать (хедер)
    private By orderUpButton = By.className("Button_Button__ra12g");
    // заказать (внизу стр)
    private By orderDownButton = By.className("Button_Button__ra12g Button_Middle__1CSJM");
    // статус заказа (хедер)
    private By statusOfOrder = By.className("Header_Link__1TAG7");

    public void goToCheckoutPage(){
        driver.findElement(orderUpButton).click();
    }
    public MainPage (WebDriver driver){
        this.driver = driver;
    }

}
