package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BranchProductSteps {

    @Given("User is logged in as branch user then opens branch products page")
    public void useradmin() {
        Hooks.driver.get("http://127.0.0.1:8000/login");
        Hooks.loginPage.setUsername("employee");
        Hooks.loginPage.setPassword("employee123");
        Hooks.loginPage.submit();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Hooks.branchpage.getUserdisplay()));
        Hooks.driver.get("http://127.0.0.1:8000/branch/products");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Hooks.branchBranchProductPage.getUserdisplay()));
    }


    @When("Press Add Branch Product then press submit with fields empty")
    public void newproductinvalid() {
        Hooks.branchBranchProductPage.pressAddProduct();
        Hooks.branchBranchProductPage.submitProduct();
    }
    @When("Press New branch Product then enter valid product data then submit")
    public void newproductvalid() {
        Hooks.branchBranchProductPage.pressAddProduct();
        Hooks.branchBranchProductPage.inputName();
        Hooks.branchBranchProductPage.inputPrice();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Hooks.branchBranchProductPage.getMessageby()));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"productListDropdown\"]/div"))).click();
        Hooks.branchBranchProductPage.submitProduct();
    }
    @Then("Get branch Product created successfully. message")
    public void productcreated() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Hooks.branchBranchProductPage.getMessageby()));
        String message = Hooks.branchBranchProductPage.getMessage();
        String expected = "Product created successfully.";
        Assertions.assertEquals(expected, message);
    }



    @Then("Get Please select a product and enter branch price message")
    public void fillrequired() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Hooks.branchBranchProductPage.getMessageby()));
        String message = Hooks.branchBranchProductPage.getMessage();
        String expected = "Please select a product and enter branch price";
        Assertions.assertEquals(expected, message);
    }

}
