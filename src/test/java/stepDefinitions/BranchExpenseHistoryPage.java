package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BranchExpenseHistoryPage {
    private WebDriver driver;
    private By userdisplay = new By.ById("userDisplay");
//    private By navtitle = new By.ByXPath("//*[@id=\"navbar-collapse\"]/h1");
//    private By usertable = new By.ById("userTableBody");
    private By addexpensebutton = new By.ByXPath("/html/body/div[1]/div[1]/div/div/div[1]/div[1]/div[1]/button[1]");
    private By addsubmitbutton = new By.ById("submitExpenseBtn");
    private By message = new By.ByXPath("/html/body/div[1]/div[1]/div/div[contains(@class, 'alert')]");
    public BranchExpenseHistoryPage(WebDriver d) {
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

//    public String getNavTitle() {
//        return driver.findElement(navtitle).getText();
//    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public void pressAddExpense() {
        driver.findElement(addexpensebutton).click();
    }

    public void submitExpense() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(
                ExpectedConditions.elementToBeClickable(addsubmitbutton)
        ).click();
//        driver.findElement(addsubmitbutton).click();
    }

    public String getMessage() {
        return driver.findElement(message).getText();
    }

}
