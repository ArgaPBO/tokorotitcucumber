package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MasterUserSteps {


    @Given("User is logged in as admin then opens users CRUD page")
    public void useradmin() {
        Hooks.driver.get("http://127.0.0.1:8000/login");
        Hooks.loginPage.setUsername("admin");
        Hooks.loginPage.setPassword("admin123");
        Hooks.loginPage.submit();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Hooks.adminpage.getUserdisplay()));
        Hooks.driver.get("http://127.0.0.1:8000/admin/users");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Hooks.userpage.getUserdisplay()));
    }

    @When("Press New User then enter valid user data then submit")
    public void newuservalid() {
        Hooks.userpage.pressAddUser();
        Hooks.userpage.inputName();
        Hooks.userpage.inputUsername();
        Hooks.userpage.inputPassword();
        Hooks.userpage.selectRoleAdmin();
        Hooks.userpage.submitUser();
    }

    @When("Press New User then press submit with fields empty")
    public void newuserinvalid() {
        Hooks.userpage.pressAddUser();
        Hooks.userpage.submitUser();
    }


    @Then("Get ✓ User created successfully message")
    public void usercreated() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Hooks.userpage.getMessageby()));
        String message = Hooks.userpage.getMessage();
        String expected = "✓ User created successfully";
        Assertions.assertEquals(expected, message);
    }

    @Then("Get Please fill required fields. Password required for new user. message")
    public void fillrequired() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Hooks.userpage.getMessageby()));
        String message = Hooks.userpage.getMessage();
        String expected = "Please fill required fields. Password required for new user.";
        Assertions.assertEquals(expected, message);
    }


}
