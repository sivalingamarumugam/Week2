package week2.day1.assignment;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PlayWithHyperLinks {
	

	public static void main(String[] args) throws IOException  {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/Link.html");
		driver.findElement(By.linkText("Go to Home Page")).click(); //Go to Home Page
		driver.findElement(By.xpath("//img[@alt='Link']")).click();
		//Find where am supposed to go without clicking me? --- 
		WebElement link=driver.findElement(By.xpath("//a[@href='error.html']"));
		String href = link.getAttribute("href");	
		PlayWithHyperLinks obj = new PlayWithHyperLinks();
		obj.verifyTheUrl(href);// verify am i broken
		driver.findElement(By.xpath("(//a[@href='../home.html'])[3]")).click();
		driver.findElement(By.xpath("//img[@alt='Link']")).click();
		List<WebElement> links = driver.findElements(By.tagName("a"));		
		System.out.println("Total link in this page : " + links.size());		

	}
	public static void verifyTheUrl(String href) throws IOException
	{
		URL url = new URL(href);
		// create the connection
		HttpURLConnection httpUrlConnect = (HttpURLConnection)url.openConnection(); 
		httpUrlConnect.connect();
		if(httpUrlConnect.getResponseCode()==200)
		{
			System.out.println(href+ "-  "+httpUrlConnect.getResponseMessage());
		}
		else
		{
			System.out.println(href+ "- "+httpUrlConnect.getResponseCode() +"- " +"i am broken a link");
		}
		
	}

}
