package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminMasterUser {
    private WebDriver driver;
    private By userdisplay = new By.ById("userDisplay");
    private By navtitle = new By.ByXPath("//*[@id=\"navbar-collapse\"]/h1");
//    private By usertable = new By.ById("userTableBody");
    private By adduserbutton = new By.ById("openAddUserBtn");
    private By namefield = new By.ById("userName");
    private By usernamefield = new By.ById("userUsername");
    private By passwordfield = new By.ById("userPassword");
    private By roledropdown = new By.ById("branchSelect");
    private By adminoption = new By.ByXPath("//*[@id=\"branchSelect\"]/option[1]");
    private By addsubmitbutton = new By.ById("submitUserBtn");
    private By message = new By.ByXPath("/html/body/div[1]/div[1]/div/div[1]");
    public AdminMasterUser(WebDriver d) {
        this.driver = d;
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

    public void pressAddUser() {
        driver.findElement(adduserbutton).click();
    }

    public void inputName(String name) {
        driver.findElement(namefield).sendKeys(name);
    }

    public void inputUsername(String s) {
        driver.findElement(usernamefield).sendKeys(s);
    }

    public void inputPassword(String s) {
        driver.findElement(passwordfield).sendKeys(s);
    }

    public void selectRoleAdmin() {
        driver.findElement(roledropdown).click();
        driver.findElement(adminoption).click();

    }

    public void submitUser() {
        driver.findElement(addsubmitbutton).click();
    }

    public String getMessage() {
        return driver.findElement(message).getText();
    }

}
