package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page
{
	public WebDriver driver;

	public Page(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name = 'q']")
	public WebElement searchBar;

	@FindBy(xpath = "//*[@id='container']/div/div[1]/div[1]/div[2]/div[6]/div/div/a")
	public WebElement cartButton;

	@FindBy(xpath = "/html/body/div[2]/div/div/button")
	public WebElement exitModal;
}