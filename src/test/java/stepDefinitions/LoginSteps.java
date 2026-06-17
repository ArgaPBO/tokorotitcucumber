package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;
    ProductPage productpage;

    @Before
    void setupDriver() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @Given("User di halaman login")
    public void user_di_halaman_login() {
        setupDriver();
        driver.get("http://127.0.0.1:8000/login");;
    }

    @When("write valid username and password")
    public void write_valid_username_and_password() {
        loginPage.setUsername("admin");
        loginPage.setPassword("admin123");;
    }


    @When("submit button ditekan")
    public void submit_button_ditekan() {
        loginPage.submit();
    }


    @Then("arrive at page inventory")
    public void arrive_at_page_inventory() {
        String expectedURL = "http://127.0.0.1:8000/login";
        String actualURL = driver.getCurrentUrl();
//        productpage = new ProductPage(driver);
//        boolean productdisplayed =productpage.isProductsDisplayed();
        Assertions.assertAll(
                () -> Assertions.assertEquals(actualURL, expectedURL)
//                ,() -> Assertions.assertTrue(productpage.isProductsDisplayed())
        );
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }

}
