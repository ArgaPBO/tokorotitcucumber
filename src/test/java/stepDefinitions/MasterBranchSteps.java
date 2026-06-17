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

public class MasterBranchSteps {

    @Given("User is logged in as admin then opens Branchs CRUD page")
    public void useradmin() {
        Hooks.driver.get("http://127.0.0.1:8000/login");
        Hooks.loginPage.setUsername("admin");
        Hooks.loginPage.setPassword("admin123");
        Hooks.loginPage.submit();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Hooks.adminpage.getUserdisplay()));
        Hooks.driver.get("http://127.0.0.1:8000/admin/branches");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Hooks.branchespage.getUserdisplay()));
    }

    @When("Press New Branch then enter valid Branch data then submit")
    public void newbranchvalid() {
        Hooks.branchespage.pressAddBranch();
        Hooks.branchespage.inputName();
        Hooks.branchespage.submitBranch();
    }

    @When("Press New Branch then press submit with fields empty")
    public void newbranchinvalid() {
        Hooks.branchespage.pressAddBranch();
        Hooks.branchespage.submitBranch();
    }


    @Then("Get Branch created successfully. message")
    public void branchcreated() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Hooks.branchespage.getMessageby()));
        String message = Hooks.branchespage.getMessage();
        String expected = "Branch created successfully.";
        Assertions.assertEquals(expected, message);
    }

    @Then("Get Please enter a branch name message")
    public void fillrequired() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Hooks.branchespage.getMessageby()));
        String message = Hooks.branchespage.getMessage();
        String expected = "Please enter a branch name";
        Assertions.assertEquals(expected, message);
    }


}
