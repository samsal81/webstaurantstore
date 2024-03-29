package com.webstaurantstore;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class AppTest extends BaseTest
{    
    @Test
    public void testFirst()
    {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.searchForItem("stainless work table");
        mainPage.AssertDisplayedProductsContainKeyword("Table");
        mainPage.AddLastProductAndViewCart();
        mainPage.EmptyCartAndAssertEmptyCart();
    }
}
