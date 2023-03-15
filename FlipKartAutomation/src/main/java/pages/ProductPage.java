package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ProductPage extends Page
{
	public WebDriver driver;

	public ProductPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/div[1]/div/div[3]/div[1]/div[2]/div[6]/div/div[2]/div[1]/div/ul/li[2]/a")
	public WebElement storageButton;

	@FindBy(xpath = "//*[@id='container']/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button")
	public WebElement addToCartButton;
}