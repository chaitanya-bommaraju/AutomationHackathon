package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FB_Login_Page
{
	WebDriver driver = null;
	public FB_Login_Page(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By input_email = By.xpath("//input[@id='email']");
	private By input_pass = By.xpath("//input[@id='pass']");
	
	public boolean logintofb()
	{
		boolean flag = false;
		driver.get("http://facebook.com");
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(input_email));
		driver.findElement(input_email).sendKeys("something");
		driver.findElement(input_pass).sendKeys("somethingelse");
		flag = true;
		return flag;
	}
	
	
}
