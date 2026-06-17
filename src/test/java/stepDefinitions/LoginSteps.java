package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {


    @Given("User is in login page")
    public void userinloginpage() {
        Hooks.driver.get("http://127.0.0.1:8000/login");;
    }

    @When("Write valid admin username and password then presses the submit button")
    public void admincredential() {
        Hooks.loginPage.setUsername("admin");
        Hooks.loginPage.setPassword("admin123");
        Hooks.loginPage.submit();
    }

    @When("Write valid branch account username and password then presses the submit button")
    public void branchcredential() {
        Hooks.loginPage.setUsername("employee");
        Hooks.loginPage.setPassword("employee123");
        Hooks.loginPage.submit();
    }

    @When("Write invalid username and password then presses the submit button")
    public void invalidcredential() {
        Hooks.loginPage.setUsername("admin");
        Hooks.loginPage.setPassword("invalidpass");
        Hooks.loginPage.submit();
    }


    @Then("Arrive at admin dashboard")
    public void arriveadmin() {
        String expectedURL = "http://127.0.0.1:8000/admin";
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Hooks.adminpage.getUserdisplay()));
        String actualURL = Hooks.driver.getCurrentUrl();
        Assertions.assertEquals(actualURL, expectedURL);
    }

    @Then("Arrive at branch dashboard")
    public void arrivebranch() {
        String expectedURL = "http://127.0.0.1:8000/branch";
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Hooks.branchpage.getUserdisplay()));
        String actualURL = Hooks.driver.getCurrentUrl();
        Assertions.assertEquals(actualURL, expectedURL);
    }

    @Then("Stays at login page")
    public void failarrive() {
        String expectedURL = "http://127.0.0.1:8000/login";
//        UnhandledAlertException exception = Assertions.assertThrows(UnhandledAlertException.class, () -> {


        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = Hooks.driver.switchTo().alert();
        String text = alert.getText();
        alert.accept();
//        });
        String actualURL = Hooks.driver.getCurrentUrl();
        Assertions.assertEquals(actualURL, expectedURL);
//        String errorMessage = exception.getMessage();
//        Assertions.assertAll(
//                () -> Assertions.assertEquals(actualURL, expectedURL),
//                () -> Assertions.assertEquals(errorMessage, "unexpected alert open: {Alert text : Invalid credentials.}")
//        );

    }


}
