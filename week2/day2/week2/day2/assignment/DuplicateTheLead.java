package week2.day2.assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateTheLead {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElement(By.id("username")).sendKeys("DemosalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa",Keys.ENTER);
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("vsandhya.vsm@gmail.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		String leadXpath = "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)";
		WebElement searchcount = driver.findElement(By.xpath("//div[@class='x-paging-info']"));
		String searchResult = searchcount.getText();
		System.out.println(searchResult);
		if(!searchResult.equals("No records to display"))
		{
			List<WebElement> leadId= driver.findElements(By.xpath(leadXpath));
			if(!leadId.isEmpty()) {
				WebElement firstElement = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]"));
				String firstName_1 = firstElement.getText();
				String lastName_1=driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-lastName']/a)[1]")).getText();
				String fullName = firstName_1.concat(lastName_1);
				System.out.println(fullName);
				firstElement.click();
				driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
				System.out.println(driver.getTitle());
				if(driver.getTitle().contains("Duplicate Lead"))
					System.out.println("Tile is verified");
				driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
				String fristName = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
				String lastName = driver.findElement(By.xpath("//span[@id='viewLead_lastName_sp']")).getText();
				String duplicatLeadName = fristName.concat(lastName);
				System.out.println(duplicatLeadName);
				if(duplicatLeadName.equals(fullName)) {
					System.out.println("duplicate lead name is same as capture name");
				}
				else
				{
					System.out.println("duplicate lead name is not same as capture name");	
				}
				
		}
		}
		else
		{
			System.out.println("No records to display!!!!!!!!!!!!!");
		}
		
		driver.close();
	}
}
