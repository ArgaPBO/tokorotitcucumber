package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MasterProductSteps {

    @Given("User is logged in as admin then opens products CRUD page")
    public void useradmin() {
        Hooks.driver.get("http://127.0.0.1:8000/login");
        Hooks.loginPage.setUsername("admin");
        Hooks.loginPage.setPassword("admin123");
        Hooks.loginPage.submit();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Hooks.adminpage.getUserdisplay()));
        Hooks.driver.get("http://127.0.0.1:8000/admin/products");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Hooks.productpage.getUserdisplay()));
    }

    @When("Press New Product then enter valid product data then submit")
    public void newproductvalid() {
        Hooks.productpage.pressAddProduct();
        Hooks.productpage.inputName();
        Hooks.productpage.inputPrice();
        Hooks.productpage.submitProduct();
    }

    @When("Press New Product then press submit with fields empty")
    public void newproductinvalid() {
        Hooks.productpage.pressAddProduct();
        Hooks.productpage.submitProduct();
    }


    @Then("Get Product created successfully. message")
    public void productcreated() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Hooks.productpage.getMessageby()));
        String message = Hooks.productpage.getMessage();
        String expected = "Product created successfully.";
        Assertions.assertEquals(expected, message);
    }

    @Then("New product data is visible in the table")
    public void newproductss() {
        String inputNya = Hooks.productpage.getLastInputName();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        // Wait for success message first, then navigate back to products list
        wait.until(ExpectedConditions.visibilityOfElementLocated(Hooks.productpage.getMessageby()));
        Hooks.driver.get("http://127.0.0.1:8000/admin/products");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Hooks.productpage.getUserdisplay()));
        // Wait for table to render, then use search to bypass pagination
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table//tbody/tr")));
        Hooks.productpage.searchProduct(inputNya);
        // Product name is inside <td><strong>name</strong></td>
        By rowLocator = By.xpath("//tbody[@id='productTableBody']//td/strong[contains(text(),'" + inputNya + "')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(rowLocator));
        List<WebElement> rows = Hooks.driver.findElements(rowLocator);
        Assertions.assertFalse(rows.isEmpty(), "Produk dengan nama '" + inputNya + "' tidak ditemukan di tabel");
    }

    @Then("Get Please enter name and price message")
    public void fillrequired() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Hooks.productpage.getMessageby()));
        String message = Hooks.productpage.getMessage();
        String expected = "Please enter name and price";
        Assertions.assertEquals(expected, message);
    }

}
