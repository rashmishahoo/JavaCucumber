//Explanation
//Step Definitions:
//i_have_the_following_users: Populates a HashMap with the usernames from the feature file.
// For simplicity, it assumes all users have the same password.
//i_login_with_each_user: Iterates over each user in the HashMap,
// logs in, and checks for the presence of button1 and the absence of button2.
//
package test.java.stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckButtonsForMultipleUsers {
    WebDriver driver;
    Map<String, String> users = new HashMap<>();

    @Given("I have the following users")
    public void i_have_the_following_users(io.cucumber.datatable.DataTable dataTable) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();

        // Adding users to the HashMap
        dataTable.asList().forEach(username -> users.put(username, "password")); // assuming all users have the same password
    }

    @When("I login with each user")
    public void i_login_with_each_user() {
        for (Map.Entry<String, String> user : users.entrySet()) {
            driver.get("https://example.com/login");

            // Perform login
            driver.findElement(By.id("username")).sendKeys(user.getKey());
            driver.findElement(By.id("password")).sendKeys(user.getValue());
            driver.findElement(By.id("loginButton")).click();

            // Check if button1 is present
            boolean isButton1Present = driver.findElement(By.id("button1")).isDisplayed();
            assertTrue("Button1 is not present on the page for " + user.getKey(), isButton1Present);

            // Check if button2 is not present
            boolean isButton2Present = driver.findElements(By.id("button2")).size() > 0;
            assertFalse("Button2 is present on the page for " + user.getKey(), isButton2Present);
        }
    }

    @Then("I should see button1")
    public void i_should_see_button1() {
        // This step is handled in the iteration itself
    }

    @Then("I should not see button2")
    public void i_should_not_see_button2() {
        // This step is handled in the iteration itself
    }
}
