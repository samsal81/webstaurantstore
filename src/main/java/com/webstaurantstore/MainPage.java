package com.webstaurantstore;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MainPage {

    private WebDriver driver;
  
    public MainPage(WebDriver driver) {
      this.driver = driver;
    }

    @FindBy(xpath = "//div[@role='banner']/div[1]/div[1]//input[@name='searchval']") private WebElement searchBox;
    @FindBy(xpath = "//div[@role='banner']/div[1]/div[1]//button[@value='Search']") private WebElement searchBtn;

    public void searchForItem(String searchText) {
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
      driver.findElement(By.cssSelector("div.product-box-container:last-child input[type='submit']")).click();
      driver.findElement(By.xpath("//a[text()='View Cart']")).click();
    }

    public void EmptyCartAndAssertEmptyCart(){
      driver.findElement(By.xpath("//button[text()='Empty Cart']")).click();
      driver.findElement(By.xpath("//footer//button[text()='Empty']")).click();
      Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Your cart is empty.']")).isDisplayed());
    }

    public void WaitForElementDisplayed(WebElement element) {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.visibilityOf(element));
    }
  }
