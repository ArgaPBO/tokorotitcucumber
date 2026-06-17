package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By usernamefield = new By.ById("username");
    private By passwordfield = new By.ById("password");
    private By submitbutton = new By.ByXPath("/html/body/div[1]/div/form/button");
//    private By errormessage = new By.ByXPath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3/text()");
    public LoginPage(WebDriver d) {
        this.driver = d;
    }

    public void setUsername(String s) {
        driver.findElement(usernamefield).sendKeys(s);
    }

    public void setPassword(String s) {
        driver.findElement(passwordfield).sendKeys(s);
    }
    public void submit() {
        driver.findElement(submitbutton).click();
    }
//    public String getErrorMessage() {
//        return driver.findElement(errormessage).getText();
//    }
    public String getURL() {
        return driver.getCurrentUrl();
    }



}
