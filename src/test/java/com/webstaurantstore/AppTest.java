package com.webstaurantstore;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class AppTest extends BaseTest
{   
    private MainPage mainPage;

    @Test
    public void testFirst()
    {
        mainPage = PageFactory.initElements(driver, MainPage.class);

        mainPage.SearchForItem("stainless work table");
        mainPage.AssertDisplayedProductsContainKeyword("Table");
        mainPage.AddLastProductAndViewCart();
        mainPage.EmptyCartAndAssertEmptyCart();
    }
}
