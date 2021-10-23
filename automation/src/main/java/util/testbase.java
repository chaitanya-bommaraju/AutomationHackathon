package util;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testbase 
{
	public static WebDriver driver = null;
	
	public static void init(String browser)
	{
		if(driver==null)
		{
			switch(browser.toLowerCase())
			{
			case "chrome":
			System.setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver.exe");
			driver = new ChromeDriver();
			case "firefox":
			
			}
			
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		}
	}
}
