package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductHistorySteps {

    @Given("User is logged in as branch user then opens product history page")
    public void useradmin() {
        Hooks.driver.get("http://127.0.0.1:8000/login");
        Hooks.loginPage.setUsername("employee");
        Hooks.loginPage.setPassword("employee123");
        Hooks.loginPage.submit();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Hooks.branchpage.getUserdisplay()));
        Hooks.driver.get("http://127.0.0.1:8000/branch/history/products");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Hooks.branchProductHistoryPage.getUserdisplay()));
    }


    @When("Press Add Single product history then press submit with fields empty")
    public void newproductinvalid() {
        Hooks.branchProductHistoryPage.pressAddProduct();
        Hooks.branchProductHistoryPage.submitProduct();
    }



    @Then("Get Please fill all required fields message")
    public void fillrequired() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Hooks.branchProductHistoryPage.getMessageby()));
        String message = Hooks.branchProductHistoryPage.getMessage();
        String expected = "Please fill all required fields";
        Assertions.assertEquals(expected, message);
    }

}
