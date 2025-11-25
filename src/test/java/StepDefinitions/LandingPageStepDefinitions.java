package StepDefinitions;

import PageObjects.LandingPage;
import Utils.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class LandingPageStepDefinitions {
   public WebDriver driver;
   public String LandingPageProductName;
   public String offerPageProductName;
    TestContextSetup testContextSetup;

   public  LandingPageStepDefinitions(TestContextSetup testContextSetup)
   {
      this.testContextSetup=testContextSetup;
   }

    @Given("user is on GreenCart Landing page")
    public void userIsOnLandingPage() {

      testContextSetup.driver= new ChromeDriver();
      testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
      testContextSetup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      testContextSetup.driver.manage().window().maximize();

    }

    @When("user searched for Shortname {string} and Extracted actual name of the product")
    public void userSearchedForShortnameAndExtractedActualNameOfTheProduct(String shortName) throws InterruptedException {
        LandingPage landingPage=new LandingPage(testContextSetup.driver);
        landingPage.searchItem(shortName);
     // testContextSetup.driver.findElement(By.xpath("//input[@class='search-keyword']")).sendKeys(shortName);
        Thread.sleep(2000);
        testContextSetup.LandingPageProductName=landingPage.getProductName().split("-")[0].trim();
        System.out.println(testContextSetup.LandingPageProductName + "is extracted from home page");

    }

    }









