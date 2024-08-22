package test.java.stepDefinitions;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class CheckCustomer {

    WebDriver driver;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://example.com/login");
    }

    @When("I login with username {string} and password {string}")
    public void i_login_with_username_and_password(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("loginButton")).click();
    }

    @Then("I should see the button1")
    public void i_should_see_the_button1() {
        boolean isButton1Present = driver.findElement(By.id("button1")).isDisplayed();
        assertTrue("Button1 is not present on the page", isButton1Present);
    }

    @Then("I should see the button2 only if I am user2")
    public void i_should_see_the_button2_only_if_i_am_user2() {
        String loggedInUser = driver.findElement(By.id("username")).getAttribute("value");
        boolean isButton2Present = driver.findElement(By.id("button2")).isDisplayed();
        if (loggedInUser.equals("user2")) {
            assertTrue("Button2 is not present on the page for user2", isButton2Present);
        } else {
            assertFalse("Button2 should not be present on the page for user1", isButton2Present);
        }
        driver.quit();
    }
}
