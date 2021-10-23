package fbtests;
import util.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.json.simple.JSONArray;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSet1 {
	
	WebDriver driver = null;
//	@DataProvider(name = "jsondataprovider")
//	public HashMap<String,String> dataProvider() throws Exception
//	{
//		HashMap<String,String> data = null;
//		String testDataPath = "src/main/resources/TestData.JSON";
//		String content = new Scanner(new File(testDataPath)).useDelimiter("\\Z").next();
//		data = FileUtil.readJSON(content,"0001");
//		return data;
//	}
	
	@BeforeMethod
	public void gearUp()
	{
		this.driver = Testbase.init("chrome", "https://www.youtube.com/");
	}
	@Test
	public void GetVideoList() throws InterruptedException 
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		
		//-----Validate if YouTube launched
		Assert.assertEquals(driver.getTitle(), "YouTube");
		
	    //-----Search EPAM Systems Global Channel
		By searchBar = By.xpath("//div[@id = 'center']//input[@id= 'search']");
		By searchButton = By.xpath("//button[@id='search-icon-legacy']");
		
		wait.until(ExpectedConditions.elementToBeClickable(searchBar));
		driver.findElement(searchBar).clear();
		driver.findElement(searchBar).sendKeys("EPAM Systems Global");
		wait.until(ExpectedConditions.elementToBeClickable(searchButton));
		driver.findElement(searchButton).click();
		
		//------Navigate to Channel from Search Results
		By searchResults = By.xpath("//div[@id='content-section' and @Class ='style-scope ytd-channel-renderer']//child::yt-formatted-string");
		List<WebElement> list = driver.findElements(searchResults);
		for(WebElement result : list)
		{
			if(result.getText().equals("EPAM Systems Global"))
			{
				result.click();
			}
		}
		
		//----- Navigate to Videos Tab in channel
		
		By videosTab = By.xpath("//*[@id='tabsContent']//tp-yt-paper-tab[2]");
		wait.until(ExpectedConditions.elementToBeClickable(videosTab));
		driver.findElement(videosTab).click();
		
		//----- Sort all videos
	    By sortButton = By.xpath("//*[@id='sort-menu']//tp-yt-paper-menu-button");
	    wait.until(ExpectedConditions.elementToBeClickable(sortButton));
	    driver.findElement(sortButton).click();
	    Thread.sleep(10000);
	    By sortCriteria = By.xpath("//div[contains(text(),'Date added (oldest)')]/ancestor::tp-yt-paper-item");
	    driver.findElement(sortCriteria).click();
	    
	    //---- Scroll until end of Page to load all videos
	    
	    for(int i = 0; i<20;i++)
	    {
	    	Thread.sleep(10000);
	    	((JavascriptExecutor) driver)
	        .executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    	Thread.sleep(3000);
	    	((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
	    	Thread.sleep(1000);
	    }
	    
	    //---- Get count of videos
	    By allVideos = By.xpath("//div[@id='items' and @Class='style-scope ytd-grid-renderer']//child::ytd-grid-video-renderer");
	    List<WebElement> videoList =  driver.findElements(allVideos);
	    
	    for(WebElement video : videoList)
	    {
	    	String title = video.findElement(By.xpath(".//a[@id='video-title'][1]")).getText();
	    	System.out.println("Title: "+title);
	    	String views = video.findElement(By.xpath(".//span[contains(text(),'views')]")).getText();
	    	String upload = video.findElement(By.xpath(".//span[contains(text(),'ago')]")).getText();
	    	
	    	System.out.println("Views : "+views+" Upload :"+upload);
	    }
	    
	    
	}
	@AfterMethod
	public void teardDown()
	{
		Testbase.exitTest();
	}

}
