package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Hooks {

    public static WebDriver driver;
    public static LoginPage loginPage;
    public static AdminDashboardPage adminpage;
    public static BranchDashboardPage branchpage;
    public static AdminMasterUserPage userpage;
    public static AdminMasterProductPage productpage;
    public static AdminMasterExpensePage expensepage;
    public static AdminMasterBranchPage branchespage;
    public static BranchBranchProductPage branchBranchProductPage;
    public static BranchProductHistoryPage branchProductHistoryPage;
    public static BranchExpenseHistoryPage branchExpenseHistoryPage;

    @Before
    public void setupDriver() {
        driver = new EdgeDriver();
        loginPage = new LoginPage(driver);
        adminpage = new AdminDashboardPage(driver);
        branchpage = new BranchDashboardPage(driver);
        userpage = new AdminMasterUserPage(driver);
        productpage = new AdminMasterProductPage(driver);
        expensepage = new AdminMasterExpensePage(driver);
        branchespage = new AdminMasterBranchPage(driver);
        branchBranchProductPage = new BranchBranchProductPage(driver);
        branchProductHistoryPage = new BranchProductHistoryPage(driver);
        branchExpenseHistoryPage = new BranchExpenseHistoryPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
    }

//    @After()
//    public void closeBrowser() {
//        driver.quit();
//    }

}
