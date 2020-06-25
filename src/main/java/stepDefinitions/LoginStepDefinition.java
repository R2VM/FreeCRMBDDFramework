package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDefinition {
    WebDriver driver;

    @Given("^user is already on Login Page$")
    public void user_is_already_on_Login_Page() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\avkin\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://ui.cogmento.com/");
        driver.manage().window().maximize();
    }

    @When("^title of login page is Free CRM$")
    public void title_of_login_page_is_Free_CRM() {
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals("Cogmento CRM", title);
    }


    @Then("^user enters <username> and <password>$")
    public void user_enters_username_and_password(){
        driver.findElement(By.name("email")).sendKeys("vivekraoba@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Butterfly25");
    }

    @Then("^user clicks on login button$")
    public void user_clicks_on_login_button() {
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", loginBtn);
    }

    @Then("^Close the browser$")
    public void Close_the_browser() {
        String title = driver.getTitle();
        System.out.println("Cogmento CRM" + title);
        Assert.assertEquals("Cogmento CRM", title);
    }

}

