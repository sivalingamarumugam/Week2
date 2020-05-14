package week2.day2.assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLeads {

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
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		String mobileNumber = "8766";
		driver.findElement(By.id("ext-gen270")).sendKeys(mobileNumber);
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
				WebElement firstElement = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"));
				String leadId_1 = firstElement.getText();
				System.out.println(leadId_1);
				firstElement.click();
				driver.findElement(By.xpath("//a[text()='Delete']")).click();
				driver.findElement(By.linkText("Find Leads")).click();
				driver.findElement(By.xpath("//span[text()='Phone']")).click();
				driver.findElement(By.id("ext-gen270")).sendKeys(mobileNumber);
				driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
				Thread.sleep(1000);
				List<WebElement> leadId_2= driver.findElements(By.xpath(leadXpath));
				for(int i =0 ; i<leadId_2.size();i++)
				{
					System.out.println(leadId_2.get(i).getText());
					if(leadId_2.get(i).getText().equals(leadId_1)) {
						System.out.println("record is not deleted");
					}
				}
				System.out.println("Record is deleted successfully"+leadId_1);
			}		
			
		}
		
		else
		{
			System.out.println("No records to display!!!!!!!!!!!!!");
		}
		driver.close();
	}
	}


