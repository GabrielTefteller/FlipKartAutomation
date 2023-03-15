package runners;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;
import steps.*;

public class Runner
{
	public static WebDriver driver;

	public static MainPage mainPage;
	public static ProductPage productPage;
	public static CartPage cartPage;
	public static SearchPage searchPage;
	public static UseCase1 steps;

	public Runner()
	{
		// Set up the driver you're using.
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		// Initialize the driver.
		driver = new ChromeDriver(options);

		// Initialize pages.
		mainPage = new MainPage(driver);
		productPage = new ProductPage(driver);
		cartPage = new CartPage(driver);
		searchPage = new SearchPage(driver);

		// Initialize steps. There can be multiple use cases here.
		steps = new UseCase1(driver);
	}

	public void run() throws InterruptedException
	{
		steps.run();
	}

	// Burner Email:
	// burnerbob281gmail.com
	// BobLovesCats1985
}

