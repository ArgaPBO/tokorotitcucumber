package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private WebDriver driver;
    private By productstext = new By.ByXPath("//*[contains(text(), 'Products')]");
    public ProductPage(WebDriver d) {
        this.driver = d;
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public Boolean isProductsDisplayed() {
        return driver.findElement(productstext).isDisplayed();
    }




}
