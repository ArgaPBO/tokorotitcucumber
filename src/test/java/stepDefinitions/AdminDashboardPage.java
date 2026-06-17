package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminDashboardPage {
    private WebDriver driver;
    private By userdisplay = new By.ById("userDisplay");
    private By navtitle = new By.ByXPath("//*[@id=\"navbar-collapse\"]/h1");
//    private By errormessage = new By.ByXPath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3/text()");
    public AdminDashboardPage(WebDriver d) {
        this.driver = d;
    }

    public By getUserdisplay() {
        return this.userdisplay;
    }


//    public String getErrorMessage() {
//        return driver.findElement(errormessage).getText();
//    }

    public String getDisplayName() {
        return driver.findElement(userdisplay).getText();
    }

    public String getNavTitle() {
        return driver.findElement(navtitle).getText();
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }



}
