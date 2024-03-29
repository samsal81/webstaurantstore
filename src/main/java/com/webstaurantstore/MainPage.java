package com.webstaurantstore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MainPage {

    private WebDriver driver;
  
    public MainPage(WebDriver driver) {
      this.driver = driver;
    }

    @FindBy(xpath = "//div[@role='banner']/div[1]/div[1]//input[@name='searchval']") private WebElement searchBox;
    @FindBy(xpath = "//div[@role='banner']/div[1]/div[1]//button[@value='Search']") private WebElement searchBtn;
    @FindBy(css = "div.product-box-container:last-child input[type='submit']") private WebElement lastItmAddBtn;
    @FindBy(xpath = "//a[text()='View Cart']") private WebElement viewCartConfBtn;
    @FindBy(xpath = "//button[text()='Empty Cart']") private WebElement emptyCartBtn;
    @FindBy(xpath = "//footer//button[text()='Empty']") private WebElement emptyCartConfBtn;
    @FindBy(xpath = "//p[text()='Your cart is empty.']") private WebElement cartIsEmptyText;

    public void SearchForItem(String searchText) {
      searchBox.sendKeys(searchText);
      searchBtn.click();
    }

    public void AssertDisplayedProductsContainKeyword(String keyword) {
      int i=1;
      do{
          for (WebElement product : driver.findElements(By.cssSelector("div.product-box-container span.font-semibold.block"))) {
            Assert.assertTrue(product.getText().contains(keyword));
          }

          System.out.println("page number: " + i);
          driver.findElement(By.cssSelector("li.inline-block.leading-4.align-top.rounded-r-md > a")).click();
          i++;
      }while(driver.findElements(By.cssSelector("li.inline-block.leading-4.align-top.rounded-r-md > a")).size() > 0 && i < 5);
    }

    public void AddLastProductAndViewCart(){
      lastItmAddBtn.click();
      viewCartConfBtn.click();
    }

    public void EmptyCartAndAssertEmptyCart(){
      emptyCartBtn.click();
      emptyCartConfBtn.click();
      Assert.assertTrue(cartIsEmptyText.isDisplayed());
    }
  }
