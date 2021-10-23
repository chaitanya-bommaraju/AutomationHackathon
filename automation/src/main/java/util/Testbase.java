package util;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testbase 
{
	public static WebDriver driver = null;
	
	public static WebDriver init(String browser, String url)
	{
		if(driver==null)
		{
			switch(browser.toLowerCase())
			{
			case "chrome":
			System.setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);
			}
			
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		}
		return driver;
	}
	
	public static void exitTest()
	{
		driver.close();
		driver=null;
	}
}
