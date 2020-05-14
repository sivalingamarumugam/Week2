package week2.day2.assignment;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdateLead {

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
		driver.findElement(By.xpath("//input[@id='ext-gen248']")).sendKeys("Lingam");
		driver.findElement(By.xpath("//button[@id='ext-gen334']")).click();
		Thread.sleep(1000);
		WebElement searchcount = driver.findElement(By.xpath("//div[@class='x-paging-info']"));
		String searchResult = searchcount.getText();
		System.out.println(searchResult);
		if(!searchResult.equals("No records to display"))
		{
			driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-lastName']/a)[1]")).click();
			driver.findElement(By.xpath("//a[contains(@href,'updateLeadForm?partyId')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("updateLeadForm_companyName")).clear();
			String newComapnyName = "Tre";
			driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(newComapnyName);
			driver.findElement(By.xpath("//input[@value='Update']")).click();
			Thread.sleep(1000);
			String[] updatedCompanyName = driver.findElement(By.id("viewLead_companyName_sp")).getText().split(" ");
			System.out.println(Arrays.toString(updatedCompanyName));
			if(updatedCompanyName[0].contains(newComapnyName))
				System.out.println("company name updated properly : "+updatedCompanyName[0]);
			else
				System.out.println("company name is not updated properly : "+updatedCompanyName[0]);
			
			
			
		}
		else
		{
			System.out.println(searchResult);
		}
			driver.close();

	}

}
