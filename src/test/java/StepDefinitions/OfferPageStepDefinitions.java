package StepDefinitions;

import PageObjects.LandingPage;
import PageObjects.OfferPage;
import PageObjects.PageObjectManager;
import Utils.TestContextSetup;
import com.aventstack.extentreports.observer.entity.AttributeEntity;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;


public class OfferPageStepDefinitions {
   public WebDriver driver;
   public String LandingPageProductName;
   public String offerPageProductName;
   PageObjectManager pageObjectManager;

    TestContextSetup testContextSetup;

    public  OfferPageStepDefinitions(TestContextSetup testContextSetup)
    {
        this.testContextSetup=testContextSetup;
    }


    @Then("user searched {string} Shortname in offers page")
    public void userSearchedShortnameInOffersPage(String shortName) throws InterruptedException {
        swiTchToOfferPage();
        pageObjectManager=new PageObjectManager(testContextSetup.driver);
        OfferPage offerPage =pageObjectManager.OfferPage();
       offerPage.searchItem(shortName);
        Thread.sleep(2000);
        offerPageProductName=offerPage.getProductName();


    }

    public void swiTchToOfferPage()
    {
        pageObjectManager=new PageObjectManager(testContextSetup.driver);
       LandingPage landingPage= pageObjectManager.getLandingPage();
       landingPage.selectTopDealsPage();


        Set<String>s1=testContextSetup.driver.getWindowHandles();
        Iterator<String>i1= s1.iterator();
        String parentWindow=i1.next();
        String childWindow= i1.next();
        testContextSetup.driver.switchTo().window(childWindow);
    }


    @And("Validate product name in offer page matchs with landing page")
    public void validateProductNameInOfferPageMatchsWithLandingPage() {

        Assert.assertEquals(offerPageProductName,testContextSetup.LandingPageProductName);




        testContextSetup.driver.quit();

       

    }



    }





