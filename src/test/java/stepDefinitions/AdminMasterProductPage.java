package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static stepDefinitions.RandomStringGenerator.randomString;

public class AdminMasterProductPage {
    private WebDriver driver;
    private By userdisplay = new By.ById("userDisplay");
    private By navtitle = new By.ByXPath("//*[@id=\"navbar-collapse\"]/h1");
//    private By usertable = new By.ById("userTableBody");
    private By addproductbutton = new By.ByXPath("/html/body/div[1]/div[1]/div/div/div[1]/div[1]/div[1]/div[2]/button");
    private By namefield = new By.ById("addProductName");
    private By pricefield = new By.ById("addProductPrice");
    private By addsubmitbutton = new By.ById("saveProductBtn");
    private By message = new By.ByXPath("/html/body/div[1]/div[1]/div/div[contains(@class, 'alert')]");
    public AdminMasterProductPage(WebDriver d) {
        this.driver = d;
    }


    public By getUserdisplay() {
        return this.userdisplay;
    }


    public By getMessageby() {
        return this.message;
    }

    public String getDisplayName() {
        return driver.findElement(userdisplay).getText();
    }

    public String getNavTitle() {
        return driver.findElement(navtitle).getText();
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public void pressAddProduct() {
        driver.findElement(addproductbutton).click();
    }

    public void inputName(String name) {
        driver.findElement(namefield).sendKeys(name);
    }

    public void inputName() {
        inputName(randomString(10));
    }

    public void inputPrice(String price) {
        driver.findElement(pricefield).sendKeys(price);
    }

    public void inputPrice() {
        inputPrice("10000");
    }

    public void submitProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(
                ExpectedConditions.elementToBeClickable(addsubmitbutton)
        ).click();
    }

    public String getMessage() {
        return driver.findElement(message).getText();
    }

}
