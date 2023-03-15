package steps;

import static runners.Runner.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;

public class UseCase1
{
	private WebDriver driver;
	String currentWindowHandle;

	public UseCase1(WebDriver driver)
	{
		this.driver = driver;
	}

	private void navigateToSite()
	{
		driver.get("https://www.flipkart.com/");
		standardWait(driver, mainPage.searchBar);
	}

	private void searchForProduct() throws InterruptedException
	{
		mainPage.exitModal.click();
		Thread.sleep(2000);
		mainPage.searchBar.sendKeys("iPhone 11");
		mainPage.searchBar.sendKeys(Keys.ENTER);
		standardWait(driver, searchPage.firstResult);
	}

	private void selectProduct() throws InterruptedException
	{
		Thread.sleep(5000);
		currentWindowHandle = driver.getWindowHandle();
		searchPage.firstResult.click();
	}

	private void selectStorage() throws InterruptedException
	{
		Thread.sleep(5000);

		for (String windowHandle : driver.getWindowHandles())
		{
			if (!windowHandle.equals(currentWindowHandle))
			{
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		productPage.storageButton.click();
		Thread.sleep(5000);
	}

	private void addToCart() throws InterruptedException
	{
		productPage.addToCartButton.click();
		Thread.sleep(5000);
	}

	public void run() throws InterruptedException
	{
		navigateToSite();
		searchForProduct();
		selectProduct();
		selectStorage();
		addToCart();
	}

	private static void standardWait(WebDriver driver, WebElement elem)
	{
		new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMillis(15000))
				.ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(elem)));
	}
}
