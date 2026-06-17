package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MasterExpenseSteps {

    @Given("User is logged in as admin then opens expense CRUD page")
    public void useradmin() {
        Hooks.driver.get("http://127.0.0.1:8000/login");
        Hooks.loginPage.setUsername("admin");
        Hooks.loginPage.setPassword("admin123");
        Hooks.loginPage.submit();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Hooks.adminpage.getUserdisplay()));
        Hooks.driver.get("http://127.0.0.1:8000/admin/expenses");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Hooks.expensepage.getUserdisplay()));
    }

    @When("Press Add Expense then enter valid expense data then submit")
    public void newexpensevalid() {
        Hooks.expensepage.pressAddExpense();
        Hooks.expensepage.inputName();
        Hooks.expensepage.submitExpense();
    }

    @When("Press Add Product then press submit with fields empty")
    public void newexpenseinvalid() {
        Hooks.expensepage.pressAddExpense();
        Hooks.expensepage.submitExpense();
    }


    @Then("Get Expense created successfully. message")
    public void expensecreated() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Hooks.expensepage.getMessageby()));
        String message = Hooks.expensepage.getMessage();
        String expected = "Expense created successfully.";
        Assertions.assertEquals(expected, message);
    }

    @Then("Get Please enter an expense name message")
    public void fillrequired() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Hooks.expensepage.getMessageby()));
        String message = Hooks.expensepage.getMessage();
        String expected = "Please enter an expense name";
        Assertions.assertEquals(expected, message);
    }

}
