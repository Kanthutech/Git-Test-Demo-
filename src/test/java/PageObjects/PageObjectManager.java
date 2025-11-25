package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    public LandingPage LandingPage;
    public OfferPage OfferPage;
    public WebDriver driver;

    public PageObjectManager(WebDriver driver)
    {
       this.driver=driver;
    }

    public LandingPage getLandingPage()
    {
        LandingPage =new LandingPage(driver);
        return LandingPage;
    }

    public OfferPage OfferPage()
    {
        OfferPage offerPage=new OfferPage(driver);
        return offerPage;
    }
}
