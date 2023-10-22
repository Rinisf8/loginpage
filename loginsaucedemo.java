package saucedemo.bstepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class loginsaucedemo {
    WebDriver driver;
    String baseurl = "https://www.saucedemo.com/";

    @Given("login page swag labs")
    public void login_page_swag_labs() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        FirefoxOptions opt = new FirefoxOptions();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseurl);

        String loginPageAssert = driver.findElement(By.xpath("/html/body/div/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @When("user input username")
    public void user_input_username() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }
    @And("user input password")
    public void user_input_password(){
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("click login button")
    public void click_login_button() {
        driver.findElement(By.cssSelector("#login-button")).click();
    }

    @Then("user in on dashboard page")
    public void user_in_on_dashboard_page() {
        driver.findElement(By.cssSelector(".app_logo")).getText();
        String logo = driver.findElement(By.cssSelector(".app_logo")).getText();
        Assert.assertEquals(logo, "Swag Labs");
        driver.close();
    }

    @And("user input invalid password")
    public void user_input_invalid_password() {
        driver.findElement(By.id("password")).sendKeys("12345");
    }

    @Then("user get error message")
    public void user_get_error_message() {
        String error = driver.findElement(By.cssSelector(".error-message-container")).getText();
        Assert.assertEquals(error, "Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }
}