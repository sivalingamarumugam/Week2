package week2.day2.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Classroom2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		// grandparent to grandchildren
		driver.findElement(By.xpath("(//form[@id='login']//input)[1]")).sendKeys("DemosalesManager");
		driver.findElement(By.xpath("(//form[@id='login']//input)[2]")).sendKeys("crmsfa");
		driver.findElement(By.xpath("(//form[@id='login']//input)[3]")).click();
		//parent to child
		driver.findElement(By.xpath("(//div[@id='label']/a)[1]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
		driver.findElement(By.xpath("//a[text()='Merge Leads']")).click();
		driver.findElement(By.xpath("//input[@name='ComboBox_partyIdFrom']")).sendKeys("10007");
		driver.findElement(By.xpath("//input[@name='ComboBox_partyIdTo']")).sendKeys("10009");
		driver.findElement(By.xpath("//a[@class='buttonDangerous' and contains(@href,'opentaps')]")).click();
		 
	}

}
