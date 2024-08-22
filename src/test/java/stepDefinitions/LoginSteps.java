package test.java.stepDefinitions;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class LoginSteps {
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

    @Then("I should see the button1 with id {string}")
    public void i_should_see_the_button1_with_id(String buttonId1) {
        boolean isButton1Present = driver.findElement(By.id(buttonId1)).isDisplayed();
        assertTrue("Button is not present on the page", isButtonPresent);
        driver.quit();
    @Then(" should see the button2 with id {string}}")
    public void i_should_see_the_button2_with_id(String  buttonId2){
        boolean isButton2Present = driver.findElement(By.id(buttonId2).isDisplayed();
        driver.quit();
}
